import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class MySqlServlet extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
res.setContentType("text/html");
  
  PrintWriter out = res.getWriter();
out.println("<html><body>");
String name=req.getParameter("name");
  String pass=req.getParameter("pass");
try
{
Class.forName("com.mysql.jdbc.Driver");
	
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/codesquadz", "codesquadz", "codesquadz");
Statement s = c.createStatement();
String  s1="select * from emp101  where   name='"+name+"'  and pass='"+pass+"'";
//out.println(s1);
ResultSet rs=s.executeQuery(s1);
if(rs.next())
out.println("User is Valid");
else
out.println("User is InValid");
ResultSet result1=s.executeQuery("select * from emp101");

while(result1.next())
{
out.println( result1.getString("name")+"="+ result1.getString(2));


}
}catch(Exception e){out.println(e);}     

out.println("</body></html>");
	
}

}






