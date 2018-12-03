package controllers;

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

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import models.*;

public class LoginController implements ControllerInerface {

      @Override
      public void getMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();          
            System.out.println(request.getParameter("userName"));
            if (request.getParameter("userName") != null) {

                  String userName = request.getParameter("userName");
                  String password = request.getParameter("password");

                  PersonFactory personFactory = new PersonFactory();
                  if (userName.length() >= 11) {
                        Person person1 = personFactory.getPerson("FACULTY");
                        if (person1.login(userName, password)) {
                              person1.setName(userName);
                              person1.setName(password);
                              request.setAttribute("userName", userName);
                              System.out.println(person1.getFirstName());
                              request.getRequestDispatcher("/WEB-INF/views/faculty.jsp").forward(request, response);
                        } else {
                              request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
                        }
                  } else if (userName.length() <= 10) {
                        Person person2 = personFactory.getPerson("STUDENT");

                        if (person2.login(userName, password)) {
                              person2.setName(userName);

                              System.out.println(person2.getFirstName());
                              request.getRequestDispatcher("/WEB-INF/views/student.jsp").forward(request, response);
                        } else {
                              request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
                        }                       
                  }               
            }

            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
      }

}