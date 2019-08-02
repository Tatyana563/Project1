package com.project1.demo.config;

import com.project1.demo.servlet.CityServlet;
import com.project1.demo.servlet.CountryServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
@Configuration
public class WebServeletConf {
    @Bean
    public ServletRegistrationBean<HttpServlet> countryServelet(){
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new CountryServlet());
        servRegBean.addUrlMappings("/country/*");
        servRegBean.setLoadOnStartup(1);
        return  servRegBean;
    }
    @Bean
    public ServletRegistrationBean<HttpServlet> cityServlet(){
        ServletRegistrationBean<HttpServlet> servRegBeanCity = new ServletRegistrationBean<>();
        servRegBeanCity.setServlet(new CityServlet());
        servRegBeanCity.addUrlMappings("/city/*");
        servRegBeanCity.setLoadOnStartup(1);
        return servRegBeanCity;
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
