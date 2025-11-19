//create table emp101 (name varchar2(100), name varchar2(100));
// insert into emp101 values ('lalu', 'rabari');

import java.sql.*;
public class TestRetrive1
{
  public static void main(String[] args)
  {
    try
    {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "hellyeah5285");
      Statement s = c.createStatement();
      ResultSet result1 = s.executeQuery("select * from emp101");
      
      while(result1.next())
      {
        System.out.println(result1.getString("name")+"="+result1.getString(2));
      }
    }catch(SQLException e){
      System.out.println(e);
    } 
    catch(Exception i) { System.out.println(i); }
  }
}

//C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar
   // javac -cp ".;C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar" TestRetrive1.java
   // java  -cp ".;C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib\ojdbc14.jar" TestRetrive1

//jar xf ojdbc.jar  (will unpack all files (class files, META-INF, etc.) into the current directory.)
   //copy the jar file in current directory explicitly first and than run this command
   // => jar xf ojdbc14.jar    =>  javac TestRetrive1.java   =>   java -cp . TestRetrive1
        //You do not need to extract the jar to run JDBC. Normally you simply reference the jar on the classpath (see -cp commands at notes).
