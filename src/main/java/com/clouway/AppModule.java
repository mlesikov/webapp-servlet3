package com.clouway;

import com.clouway.adapter.http.UserService;
import com.clouway.adapter.memory.InMemoryUserRepository;
import com.clouway.core.UserRepository;
import com.google.inject.Singleton;
import com.google.sitebricks.SitebricksModule;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
class AppModule extends SitebricksModule {
  @Override
  protected void configureSitebricks() {
    bind(UserRepository.class).to(InMemoryUserRepository.class).in(Singleton.class);
    at("/users").serve(UserService.class);
  }
}
