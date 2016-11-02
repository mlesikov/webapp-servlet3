package com.clouway;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class LoginPageView extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    writer.println("<html><head></head><body><form method='POST' action='login'><input type='submit' value='Login'/></form></body></html>");
    writer.flush();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie sessionCookie = new Cookie("MYSESSIONID", new Random().nextInt(123) + "-" + UUID.randomUUID().toString());
    sessionCookie.setPath("/");

    resp.addCookie(sessionCookie);
    resp.sendRedirect("/main");
  }
}
