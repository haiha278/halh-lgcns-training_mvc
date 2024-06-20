package com.training.springmvc.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        //register our config class
        annotationConfigWebApplicationContext.register(ApplicationContextConfig.class);
        servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));
        //using servlet 3 api to dynamically create
        //spring dispatcher servlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc", new DispatcherServlet(annotationConfigWebApplicationContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
