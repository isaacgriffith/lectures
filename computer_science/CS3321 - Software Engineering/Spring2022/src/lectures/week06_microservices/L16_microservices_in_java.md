---
author:
- Dr. Isaac Griffith
title: Java Microservices
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* \small Have a basic understanding of the Networking principles upon which Microservices rest

\vskip0.5em

* \small Have a basic understanding of the concepts of RESTful services

\vskip0.5em

* \small Have a basic understanding of how to use Javalin to implement a RESTful Microservice
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Networking Basics
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Servers and Services

* \small \textcolor{Roarange}{\textbf{Server}} - an overloaded term which may refer to either of the following:
  - \footnotesize A dedicated computer connected to a network which provides files or services
  - \footnotesize A program running on a computer which provides one or more services and to which we connect via a port using a socket

\vskip0.5em

* \small \textcolor{Roarange}{\textbf{Service}} - An application that provides data storage, manipulation, presentation, communication, or other capability
  - \footnotesize typically implemented using a client-server or peer-to-peer architecture and application layer network protocols (e.g., http, ftp, or snmp)

# URIs

* \small \textcolor{Roarange}{\textbf{URI}} - Uniform Resource Identifier
  - \footnotesize \textcolor{Roarange}{\textbf{URL}} is a subtype of this for internet resources such as webpages
  - \footnotesize But, the concept is much more general than that

\vskip0.5em

* \small URI Syntax
  - \footnotesize `<protocol>://<address>[:port][/resource]*`

\vskip0.5em

* \small Examples
  - \footnotesize `https://isu.edu`
  - \footnotesize `http://google.com:80`
  - \footnotesize `http://127.0.0.1:5000/index`

# IP Addresses

* \small Every machine connected to a network/the internet must be able to be identified

\vskip0.5em

* \small This ensures that information can be routed correctly

\vskip0.5em

* \small Thus, we came up with the idea of IP addresses
  - \footnotesize A theoretically unique number for every machine connected to the network
  - \footnotesize The most common version of IP is version 4
  - \footnotesize Unfortunately, with the advent of smartphones, IoT devices, etc. we ran of out address 11/25/2019
  - \footnotesize But, smart engineers managed to work around that, but something else was needed, thus we have IPv6

# IP addresses

* \small Even with IPv6, IPv4 addresses are still more commonly known

\vskip0.5em

* \small They are 4 numbers ranging between 0 and 255 separated by dots

\vskip0.5em

* \small For example:
  - \footnotesize 192.168.0.1
  - \footnotesize 134.50.105.172
  - \footnotesize 127.0.0.1 (special loopback device)

\vskip0.5em

* \small Each IP Address is related to the underlying network device on your machine

\vskip0.5em

* \small Each network device has its own unique address called the MAC (Media Access Control) address

# IP Addresses

* \small You can find your own IP address using one of the following tools on the command line:
  - \textcolor{Roarange}{\textbf{ifconfig}} - linux/mac
  - \textcolor{Roarange}{\textbf{ipconfig}} - windows

\vskip0.5em

* \small Or through your network settings if you want to use the windowed approach

# Ports

* \small IP addresses are used to ensure that information is routed correctly

\vskip0.5em

* \small But, we also need to be able to send and receive specific types of information.

\vskip0.5em

* \small Ports allow us to setup multiple programs (servers/services) to receive information

\vskip0.5em

* \small Ports act like digital/logical mailboxes to which different packets of information can be delivered.

\vskip0.5em

* \small Thus, a single machine can specify what types of information it is listening for and what protocols it uses

# Ports

* \small Common ports that are open on many servers/computers include
  - \footnotesize \textcolor{Roarange}{\textbf{20,21}} - FTP
  - \footnotesize \textcolor{Roarange}{\textbf{22}} - ssh
  - \footnotesize \textcolor{Roarange}{\textbf{80,8080}} - http/web (default)
  - \footnotesize \textcolor{Roarange}{\textbf{3306}} - MySQL

\vskip0.5em

* \small The well-known parts are in the range 0 - 1023

\vskip0.5em

* \small The range of registered ports is 1024 - 49151

\vskip0.5em

* \small The range of dynamic, private, or ephemeral ports is 49152 - 65535

# Ports

* \small Thus when setting up a new service, it tends to be wise to make sure you are not using a well registered port.
  - \footnotesize But, we are using HTTP, so port 80 can be used (if not already in use by another program, may want to consider NGinX to get around this)

\vskip0.5em

* \small You can determine what ports are used on your system with tools such as:
  - \footnotesize nmap
  - \footnotesize netstat

# Ports

\vfill
\centering
\includegraphics[width=.75\textwidth]{images/microservices/portdiagram.png}

# REST?

\small What is REST?

- \small \textcolor{Roarange}{\textbf{REST}} - Representational State Transfer

\vskip0.5em

- \small RESTful systems should
  * \footnotesize Client-server architecture
  * \footnotesize Operations should be stateless (i.e., do not remember between calls)
    - \scriptsize No information is retained by the server between sessions
  * \footnotesize use a layered approaches
  * \footnotesize support code on demand
  * \footnotesize have a uniform interface

\vskip0.5em

- \small \textcolor{Roarange}{\textbf{Goal:}} systems with high performance, scalability, modifiability, visibility, portability, and reliability

# HTTP Methods

* \small The five basic/useful methods for our work are:
  - \footnotesize \textcolor{Roarange}{\textbf{GET}} - requests the target resource to transfer a representation of its current state. Only retrieves data and should have no other effect.
  - \footnotesize \textcolor{Roarange}{\textbf{POST}} - requests that the target process the representation enclosed in the request
  - \footnotesize \textcolor{Roarange}{\textbf{PUT}} - requests that the target resource create or update its state with the state defined by the representation enclosed in the request
  - \footnotesize \textcolor{Roarange}{\textbf{DELETE}} - request that the target resource delete its state
  - \footnotesize \textcolor{Roarange}{\textbf{PATCH}} - requests that the target resource modify its state according to the partial updated defined in the representation enclosed in the request.

# Testing HTTP Methods

* \small HTTP methods, when combined with a URI effectively construct a RESTful API

\vskip0.5em

* \small For example, GitHub (and many other sites) has a RESTful API
  - \footnotesize Example: `curl https://api.github.com/search/users?q="grifisaa"`
  - \footnotesize This returns a JSON document containing information about my personal github profile

\vskip0.5em

* \small You can use curl to transfer a URI using any of the specific HTTP methods, as long as you can access the API
  - \footnotesize Note, you can also provide curl with authentication headers as well, but that is beyond the scope

#

\centering
\vfill
\begin{minipage}{.575\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Javalin Microservices
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Java Microservices

* \small All we need to implement a microservice is the following components
  - \footnotesize An embeddable webserver
  - \footnotesize The ability to create routes (or API end points)
  - \footnotesize Code to handle what happens when those endpoints are accessed

\vskip.5em

* \small In Java, there are many components that we could use for these things
  - \footnotesize Embeddable webservers include \textcolor{Roarange}{\textbf{Jetty}} and \textcolor{Roarange}{\textbf{Glassfish}} among others, you could even roll your own
  - \footnotesize Ability to create routes, this is basically built in to all webservers
  - \footnotesize Code to handle route events, this is where we need to add our own code

\vskip.5em

* \small There are several Java frameworks which provide all of these capabilities
  - \footnotesize The most well known (and the most heavyweight) is the \textcolor{Roarange}{\textbf{Spring framework}}
    * \scriptsize This includes \textcolor{Roarange}{\textbf{SpringBoot}} which is basically designed to get you up and running quickly with deploying a microservice
  - \footnotesize However, a simpler yet still robust framework is \textcolor{Roarange}{\textbf{Javalin}}, which we will be using.

# How do we start using Javalin?

* \small First, you probably should use something like Gradle or Maven to manage your dependencies

\vskip0.5em

* \small I prefer Gradle, so I added the following to my `build.gradle` file

\footnotesize
```groovy
    dependencies {
      implementation 'io.javalin:javalin:4.3.0'
    }
```

* \small Additionally, you will need add the following dependencies (for logging and json processing)

```groovy
    dependencies {
      implementation 'org.slf4j:slf4j-simple:1.7.36'
      implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.1'
    }
```

# Hello World

\scriptsize
```java
    import io.javalin.Javalin;

    public class HelloWorld {
      public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("<h1>Hello World!</h1>"));
      }
    }
```

1. \small This creates a new service on the localhost running on port 7000
2. \small When we send a \textcolor{Roarange}{\textbf{GET}} request to the route "/", it returns `<h1>Hello World</h1>`
   - \footnotesize "/" is the root route
   - \footnotesize the full url for this route would be - http://localhost:7000/

\pause

\begin{center}
\Large
\textcolor{Roarange}{\textbf{Let's see this in action}}
\end{center}

# Handlers

* \small To process a "route" we need a handler for that particular route, and we simply add it to our server

\vskip0.5em

* \small There are five types of handlers that can be used, but the three main ones are:
  - \footnotesize \textcolor{Buttons}{\textbf{before-handlers}} - matched before every request
  - \footnotesize \textcolor{Buttons}{\textbf{endpoint-handlers}} - these define the api (the get handler in the prior code)
  - \footnotesize \textcolor{Buttons}{\textbf{after-handlers}} - run after every request (even is an exception occurs)

# Handlers

* \small Each of the three handlers require three parts
  - \footnotesize A verb (one of: `before`, `get`, `post`, `put`, `patch`, `delete`, `after`)
  - \footnotesize A path (i.e., `/`, `/status`, `/user/{name}`)
  - \footnotesize A handler implementation, which can be defined as follows
    * \scriptsize Using an lambda function: `ctx -> { ... }`, or
    * \scriptsize implementing the interface `io.javalin.http.Handler`

# Handlers

* \small In addition to the basic operations which we can define one at a time.

\vskip0.5em

* \small Often, we need to implement multiple operations a particular path.

\vskip0.5em

* \small Thus, we can provide a `CrudHandler` instance for the particular route

# Handlers

\scriptsize

```java
    app.routes(() -> {
      crud("users/{user-id}", new UserController())
    });
```

\vskip0.5em

* \small `UserController` would need to implement the `CrudHandler` interface which provides the following methods:
  - \footnotesize `getAll(ctx)`
  - \footnotesize `getOne(ctx, resourceId)`
  - \footnotesize `create(ctx)`
  - \footnotesize `update(ctx, resourceId)`
  - \footnotesize `delete(ctx, resourceId)`

\vskip0.5em

* \small Where `resourceId` happens to be the parameter `{user-id}` in this case

# Path Parameters

* \small We can extract data provided in path-parameters using:
  - `ctx.pathParam("key")`

\vskip0.5em

* \small Example:

\footnotesize

```java
app.get("/hello/{name}", ctx -> {
  ctx.result("Hello: " + ctx.pathParam("name"));
})

app.get("/hello/<name>", ctx -> {
  ctx.result("Hello: " + ctx.pathParam("name"));
})
```

# JSON Data

* \small The typical data format to send between the client and server is JSON

\vskip0.5em

* \small For our \textcolor{Roarange}{\textbf{GET}} routes, we can simply provide the JSON equivalent of an object by calling
  - `ctx.json(obj)`

\vskip0.5em

* \small For our \textcolor{Roarange}{\textbf{POST}} routes, which receive data, we can do the following
  1. \footnotesize validate that the content type is json: `ctx.contentType().equals("application/json")`
  2. \footnotesize extract the json data into the expected class: `obj = ctx.bodyAsClass(Class.class)`

\vskip0.5em

* \small You can test the post with curl as follows:
  - \footnotesize `curl -X POST http://localhost:7000/api/user -H 'Content-Type: application/json' -d '{"firstName":"Foo","lastName":"Bar","email":"foobar@isu.edu"}'`

# Robust Server

\footnotesize

```java
public static void main(String[] args) {
  QueuedThreadPool queuedThreadPool =
              new QueuedThreadPool(200, 8, 60000);

  Javalin app = Javalin.create(config -> {
    config.server(() -> {
      Server server = new Server(queuedThreadPool);
      return server;
    }
  }).start(7000)

  app.routes(() -> {
    get("/hello", ctx -> ctx.result("Hello"));
  });
}
```

# For Next Time

::: columns
:::: column
* Review this Lecture
* Come to Class
* Watch Lecture 17 Video
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
