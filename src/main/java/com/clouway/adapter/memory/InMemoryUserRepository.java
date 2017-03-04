package com.clouway.adapter.memory;

import com.clouway.core.UserAlreadyExistsException;
import com.clouway.core.User;
import com.clouway.core.UserRepository;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class InMemoryUserRepository implements UserRepository {

  private List<User> users = Lists.newArrayList();

  public List<User> findAll() {
    return users;
  }

  public void register(User user) {
    for (User each : users) {
      if (each.getName().equalsIgnoreCase(user.getName())) {
        throw new UserAlreadyExistsException();
      }
    }

    users.add(user);
  }

  public void deleteUserByName(String name) {
    for (User each : users) {
      if (each.getName().equalsIgnoreCase(name)) {
        users.remove(each);
        break;
      }
    }
  }

  public List<User> findByIds(Collection<String> ids) {
    return Lists.newArrayList(new User("Test User", 12), new User("Dummy User", 24));
  }
}
