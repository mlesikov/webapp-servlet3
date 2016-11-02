package com.clouway;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class Jetty {

  private final Server server;

  public Jetty(int port) {
    this.server = new Server(port);
  }

  public void start() {
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    context.addEventListener(new ServletContextListener() {
      public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.addFilter("/*", new SecurityFilter("/login", "MYSESSIONID"));
        servletContext.addServlet("LoginPageController", new LoginPageView()).addMapping("/login");

        servletContext.addServlet("MainPageController", new MainPageController()).addMapping("/main");
        servletContext.addServlet("MainPageView", new MainPageView()).addMapping("/mainPageView");

        servletContext.addServlet("TransactionsPageController", new TransactionsPageController()).addMapping("/transactions");
      }

      public void contextDestroyed(ServletContextEvent servletContextEvent) {

      }
    });

    server.setHandler(context);
    try {
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
