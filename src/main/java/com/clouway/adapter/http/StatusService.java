package com.clouway.adapter.http;

import com.google.sitebricks.At;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
@Service
@At("/_status")
public class StatusService {

  @Get
  public Reply<?> getStats() {
    return Reply.with("OK");
  }
}