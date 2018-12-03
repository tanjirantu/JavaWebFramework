import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.lang.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParser {

      public NodeList getViewPath() {

        try {

              File inputFile = new File("C:/Users/Tanjir/Desktop/JSTL/apache-tomcat-9.0.6-windows-x64/apache-tomcat-9.0.6/webapps/framework/WEB-INF/core/routes.xml");

              DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
              DocumentBuilder db = dbf.newDocumentBuilder();
              Document doc = db.parse(inputFile);
              doc.getDocumentElement().normalize();

              NodeList nList = doc.getElementsByTagName("mvc");
              return nList;
        } catch (Exception e) {
              e.printStackTrace();
        }

        return null;
    }
}