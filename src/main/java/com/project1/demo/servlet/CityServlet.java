package com.project1.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
       pw.println("Hello from my cities!!!");
        pw.println("!doctype html");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>List of cities</title>");
        pw.println("<meta charset =\"utf-8\">");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h2>Some examples of cities</h2>");
        pw.println("<ol>");
        pw.println("<h2>Some examples of cities</h2>");
        pw.println("<li>Paris</li>");
        pw.println("<li>Berlin</li>");
        pw.println("<li>Madrid</li>");
        pw.println("</ol>");
        pw.println("</body>");
        pw.println("</html>");


//        <!doctype html>
//<html>
//    <head>
//<title>List of cities</title>
//<meta charset ="utf-8">
//    </head>
//
//    <body>
//<h2>Some examples of cities</h2>
//
//<ol>
//<li>Paris</li>
//<li>Berlin</li>
//<li>Madrid</li>
//<li>Drezden</li>
//<li>Rome</li>
//</ol>
//
//    </body>
//</html>

    }
}
