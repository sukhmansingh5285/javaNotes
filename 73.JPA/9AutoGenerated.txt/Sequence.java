import java.sql.*;
import java.io.*;

class Sequence
{
  public static void main(String[] ss)
  {
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jpa", "jpa");
      Statement s = c.createStatement();
      s.executeUpdate("create sequence jpasec70 increment by 1 start with 100");
      // s.executeUpdate("drop table emp22");
      // s.executeUpdate("drop table emp22");
      // s.executeUpdate("drop table emp22");
      s.close();
    } catch(Exception e){
      System.out.println(e);
    }
  }
}