package com.clouway.security;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class Session {
  public final String sessionId;
  public final Long userId;

  public Session(String sessionId, Long userId) {
    this.sessionId = sessionId;
    this.userId = userId;
  }
}
