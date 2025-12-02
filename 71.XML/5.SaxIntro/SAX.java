/* When you call p.parse(new File("students.xml"), new SAX()), the SAX parser reads the XML file and, as it encounters different parts of the 
XML (start of document, elements, text, end of document, etc.), it triggers the corresponding methods in your handler class 
(which extends DefaultHandler). This is known as the "callback" mechanism.   */


import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class SAX extends DefaultHandler {

    public static void main(String arr[]) {
        try {
            SAXParserFactory f = SAXParserFactory.newInstance();
            SAXParser p = f.newSAXParser();
            p.parse(new File("students.xml"), new SAX());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void startDocument() throws SAXException { // it get's called automatically when you, when parser reads the file (p.parse()).
        System.out.println("document parsing started...");
    }

    public void endDocument() throws SAXException {  //after the entire document is read, endDocument() is called.
        System.out.println("document parsing ended...");
    }

    public void startElement(String uri, String sname, String qname, Attributes attr) throws SAXException {  // for each XML element, startElement() is called,
        System.out.println(qname + " is an element");
        int len = attr.getLength();
        for (int i = 0; i < len; i++) {
            System.out.println("attribute name:" + attr.getQName(i));
            System.out.println("value:" + attr.getValue(i));
        }
    }

    public void characters(char buf[], int offset, int len) throws SAXException { // for text content inside elements, characters() is called,
        String s = new String(buf, offset, len);
        System.out.println("value is:" + s);
    }

}