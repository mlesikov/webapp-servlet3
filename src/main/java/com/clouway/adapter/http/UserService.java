package com.clouway.adapter.http;

import com.clouway.core.UserAlreadyExistsException;
import com.clouway.core.User;
import com.clouway.core.UserRepository;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.client.transport.Json;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Request;
import com.google.sitebricks.http.Delete;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.Post;

import java.net.HttpURLConnection;
import java.util.List;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
@At("/users")
public class UserService {

  private final UserRepository userRepository;

  @Inject
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Get
  public Reply<?> getUsers(Request request) {
    Multimap<String, String> params = request.params();

    List<User> users;
    if (params.containsKey("ids")) {
      users = userRepository.findByIds(params.get("ids"));
    } else {
      users = userRepository.findAll();
    }

    return Reply.with(users).as(Json.class);
  }

  @Post
  public Reply<?> registerUser(Request request) {
    User user = request.read(User.class).as(Json.class);

    try {
      userRepository.register(user);
    } catch (UserAlreadyExistsException e) {
      return Reply.saying().badRequest();
    }
    return Reply.saying().status(HttpURLConnection.HTTP_CREATED);
  }

  @Delete
  @At("/:userName")
  public Reply<?> deleteUser(@Named("userName") String name) {

    userRepository.deleteUserByName(name);

    return Reply.saying().ok(); // status 200
  }

}
