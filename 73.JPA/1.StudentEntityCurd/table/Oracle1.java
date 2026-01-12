// These files are not JPA. They are the "before" picture. They show how much manual work (creating connections, 
// writing raw CREATE TABLE strings) is required without a framework. We run these once to set up our playground.

import java.sql.*;
import java.io.*;
class Oracle1
{
	public static void main(String []ss)
	{
System.out.println("hhhhhhhh");
		try{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","hellyeah5285");
Statement s = c.createStatement();
s.executeUpdate("create table student2(id number,lastname varchar(20),firstname varchar(20),email varchar(20))" );
System.out.println("table created ");
s.close();
}catch(Exception e){ System.out.println(e);}
}
}
		
		











