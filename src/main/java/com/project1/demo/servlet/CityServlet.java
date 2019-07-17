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
        PrintWriter pw = response.getWriter();
       pw.println("Hello from my cities!!!");
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
