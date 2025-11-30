//Normalize the root elements of the XML document. This ensures that all Text nodes under the root node are put
//into a "normal" from, which means that there are neither adjacent Text nodes nor empty Text nodes in the document.

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

class ReadXMLFile
{
  public static void main(String[] args)
  {
    try{
      File fXmlFile = new File("staff.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);
      Element e=doc.getDocumentElement();

      e.normalize();

      System.out.println("root element: "+e.getNodeName());
      NodeList nList = doc.getElementsByTagName("staff");
      System.out.println(nList.getLength());
      System.out.println("-------------------");

      for(int temp=0; temp<nList.getLength(); temp++)
      {
        Node nNode = nList.item(temp);
        System.out.println("\nCurrent Element: "+nNode.getNodeName());
        Element element = (Element) nNode;

        NodeList List1 = element.getElementsByTagName("firstname");
        Node d = List1.item(0);
        System.out.println("First Name: "+d.getTextContent());

        System.out.println("Last Name: "+element.getElementsByTagName("lastname").item(0).getTextContent());
        System.out.println("Nick Name: "+element.getElementsByTagName("nickname").item(0).getTextContent());
        System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());
      }
    } catch(Exception e) {    }
  }
}