// To implement OracleDriver  , 3rd way => just use run-time polymorphism, driver will get built, and object get created
//                  you will get the register function, and other connection functions.
// use Properties object to keep a lot's of data at one place

import java.sql.*;
import java.util.*;

class TestUpdate
{
  public static void main(String[] args)
  {
    try
    {
      Driver d = new oracle.jdbc.driver.OracleDriver();
      Properties dbProp = new Properties();
      dbProp.put("user", "system");
      dbProp.put("password", "hellyeah5285");
      Connection c = d.connect("jdbc:oracle:thin:@localhost:1521:xe", dbProp);
      
      String z = "bmwx4";
      String t4 = "10004";

      Statement s = c.createStatement();
      int z1 = s.executeUpdate("update emp101 set pass='"+z+"' where name='"+t4+"'");
      System.out.println(z1);
      ResultSet result1 = s.executeQuery("select * from emp101 where name='"+t4+"'");

      while(result1.next())
      {
        System.out.println(result1.getString(1));
        System.out.println(result1.getString(2));
      }
    } catch(SQLException e)
    {
      System.out.println(e);
    } catch(Exception i)
    {
      System.out.println(i);
    }
  }
}