package com.clouway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class MainPageView extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = (User) req.getAttribute("user");
    PrintWriter writer = resp.getWriter();

    writer.println("<html><head></head><body>Hello, " + user.name + "</body></html>");
    writer.flush();
  }
}
