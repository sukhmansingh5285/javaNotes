import java.sql.*;
import java.util.*;

class TestDelete
{
  public static void main(String[] args)
  {
    try
    {
      System.setProperty("jdbc.drivers", "oracle.jdbc.driver.OracleDriver"); // System.setProperty does: sets a JVM-wide string property at runtime (System.getProperty 
      // will return it). It does not itself load classes or instantiate drivers. DriverManager is going to read the property and then call Class.forName internally.
      Properties dbProp = new Properties();
      dbProp.put("user", "system");
      dbProp.put("password", "hellyeah5285");

      Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", dbProp);
      String t5 = "10004";
      Statement s = c.createStatement();

      int a = s.executeUpdate("delete from emp101 where name = '"+t5+"'");
      System.out.println(a);  

      ResultSet result1 = s.executeQuery("select * from emp101");

      while(result1.next())
      {
        System.out.println(result1.getString(1) +" = "+result1.getString(2));
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