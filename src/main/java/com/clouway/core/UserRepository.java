package com.clouway.core;

import java.util.Collection;
import java.util.List;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public interface UserRepository {

  List<User> findAll();

  void register(User user);

  void deleteUserByName(String name);

  List<User> findByIds(Collection<String> ids);
}
