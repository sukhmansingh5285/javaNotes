import java.sql.*;
import java.io.*;
class Oracle2
{
	public static void main(String []ss)
	{
System.out.println("hhhhhhhh");
		try{
Class.forName("com.mysql.jdbc.Driver");
	
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/jpa","jpa","jpa");
Statement s = c.createStatement();
s.executeUpdate("create table student2(id integer,lastname varchar(20),firstname varchar(20),email varchar(20))" );
System.out.println("table created ");
s.close();
}catch(Exception e){ System.out.println(e);}
}
}
		
		











