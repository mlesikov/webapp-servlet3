package com.clouway;

/**
 * @author Miroslav Genov (miroslav.genov@clouway.com)
 */
public class App {

  public static void main(String[] args) {
    Integer httpPort = 8080;
    Jetty jetty = new Jetty(httpPort);
    jetty.start();

    System.out.printf("Jetty is up and running on port: %d", httpPort);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.printf("Jetty is going to shutdown.");
      try {
        jetty.stop();
      } catch (Exception e) {
        System.out.println("Failed to stop server due: " + e.getMessage());
      }
      System.out.printf("Jetty goes down.");
    }));
  }
}
