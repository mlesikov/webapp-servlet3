#### Jetty + Servlet 3 API Binding(Gradle)

Starts jetty programatically using pure servlet api binding. It’s always been possible to do this with Jetty’s APIs. Now it’s possible for webapp packaged as a WAR.


To pack app into executable jar you have to execute:

```sh
gradle clean shadowJar
```

Then run the app: 
```sh
java -jar build/libs/webapp-all.jar
```

Test the app :
```
http://localhost:8080/_status
```