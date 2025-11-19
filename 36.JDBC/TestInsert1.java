// we always load OracleDriver and it implements Driver, it passes the oracleDriver object to DriverManager using
// registerDriver() method., and another method which is getConnection.
// To implement OracleDriver  , 2nd way => directly pass oracle driver instance to DriverManager

import java.sql.*;
import java.io.*;
import java.util.*;

public class TestInsert1 {
  public static void main(String[] args) {
    try {
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "hellyeah5285");
      String t1 = "10004";
      String t2 = "hector";
      Statement s = c.createStatement();
      int x = s.executeUpdate("insert into emp101 values ('" + t1 + "', '" + t2 + "')");
      System.out.println(x);  //this value represents the numbers of rows that got affected
      ResultSet result1 = s.executeQuery("select * from emp101");

      while (result1.next()) {
        System.out.println(result1.getString(1));
        System.out.println(result1.getString(2));
      }
    } catch (SQLException e) {
      System.out.println(e);
    } catch (Exception i) {
      System.out.println(i);
    }
  }
}


// int x=s.executeUpdate("update emp set name='"+z+"' where id="+t4);