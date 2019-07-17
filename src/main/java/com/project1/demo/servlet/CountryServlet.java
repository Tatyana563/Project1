package com.project1.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CountryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        PrintWriter pw = response.getWriter();
        pw.println("Hello from my country!");
//        <!doctype html>
//<html>
//    <head>
//<title>List of countries</title>
//<meta charset ="utf-8">
//    </head>
//
//    <body>
//
//        <h3>Full list of countries</h3>
//        <p align="justify"><i> Detailed information for the countries listed below can be found in the table below.</i></p>
//
//
//  <ol>
//<li>Italy</li>
//<li>Spain</li>
//<li>France</li>
//<li>Germany</li>
//</ol>
// <table border="1" weidth="800" height="400" align="center">
//<caption><b><em>European countries</b></em></caption>
//<tr>
//<th>country_name</th>
//<th>language</th>
//<th>currency</th>
//<th>population</th>
//<th>id</th>
//<th>area</th>
//</tr>
//
//<tr>
//<td>Check Republic</td>
//<td>English</td>
//<td>EUR</td>
//<td>265.90</td>
//<td>2</td>
//<td>204.6</td>
//</tr>
//
//<tr>
//<td>Germany</td>
//<td>German</td>
//<td>DM</td>
//<td>82.79</td>
//<td>1</td>
//<td>130.5</td>
//</tr>
//</table>
//    </body>
//</html>


    }
}
