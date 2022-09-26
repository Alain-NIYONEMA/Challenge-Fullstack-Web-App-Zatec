# Technical Documentation

## # Programming languages:
* Java (for Backend)
* Javascript (Fetch API & Frontend)
* HTML & CSS (UI Frontend)


## # System Requirements
* JDK 11 ↑
* Tomcat server 9.0 ↑
* Maven


## # Project Structure
![](/docs/screenshots/structure-1.jpg)


#### - Java Backend
Structure for the backend

![](/docs/screenshots/structure-2.jpg)


#### - Unit Testing
Structure for Testing
![](/docs/screenshots/structure-3.jpg)


#### - Frontend
Structure for the frontend

![](/docs/screenshots/structure-4.jpg)


#### - Frontend - API fetch
Code responsible for fetching API from the backend

![](/docs/screenshots/structure-5.jpg)


#### - Frontend - components
Custom components designed to render the UI

![](/docs/screenshots/structure-6.jpg)


## # API

Here the Frontend doesn't communicate with 3rd party (external api) directly.
But we have a built-in API which is accessible through a custom end point.
For instance, in a localhost environment: http://localhost:8080/ztc-alain/api

This the WebServlet responsible to handle client requests
![](/docs/screenshots/structure-7.jpg)

Get method is used to retrieves houses
![](/docs/screenshots/structure-8.jpg)

Post method is used to search for houses
![](/docs/screenshots/structure-9.jpg)

This is an example of a result
![](/docs/screenshots/response-1.jpg)

### # API - Parameters
* #### name (String):
Is used as a keyword parameter to filter houses by name or to search for houses containing that specific keyword.

* #### match (boolean, default=false):
When true, it specifies whether to search for houses which exactly fully match the keyword, or partially matches when is false.

* #### filter (string, allowed='' for titles, 'region', 'all'):
This specifies where to search from, if it is to look up under titles only, or by regions only or the whole contents

* #### page (integer, default=1):
You specify which page you want to access with the ?page parameter, if you don't provide the ?page parameter the first page will be returned.

* #### pageSize (integer, default=10):
You can also specify the size of the page with the ?pageSize parameter, if you don't provide the ?pageSize parameter the default size of 10 will be used.


## # External Libraries
A list of open-source Java libraries used:
* ### javax.servlet
Java Servlet is the foundation web specification in the Java Enterprise Platform. Developers can build web applications using the Servlet API to interact with the request/response workflow.
https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api

* ### org.springframework
Spring Web provides integration features such as multipart file upload functionality and the initialization of the IoC container using Servlet listeners and a web-oriented application context. It also contains an HTTP client and the web-related parts of Spring remote support.
https://mvnrepository.com/artifact/org.springframework/spring-web

* ### com.google.code.gson
Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.
https://mvnrepository.com/artifact/com.google.code.gson/gson

* ### org.junit.jupiter
JUnit Jupiter is the API for writing tests using JUnit 5.
https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
