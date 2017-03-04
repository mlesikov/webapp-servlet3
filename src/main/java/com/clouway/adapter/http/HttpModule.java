package com.clouway.adapter.http;

import com.clouway.adapter.memory.InMemoryUserRepository;
import com.clouway.core.UserRepository;
import com.google.inject.Singleton;
import com.google.sitebricks.SitebricksModule;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class HttpModule extends SitebricksModule {
  @Override
  protected void configureSitebricks() {
    bind(UserRepository.class).to(InMemoryUserRepository.class).in(Singleton.class);
    at("/users").serve(UserService.class);
    at("/_status").serve(StatusService.class);
  }
}