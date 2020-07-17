# Running Spring application as a GraalVm Native Image
  This repository contains the template for using native image mechanism provided by GraalVm. To demonstrate such a behavior
  we are going to create a small spring boot Application. In the application we will just see how can we communicate
  between using a simple /Get endpoint. We show this through a RestController. For graal vm native images we will need few
  additional dependencies to be added to our project like: repositories, project repositories, maven native-image plugin
  , and etc. For more details on what all we will need in this you can go through the 
  blog: https://blog.knoldus.com/running-spring-boot-application-as-native-image/. 

## Aim
The aim of this template is to run the application in 3 different running modes and then see how the native image running 
on the graalVm fastens the service startup time. With every run mode we can check that our service is running by accessing:

`localhost:8080/users/admin`

Let us now see the different run modes and how to run the application using them. Attached are some logs from the console
 when the service starts so that we can see and compare the startup time for our applications.
 
##Run mode 1: Running as a simple java application, use:
`mvn clean spring-boot:run`

In the logs output we can see the following at the end.

2020-07-17 18:34:05.928  INFO 25038 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-07-17 18:34:05.938  INFO 25038 --- [           main] c.k.s.SpringBootAndGraalvmApplication    : Started SpringBootAndGraalvmApplication in 1.876 seconds (JVM running for 2.264)

##Run mode 2: Running the native-image on JVM.
```
   mvn -DskipTests=true clean package
   export META=src/main/resources/META-INF
   mkdir -p $META 
   java -agentlib:native-image-agent=config-output-dir=${META}/native-image -jar target/YOUR_APP.jar
```
In the logs output we can see the following at the end.

2020-07-17 18:37:45.378  INFO 25665 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-07-17 18:37:45.399  INFO 25665 --- [           main] c.k.s.SpringBootAndGraalvmApplication    : Started SpringBootAndGraalvmApplication in 4.089 seconds (JVM running for 4.818)

##Run mode 3: Running the native image on GraalVm.
```
1) mvn -Pgraal clean package
2) ./target/com.knoldus.springbootandgraalvm.springbootandgraalvmapplication 

```

In the logs output we can see the following at the end.

2020-07-17 18:43:09.105  INFO 26340 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-07-17 18:43:09.108  INFO 26340 --- [           main] c.k.s.SpringBootAndGraalvmApplication    : Started SpringBootAndGraalvmApplication in 0.238 seconds (JVM running for 0.248)

##### The log for Run Mode 3 shows a huge improvement in the startup time of our application.

## That is all about the working of this repository, suggestions and improvements are most welcome. :shipit:

