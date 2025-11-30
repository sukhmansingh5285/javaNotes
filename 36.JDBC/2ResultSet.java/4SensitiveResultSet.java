/*Seeing External Changes
Only a scroll-sensitive result set can see external changes to the underlying database, and it can only see the changes from external UPDATE operations. Changes from external DELETE or INSERT operations are never visible.*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class SensitiveResultSet {
	public static void main(String a[]){
		Statement st = null;
		Statement st1 = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hellyeah5285");
			DatabaseMetaData dbmd = con.getMetaData();
			//System.out.println("Supports HOLD CURSORS OVER COMMIT? " + dbmd.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
			boolean b = dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
			System.out.println(b);
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			st.setFetchSize(1);
			MyThread1 t1 = new MyThread1(st, st1);
			t1.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class MyThread1 extends Thread {
	Statement st;
	Statement st1;
	ResultSet rs;
	MyThread1(Statement st, Statement st1) {
		this.st = st;
		this.st1 = st1;
	}
	public void run() {
		try {
			rs = st.executeQuery("select accno, bal from bank1");
			while(rs.next()) {
				System.out.print("accno " + rs.getString(1) + "=");
				System.out.print("bal " + rs.getString(2));
				System.out.println("  ");
			}
			MyThread2 t2 = new MyThread2(st1);
			t2.start();
			try {
				t2.join();
			} catch (Exception e) { }
			rs.beforeFirst();
			System.out.println("after changes");
			while(rs.next()) {
				System.out.print("accno " + rs.getString(1) + "=");
				System.out.print("bal " + rs.getString(2));
				System.out.println("  ");
			}
		} catch (Exception e) { System.out.println(e); }
	}
}

class MyThread2 extends Thread {
	Statement st;
	MyThread2(Statement st) {
		this.st = st;
	}
	public void run() {
		try {
			st.execute("UPDATE bank1 SET bal=bal+500");
			st.execute("COMMIT"); //this also works other than the 'connection.commit();'
			st.close();
			System.out.println("record updated");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


/* The confusion arises because transaction management (like committing) is tied to the database connection, not individual statements. Here's a breakdown:

-> Both st and st1 are created from the same Connection object (con). This means they share the same transaction context.
-> When st1 executes COMMIT, it commits the entire transaction for the connection. Normally, this would close all open result sets from that connection.
-> However, the result set rs is created from st, which was explicitly set with ResultSet.HOLD_CURSORS_OVER_COMMIT. This tells JDBC to keep rs open even after 
a commit on the same connection.
-> If st1 had created its own result set, that result set would close on commit (since st1 doesn't specify holdability, it defaults to CLOSE_CURSORS_AT_COMMIT). 
But here, st1 is only used for the update and commit, so it doesn't affect rs directly—except through the shared transaction.

In short: The commit from st1 affects the connection's transaction, but rs (from st) is protected by its holdability setting. This allows MyThread1 to 
continue accessing rs after the commit. If you removed HOLD_CURSORS_OVER_COMMIT, rs would close after the commit, and the second loop in MyThread1 would fail. */