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
import java.lang.reflect.Constructor;

public interface ControllerInerface {

    void getMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}