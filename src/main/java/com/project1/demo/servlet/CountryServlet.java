package com.project1.demo.servlet;

import com.project1.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CountryServlet extends HttpServlet {

    @Autowired
    private CountryService countryService;
    private WebApplicationContext context;

    @Override
    public void init(final ServletConfig config ) throws ServletException {
        super.init(config);
        context=
                WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {

            pw.println("<h2>Some examples of countries</h2>");
            pw.println("<ol>");
            pw.println("<h2>Some examples of cities</h2>");
            pw.println("<li>Germany</li>");
            pw.println("<li>Italy</li>");
            pw.println("<li>Spain</li>");
            pw.println("</ol>");
        }
        finally {
            pw.close();
        }
    }
}
