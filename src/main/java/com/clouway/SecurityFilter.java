package com.clouway;

import com.clouway.security.Session;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class SecurityFilter implements Filter {
  private final String loginEndpoint;
  private final String sessionIdName;

  public SecurityFilter(String loginEndpoint, String sessionIdName) {
    this.loginEndpoint = loginEndpoint;
    this.sessionIdName = sessionIdName;
  }

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    if (loginEndpoint.equalsIgnoreCase(request.getRequestURI())) {
      filterChain.doFilter(servletRequest, servletResponse);
      return;
    }

    Session session = findSession(request);
    if (session == null) {
      response.sendRedirect(loginEndpoint);
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }

  public void destroy() {

  }

  // get session from db
  private Session findSession(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      return null;
    }
    for (Cookie each : cookies) {
      if (sessionIdName.equalsIgnoreCase(each.getName())) {
        String sessionId = each.getValue();
        // TODO(mgenov): add db call to retrieve session by id

        return new Session(sessionId, 1L);
      }
    }
    return null;
  }
}
