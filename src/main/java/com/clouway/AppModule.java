package com.clouway;

import com.clouway.adapter.http.HttpModule;
import com.google.inject.AbstractModule;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
class AppModule extends AbstractModule{

  @Override
  protected void configure() {
    install(new HttpModule());
  }
}
