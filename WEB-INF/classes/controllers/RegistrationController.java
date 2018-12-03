package controllers;
import models.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class RegistrationController implements ControllerInerface {


      @Override
      public void getMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();  
            HttpSession session = request.getSession();  

            String btn1 = request.getParameter("Next");
 
			if (btn1 != null && btn1.equals("Submit")) {  
				
				session.setAttribute("organizationalId", request.getParameter("organizationalId"));
				session.setAttribute("firstName", request.getParameter("firstName"));
				session.setAttribute("lastName", request.getParameter("lastName"));
				session.setAttribute("email", request.getParameter("email"));
			    request.getRequestDispatcher("/WEB-INF/views/registration2.jsp").forward(request, response);	
			}     

			String btn2 = request.getParameter("Register");

			if (btn2 != null && btn2.equals("Submit")) {  
				session.setAttribute("address", request.getParameter("address"));
				session.setAttribute("phoneNo", request.getParameter("phoneNo"));
				session.setAttribute("password", request.getParameter("password"));
				System.out.println("Page:" + request.getParameter("password"));

				PersonFactory personFactory = new PersonFactory();
				Person person1 = personFactory.getPerson("FACULTY");
				person1.setOrganizationalId(session.getAttribute("organizationalId").toString());
				person1.setName(session.getAttribute("firstName").toString());
				person1.setLastName(session.getAttribute("lastName").toString());
				person1.setEmail(session.getAttribute("email").toString());
				person1.setHomeAdd(session.getAttribute("email").toString());
				person1.setPhoneNo(session.getAttribute("phoneNo").toString());
				person1.setPassword(session.getAttribute("password").toString());
				System.out.println("GET" + person1.getPassword());
				String organizationalId = person1.getOrganizationalId();
				
				String firstName = person1.getFirstName();
				String lastName = person1.getLastName();
				String email = person1.getEmail();
				String address = person1.getHomeAdd();
				String phoneNo = person1.getPhoneNo();
				String password = person1.getPassword();
				person1.register(organizationalId, firstName, lastName, email, address, phoneNo, password);
				

			}
            
            request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
      }
}