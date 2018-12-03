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
import java.lang.reflect.Constructor;
import controllers.ControllerInerface;

public class GlobalController extends HttpServlet {

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String url = request.getPathInfo();
            
            Router router = new Router(url);

            try {

                  Class<?> clazz = Class.forName("controllers." + router.getController());
                  Constructor<?> ctor = clazz.getConstructor();
                  Object object = ctor.newInstance();
                  ControllerInerface hui = (ControllerInerface)object;
                  hui.getMethod(request, response);
   
            } catch (Exception e) {
                  e.printStackTrace();
            }        
      }
}