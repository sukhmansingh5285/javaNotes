
import java.sql.*;

public class MyBatchPreparedStmt {
	public static void main(String a[]) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "mca6");
			Statement s = con.createStatement();
			pst = con.prepareStatement("update emp101 set name=? where pass=?");
			pst.setString(1, "Gadar4");
			pst.setString(2, "Gadar2");
			pst.addBatch();
			pst.setString(1, "jaddu40");
			pst.setString(2, "jaddu");
			pst.addBatch();
			int count[] = pst.executeBatch();
			ResultSet result1 = s.executeQuery("select * from emp101");
			while(result1.next()) {
				System.out.println("Name" + result1.getString(1));
				System.out.println("Pass " + result1.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


// general syntax, batch statement with prepareStatement (for insert)
/*
PreparedStatement ps = con.prepareStatement(
"INSERT INTO emp101(name, pass) VALUES (?, ?)"
);
ps.setString(1, "alice"); ps.setString(2, "pwd1"); ps.addBatch();
ps.setString(1, "bob"); ps.setString(2, "pwd2"); ps.addBatch();
ps.setString(1, "carol"); ps.setString(2, "pwd3"); ps.addBatch();
int[] counts = ps.executeBatch();
*/