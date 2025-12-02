import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class PrintDataBasewithXML {
  public static void main(String[] args) {
    try {
      File file = new File("jdbc.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(file);
      Element e = doc.getDocumentElement();
      e.normalize();

      NodeList dataBaseInfo = e.getElementsByTagName("OracleData");
      Element element = (Element) dataBaseInfo.item(0);

      String driver = element.getElementsByTagName("driver").item(0).getTextContent();
      String url = element.getElementsByTagName("url").item(0).getTextContent();
      String username = element.getElementsByTagName("username").item(0).getTextContent();
      String pass = element.getElementsByTagName("pass").item(0).getTextContent();
      String tableName = element.getElementsByTagName("tablename").item(0).getTextContent();

      Class.forName(driver);
      Connection c = DriverManager.getConnection(url, username, pass);
      Statement s = c.createStatement();
      ResultSet rs = s.executeQuery("select * from " + tableName);

      while (rs.next()) {
        System.out.println("First Name: " + rs.getString(1) + ". Password: " + rs.getString(2) + ".");
      }

      rs.close();
      s.close();
      c.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
