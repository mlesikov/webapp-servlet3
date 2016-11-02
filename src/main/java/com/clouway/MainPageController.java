package com.clouway;

import com.clouway.security.Session;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
class MainPageController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Session session = findSession(req);
    if (session == null) {
      resp.sendRedirect("/login");
    }


    User john = new User("John");

    req.setAttribute("user", john);

    req.getRequestDispatcher("/mainPageView").forward(req, resp);
  }

  // get session from db
  private Session findSession(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      return null;
    }
    for (Cookie each : cookies) {
      if ("MYSESSIONID".equalsIgnoreCase(each.getName())) {
        String sessionId = each.getValue();
        // TODO(mgenov): add db call to retrieve session by id

        return new Session(sessionId, 1L);
      }
    }
    return null;
  }
}
