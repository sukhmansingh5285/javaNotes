// use db.properties to store data, so that you have to change the database than change the db.properties
// use Properties class from util package
// To implement OracleDriver  , 1st way -> Class.forName(). 

import java.sql.*;
import java.io.*;
import java.util.*;

class TestRetrive2
{
  public static void main(String[] args)
  {
    try
    {
      FileInputStream fn = new FileInputStream("db.properties");
      Properties pr = new Properties();
      pr.load(fn);      // so that properties object could read the file content
      //getProperty -> returns string or null(if string isn't there, you can also pass a default string in case of null is returned as second argument)
      String driver = pr.getProperty("driver");
      String url = pr.getProperty("url");
      String user = pr.getProperty("user");
      String pass = pr.getProperty("pass");

      Class.forName(driver);
      Connection c = DriverManager.getConnection(url, user, pass);
      Statement s = c.createStatement();
      ResultSet result1 = s.executeQuery("select * from emp101");

      while(result1.next())
      {
        System.out.println(result1.getString(1) +"="+ result1.getString(2));
      }
    } catch(SQLException e)
    {
      System.out.println(e);
    } catch(Exception i) {System.out.println(i); }
  }
}