package com.clouway.core;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class User {
  private String name;
  private int age;

  @SuppressWarnings("unused")
  User() {
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
