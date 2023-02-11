# Table of Contents

1. Basic Concepts of Object-Orientation and UML
2. Introduction to Object Oriented Analysis
   - User Stories and Use Cases
   - Epics
4. Improving Your Code
   - SCM and Git
   - Build Automation
   - Refactoring
   - Unit Testing
   - Integration Testing
   - System Testing
   - Specification Testing
   - BDD/TDD
   - SQL Database Basics
3. Design Principles
   - Class Design Principles
   - Collaboration Design Principles
   - Package Design Principles
4. Design Patterns
5. Distributing Your System
   - Containerization
     * Docker and Docker-Compose
       - Best Practices
     * Snap
     * AppImage
   - Packaging


# SOLID Principles

## **S**ingle Responsibility Principle (SRP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## **O**pen-Closed Principle (OCP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## **L**iskov Substitution Principle (LSP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## **I**nterface Segregation Principle (ISP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## **D**ependency Inversion Principle (DIP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

# GRASP Principles

* General Responsibility Assignment Software Principles

## Information Expert

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Creator

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Controller

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Low Coupling

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## High Cohesion

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Indirection

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Polymorphism

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Pure Fabrication

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Protected Variations

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

# Principles of Package Architecture

## The Release Reuse Equivalency Principle (REP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## The Common Reuse Principle (CRP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## The Acyclic Dependencies Principle (ADP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## The Stable Dependencies Principle (SDP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## The Stable Abstractions Principle (SAP)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

# Other Principles

## Don't Repeat Yourself (DRY)

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Hollywood Principle

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Encapsulate What Varies

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Separation of Concerns

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Principle of Least Knowledge

### Description

### When To Apply

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Defensive Programming

### Description

* Programming defensively means making your code **robust** to unexpected use.
* Use the **need to know** principle: Only expose the parts of your class that your client classes need to know
* Normally, your classes form part of a larger system
* So other programmers will be using and relying upon your classes
* Obviously, your classes should be *correct*, but equally importantly, your classes should be *robust* -- that is, resistant to accidental misuse by other programmers
* You should aim to ensure that no errors in the final system can be attributable to the behavior of your classes

### Approaches

* Exception Handling
  - Exceptions are an elegant mechanism for handling errors without the disadvantages of the other techniques
    - Return values aren't tied up
    - No extra parameters
    - Error handling code isn't mixed in with the "normal" code
    - You can't ignore exceptions - if you don't handle them, your program will crash
  - Use exceptions only for exceptional conditions
  - Use checked exceptions for recoverable conditions and runtime exceptions for programming errors
  - Avoid unnecessary use of checked exceptions
  - Favor standard exceptions
  - Document all exceptions thrown by mehtods
  - Include failure-capture information in detailed messages
  - Don't ignore exceptions
* Assertions
  - As we write code, we make many assumptions about the state of the program and the data it processes
    - A variable's value is in a particular range
    - A file exists, is writable, is open, etc.
    - The maximum size of the data is N (e.g., 1000)
    - The data is sorted
    - A network connection to another machine was successfully opened
    - ...
  - The correctness of our program depends on the validity of our assumptions
  - Fauilty assumptions result in buggy, unreliable code
  - Used to check:
    - Pre-conditions
      - reflect **requires** clause
      - Test client
    - Post-conditions
      - reflect **effects** clause
      - test procedure
    - Invariants
* Parameter Checking
  - A method or function should always check its input parameters to ensure that they are valid
  - Can be cone using either assertions or an if that throws an exception for invalid parameters
    * If you control the calling code, use assertions
    * If you don't control the calling code, use exceptions
* Input Validation
  - Programs without input validation are open to many attacks
  - Always check that your input is as you expect
  - Assume the worst -- although most of your users are probably going to be "good buys", hackers have access to your program too
  - Think like an attacker
  - Input Sources:
    * Network connectsion
    * Web-Based Apps: URL params, Query Params, POST, etc.
    * Database Systems and other external sources
    * Registry/System properties
    * Files
    * ...
  - Minimize the "Attack Surface"
    - Disable channels and methods
    - Prevent access to them by users
    - Make sure you know every system entry point
    - Ensure system uses authentication and authorization
    - Ensure all untrusted input is validated (i.e., using input filtering)
      - Failures here are CWE-20: "Improper Input Validation" 

### Examples

#### Java

#### JavaScript

#### Python

#### C#

## Design By Contract

### Description

* Write a clear contract on how the method caller is supposed to use the method, and assume caller is disciplined and obeys the contract.

### When To Apply

* DbC allows application logic to be separated from contract logic
* Contracts should be represented in the method documentation
* When enhanced defect localization is needed

### Examples

#### Java

* Using Cofoja

```java
@Requires({"index >= 0", "index <= size()"})
@Ensures({"element.equals(get(index))"})
public void add(int index, E element) {
  // implementation
}
```

* Extended Example

  * build.gradle:
  
    ```java
    configurations {
      cofoja
    }

    dependencies {
      cofoja group: 'org.huoc', name: 'cofoja', version: '1.3.1'
      compile configuration.cofoja.dependencies
    }

    test {
      jvmArgs '-ea', '-javaagent:' + configurations.cofoja.files[0]
    }
    ```

```java
import java.util.LinkedList;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant({ "elements != null",
             "isEmpty() || top() != null" }) // (1)
public class CofojaStack<T> {

  private final LinkedList<T> elements = new LinkedList<T>();

  @Requires("o != null") // (2)
  @Ensures({ "!isEmpty()", "top() == o" }) // (3)
  public void push(T o) {
    elements.add(o);
  }

  @Requires("!isEmpty()")
  @Ensures({ "result == old(top())", "result != null" })
  public T pop() {
    final T popped = top();
    elements.removeLast();
    return popped;
  }
  
  @Requires("!isEmpty()")
  @Ensures("result != null")
  public T top() {
    return elements.getLast();
  }

  public boolean isEmpty() {
    return elements.isEmpty();
  }
}
```

#### JavaScript

#### Python

#### C#

# Design Patterns

## Fundamental Patterns

### Delegation

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Interface

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Immutable

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Marker Interface

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Proxy

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Creational Patterns

### Abstract Factory

Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

* A system should be independent of how its products are created, composed, and represented.
* A system should be configured with one of the multiple families of products. 
* A family of related product objects is designed to be used together, and you need to enforce this constraint.
* Useful when you want to create objects that are compatible with a certain application or framework, but you don’t want to specify the concrete classes of the objects until runtime.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Builder

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Factory

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Object Pool

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Prototype

Allows for the creation of new objects by copying existing objects, rather than creating new objects from scratch.

* Useful when creating complex objects or when the cost of creating a new object is high.
* A class will not know what classes it will be required to create. 
* Subclasses may specify what objects should be created.
* Parent classes wish to defer creation to their subclasses.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Singleton

The Singleton design pattern is used to ensure that a class has only one instance, and to provide a global access point to that instance.

* One advantage of using the Singleton design pattern is that it ensures that there is only one instance of a class, which can be useful for classes that manage resources such as database connections or network sockets.
* It also provides a global access point to the instance, which can make it easier to use the instance in different parts of the code.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Partitioning Patterns

### Composite

Allows objects to be treated as a single unit. It is used to compose objects into tree structures, and to create complex objects from simpler ones.

* Hierarchical representations of objects are needed.
* Objects and compositions of objects should be treated uniformly

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Filter

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Layered Initialization

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Structural Patterns

### Adapter

Allows two incompatible interfaces to work together by wrapping an adapter class around one of the interfaces. This adapter class converts the interface of the adapted class into the interface that the client is expecting.

* Adapters can not only convert data into various formats but can also help objects with different interfaces collaborate.
* Possible to create a two-way adapter that can convert the calls in both directions.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Bridge

Allows for the separation of abstraction and implementation, so that the two can vary independently

* Abstractions and implementations should not be bound at compile time.
* Abstractions and implementations should be independently extensible.
* Changes in the implementation of an abstraction should have no impact on clients.
* Implementation details should be hidden from the client.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Cache Management

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Decorator

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Dynamic Linkage

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Facade

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Flyweight

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Virtual Proxy

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Behavioral Patterns

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Chain of Responsibility

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Command

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Iterator

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Little Language

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Mediator

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Snapshot

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Observer

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Null Object

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### State

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Strategy

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Template Method

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Visitor

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Patterns of OO Architecture

### Abstract Server

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Microservice Patterns

### Aggregator

Aggregator in the computing world refers to a website or program that collects related items of data and displays them. So, even in Microservices patterns, Aggregator is a basic web page which invokes various services to get the required information or achieve the required functionality. 

Also, since the source of output gets divided on breaking the monolithic architecture to microservices, this pattern proves to be beneficial when you need an output by combining data from multiple services. So, if we have two services each having their own database, then an aggregator having a unique transaction ID, would collect the data from each individual microservice, apply the business logic and finally publish it as a REST endpoint. Later on, the data collected can be consumed by the respective services which require that collected data.

The Aggregate Design Pattern is based on the DRY principle. Based on this principle, you can abstract the logic into a composite microservices 

So, for example, if you consider two services: Service A and B, then you can individually scale these services simultaneously by providing the data to the composite microservice.

#### Problem

When breaking the business functionality into several smaller logical pieces of code, it becomes necessary to think about how to collaborate the data returned by each service. This responsibility cannot be left with the consumer, as then it might need to understand the internal implementation of the producer application.

#### Solution

The Aggregator pattern helps to address this. It talks about how we can aggregate the data from different services and then send the final response to the consumer. This can be done in two ways:

1. A **composite microservice** will make calls to all the required microservices, consolidate the data, and transform the data before sending back.

2. An **API Gateway** can also partition the request to multiple microservices and aggregate the data before sending it to the consumer.

It is recommended if any business logic is to be applied, then choose a composite microservice. Otherwise, the API Gateway is the established solution.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### API Gateway

Microservices are built in such a way that each service has its own functionality. But, when an application is broken down into small autonomous services, then there could be few problems that a developer might face. The problems could be as follows:

1. How can I request information from multiple microservices?
2. Different UI require different data to respond to the same backend database service
3. How to transform data according to the consumer requirement from reusable Microservices
4. How to handle multiple protocol requests?

Well, the solution to these kinds of problems could be the API Gateway Design Pattern.  The API Gateway Design Pattern address not only the concerns mentioned above but it solves many other problems. This microservice design pattern can also be considered as the proxy service to route a request to the concerned microservice. Being a variation of the Aggregator service, it can send the request to multiple services and similarly aggregate the results back to the composite or the consumer service. API Gateway also acts as the entry point for all the microservices and creates fine-grained APIs’ for different types of clients.

With the help of the API Gateway design pattern, the API gateways can convert the protocol request from one type to other. Similarly, it can also offload the authentication/authorization responsibility of the microservice.

So, once the client sends a request, these requests are passed to the API Gateway which acts as an entry point to forward the clients’ requests to the appropriate microservices. Then, with the help of the load balancer, the load of the request is handled and the request is sent to the respective services. Microservices use Service Discovery which acts as a guide to find the route of communication between each of them. Microservices then communicate with each other via a stateless server i.e. either by HTTP Request/Message Bus.

#### Problem

When an application is broken down to smaller microservices, there are a few concerns that need to be addressed:

1. How to call multiple microservices abstracting producer information.

2. On different channels (like desktop, mobile, and tablets), apps need different data to respond for the same backend service, as the UI might be different.

3. Different consumers might need a different format of the responses from reusable microservices. Who will do the data transformation or field manipulation?

4. How to handle different type of Protocols some of which might not be supported by producer microservice.

#### Solution

An API Gateway helps to address many concerns raised by microservice implementation, not limited to the ones above.

1. An API Gateway is the single point of entry for any microservice call.

2. It can work as a proxy service to route a request to the concerned microservice, abstracting the producer details.

3. It can fan out a request to multiple services and aggregate the results to send back to the consumer.

4. One-size-fits-all APIs cannot solve all the consumer's requirements; this solution can create a fine-grained API for each specific type of client.

5. It can also convert the protocol request (e.g. AMQP) to another protocol (e.g. HTTP) and vice versa so that the producer and consumer can handle it.

6. It can also offload the authentication/authorization responsibility of the microservice.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Chained or Chain of Responsibility

Chained or Chain of Responsibility Design Patterns produces a single output which is a combination of multiple chained outputs. So, if you have three services lined up in a chain, then, the request from the client is first received by Service A. Then, this service communicates with the next Service B and collects data. Finally, the second service communicates with the third service to generate the consolidated output. All these services use synchronous HTTP request or response for messaging. Also, until the request passes through all the services and the respective responses are generated, the client doesn’t get any output. So, it is always recommended to not to make a long chain, as the client will wait until the chain is completed

One more important aspect which you need to understand, is that the request from Service A to Service B may look different from Service B to Service C. Similarly the response from Service C to Service B may look completely different from Service B to Service A.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Asynchronous Messaging

From the above pattern, it is quite obvious that the client gets blocked or has to wait for a long time in synchronous messaging. But, if you do not want the consumer, to wait for a long time, then you can opt for the Asynchronous Messaging. In this type of microservices design pattern, all the services can communicate with each other, but they do not have to communicate with each other sequentially. So, if you consider 3 services: Service A, Service B, and Service C. The request from the client can be directly sent to the Service C and Service B simultaneously. These requests will be in a queue. Apart from this, the request can also be sent to Service A whose response need not have to be sent to the same service through which request has come.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Database or Shared Data

For every application, there is humongous amount of data present. So, when we break down an application from its monolithic architecture to microservices, it is very important to note that each microservice has sufficient amount of data to process a request. So, either the system can have a database per each service or it can have shared database per service.  You can use database per service and shared database per service to solve various problems.  The problems could be as follows:

* Duplication of data and inconsistency
* Different services have different kinds of storage requirements
* Few business transactions can query the data, with multiple services
* De-normalization of data

Well, to solve the first three problems, I think you can go for database per service, as it will be then accessed by the microservice API itself. So, each microservice will have its own database ID,  which thereafter prevents the other services in the system to use that particular database. Apart from this, to solve the issue of de-normalization, you can choose shared databases per service,  to align more than one database for each microservice. This will help you gather data, for the monolithic applications which are broken down into microservices. But, you have to keep in mind that, you have to limit these databases to 2-3 microservices; else, scaling these services will be a problem.

#### Database per Service

##### Problem
There is a problem of how to define database architecture for microservices. Following are the concerns to be addressed:

1. Services must be loosely coupled. They can be developed, deployed, and scaled independently.

2. Business transactions may enforce invariants that span multiple services.

3. Some business transactions need to query data that is owned by multiple services.

4. Databases must sometimes be replicated and sharded in order to scale.

5. Different services have different data storage requirements.

##### Solution
To solve the above concerns, one database per microservice must be designed; it must be private to that service only. It should be accessed by the microservice API only. It cannot be accessed by other services directly. For example, for relational databases, we can use private-tables-per-service, schema-per-service, or database-server-per-service. Each microservice should have a separate database id so that separate access can be given to put up a barrier and prevent it from using other service tables.

#### Shared Database per Service

##### Problem
We have talked about one database per service being ideal for microservices, but that is possible when the application is greenfield and to be developed with DDD. But if the application is a monolith and trying to break into microservices, denormalization is not that easy. What is the suitable architecture in that case?

##### Solution
A shared database per service is not ideal, but that is the working solution for the above scenario. Most people consider this an anti-pattern for microservices, but for brownfield applications, this is a good start to break the application into smaller logical pieces. This should not be applied for greenfield applications. In this pattern, one database can be aligned with more than one microservice, but it has to be restricted to 2-3 maximum, otherwise scaling, autonomy, and independence will be challenging to execute.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Event Sourcing

The event sourcing design pattern creates events regarding the changes in the application state. Also, these events are stored as a sequence of events to help the developers track which change was made when. So, with the help of this, you can always adjust the application state to cope up with the past changes. You can also query these events, for any data change and simultaneously publish these events from the event store. Once the events are published, you can see the changes of the application state on the presentation layer.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Branch

Branch microservice design pattern is a design pattern in which you can simultaneously process the requests and responses from  two or more independent microservices. So, unlike the chained design pattern, the request is not passed in a sequence, but the request is passed to two or more mutually exclusive microservices chains. This design pattern extends the Aggregator design pattern and provides the flexibility to produce responses from multiple chains or single chain. For example, if you consider an e-commerce application, then you may need to retrieve data from multiple sources and this data could be a collaborated output of data from various services. So, you can use the branch pattern, to retrieve data from multiple sources.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### External Configuration

#### Problem
A service typically calls other services and databases as well. For each environment like dev, QA, UAT, prod, the endpoint URL or some configuration properties might be different. A change in any of those properties might require a re-build and re-deploy of the service. How do we avoid code modification for configuration changes?

#### Solution
Externalize all the configuration, including endpoint URLs and credentials. The application should load them either at startup or on the fly.

Spring Cloud config server provides the option to externalize the properties to GitHub and load them as environment properties. These can be accessed by the application on startup or can be refreshed without a server restart.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Service Discovery Pattern

#### Problem
When microservices come into the picture, we need to address a few issues in terms of calling services:

With container technology, IP addresses are dynamically allocated to the service instances. Every time the address changes, a consumer service can break and need manual changes.

Each service URL has to be remembered by the consumer and become tightly coupled.

So how does the consumer or router know all the available service instances and locations?

#### Solution
A service registry needs to be created which will keep the metadata of each producer service. A service instance should register to the registry when starting and should de-register when shutting down. The consumer or router should query the registry and find out the location of the service. The registry also needs to do a health check of the producer service to ensure that only working instances of the services are available to be consumed through it. There are two types of service discovery: client-side and server-side. An example of client-side discovery is Netflix Eureka and an example of server-side discovery is AWS ALB.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Blue-Green Deployment Pattern

#### Problem
With microservice architecture, one application can have many microservices. If we stop all the services then deploy an enhanced version, the downtime will be huge and can impact the business. Also, the rollback will be a nightmare. How do we avoid or reduce downtime of the services during deployment?

#### Solution
The blue-green deployment strategy can be implemented to reduce or remove downtime. It achieves this by running two identical production environments, Blue and Green. Let's assume Green is the existing live instance and Blue is the new version of the application. At any time, only one of the environments is live, with the live environment serving all production traffic. All cloud platforms provide options for implementing a blue-green deployment. For more details on this topic, check out this article.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Command Query Responsiblity Segregator

Every microservices design has either the database per service model or the shared database per service. But, in the database per service model, we cannot implement a query as the data access is only limited to one single database. So, in such scenario you can use the CQRS pattern. According to this pattern, the application will be divided into two parts: Command and Query. The command part will handle all the requests related to CREATE, UPDATE, DELETE while the query part will take care of the materialized views. The materialized views are updated through a sequence of events which are creating using the event source pattern discussed above.

#### Problem
Once we implement database-per-service, there is a requirement to query, which requires joint data from multiple services — it's not possible. Then, how do we implement queries in microservice architecture?

#### Solution
CQRS suggests splitting the application into two parts — the command side and the query side. The command side handles the Create, Update, and Delete requests. The query side handles the query part by using the materialized views. The event sourcing pattern is generally used along with it to create events for any data change. Materialized views are kept updated by subscribing to the stream of events.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Circuit Breaker

As the name suggests, the Circuit Breaker design pattern is used to stop the process of request and response if a service is not working. So, for example, let’s say a client is sending a request to retrieve data from multiple services. But, due to some issues, one of the services is down. Now, there are mainly two problems you will face: first, since the client will not have any knowledge about a particular service being down, the request will be continuously sent to that service. The second problem is that the network resources will be exhausted with low performance and bad user experience.

So, to avoid such problems, you can use the Circuit Breaker Design Pattern. With the help of this pattern, the client will invoke a remote service via a proxy. This proxy will basically behave as a circuit barrier. So, when the number of failures crosses the threshold number, the circuit breaker trips for a particular time period. Then, all the attempts to invoke the remote service will fail in this timeout period. Once that time period is finished, the circuit breaker will allow a limited number of tests to pass through and if those requests succeed, the circuit breaker resumes back to the normal operation. Else, if there is a failure, then the time out period begins again.

#### Problem
A service generally calls other services to retrieve data, and there is the chance that the downstream service may be down. There are two problems with this: first, the request will keep going to the down service, exhausting network resources and slowing performance. Second, the user experience will be bad and unpredictable. How do we avoid cascading service failures and handle failures gracefully?

#### Solution
The consumer should invoke a remote service via a proxy that behaves in a similar fashion to an electrical circuit breaker. When the number of consecutive failures crosses a threshold, the circuit breaker trips, and for the duration of a timeout period, all attempts to invoke the remote service will fail immediately. After the timeout expires the circuit breaker allows a limited number of test requests to pass through. If those requests succeed, the circuit breaker resumes normal operation. Otherwise, if there is a failure, the timeout period begins again.

Netflix Hystrix is a good implementation of the circuit breaker pattern. It also helps you to define a fallback mechanism which can be used when the circuit breaker trips. That provides a better user experience.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Saga Pattern

#### Problem
When each service has its own database and a business transaction spans multiple services, how do we ensure data consistency across services? For example, for an e-commerce application where customers have a credit limit, the application must ensure that a new order will not exceed the customer’s credit limit. Since Orders and Customers are in different databases, the application cannot simply use a local ACID transaction.

#### Solution
A Saga represents a high-level business process that consists of several sub requests, which each update data within a single service. Each request has a compensating request that is executed when the request fails. It can be implemented in two ways:

1. Choreography — When there is no central coordination, each service produces and listens to another service’s events and decides if an action should be taken or not.

2. Orchestration — An orchestrator (object) takes responsibility for a saga’s decision making and sequencing business logic.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Decomposition

Microservices are developed with an idea on developers mind to create small services, with each having their own functionality. But, breaking an application into small autonomous units has to be done logically. So, to decompose a small or big application into small services, you can use the Decomposition patterns.

With the help of this pattern, either you can decompose an application based on business capability or on based on the sub-domains. For example, if you consider an e-commerce application, then you can have separate services for orders, payment, customers, products if you decompose by business capability.

But, in the same scenario, if you design the application by decomposing the sub-domains, then you can have services for each and every class. Here, in this example, if you consider the customer as a class, then this class will be used in customer management, customer support, etc. So, to decompose, you can use the Domain-Driven Design through which the whole domain model is broken down into sub-domains. Then, each of these sub-domains will have their own specific model and scope(bounded context).  Now, when a developer designs microservices, he/she will design those services around the scope or bounded context.

Though these patterns may sound feasible to you, they are not feasible for big monolithic applications. This is because of the fact that identifying sub-domains and business capabilities is not an easy task for big applications. So, the only way to decompose big monolithic applications is by following the Vine Pattern or the Strangler Pattern.

#### Decompose by Business Capability

##### Problem
Microservices is all about making services loosely coupled, applying the single responsibility principle. However, breaking an application into smaller pieces has to be done logically. How do we decompose an application into small services?

##### Solution
One strategy is to decompose by business capability. A business capability is something that a business does in order to generate value. The set of capabilities for a given business depend on the type of business. For example, the capabilities of an insurance company typically include sales, marketing, underwriting, claims processing, billing, compliance, etc. Each business capability can be thought of as a service, except it’s business-oriented rather than technical.

#### Decompose by Subdomain

##### Problem
Decomposing an application using business capabilities might be a good start, but you will come across so-called "God Classes" which will not be easy to decompose. These classes will be common among multiple services. For example, the Order class will be used in Order Management, Order Taking, Order Delivery, etc. How do we decompose them?

##### Solution
For the "God Classes" issue, DDD (Domain-Driven Design) comes to the rescue. It uses subdomains and bounded context concepts to solve this problem. DDD breaks the whole domain model created for the enterprise into subdomains. Each subdomain will have a model, and the scope of that model will be called the bounded context. Each microservice will be developed around the bounded context.

**Note:** Identifying subdomains is not an easy task. It requires an understanding of the business. Like business capabilities, subdomains are identified by analyzing the business and its organizational structure and identifying the different areas of expertise.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Strangler or Vine Pattern

The Strangler Pattern or the Vine Pattern is based on the analogy to a vine which basically strangles a tree that it is wrapped around. So, when this pattern is applied on the web applications, a call goes back and forth for each URI call and the services are broken down into different domains. These domains will be hosted as separate services.

According to the strangler pattern, two separate applications will live side by side in the same URI space, and one domain will be taken in to account at an instance of time. So, eventually, the new refactored application wraps around or strangles or replaces the original application until you can shut down the monolithic application

#### Problem
So far, the design patterns we talked about were decomposing applications for greenfield, but 80% of the work we do is with brownfield applications, which are big, monolithic applications. Applying all the above design patterns to them will be difficult because breaking them into smaller pieces at the same time it's being used live is a big task.

#### Solution
The Strangler pattern comes to the rescue. The Strangler pattern is based on an analogy to a vine that strangles a tree that it’s wrapped around. This solution works well with web applications, where a call goes back and forth, and for each URI call, a service can be broken into different domains and hosted as separate services. The idea is to do it one domain at a time. This creates two separate applications that live side by side in the same URI space. Eventually, the newly refactored application “strangles” or replaces the original application until finally you can shut off the monolithic application.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

## Architectural Patterns

### Model-View-Controller

This pattern, also known as MVC pattern, divides an interactive application in to 3 parts as,

1. **model** — contains the core functionality and data
2. **view** — displays the information to the user (more than one view may be defined)
3. **controller** — handles the input from the user

This is done to separate internal representations of information from the ways information is presented to, and accepted from, the user. It decouples components and allows efficient code reuse.

#### Usage

* Architecture for World Wide Web applications in major programming languages.
* Web frameworks such as Django and Rails.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Layered Pattern

This pattern can be used to structure programs that can be decomposed into groups of subtasks, each of which is at a particular level of abstraction. Each layer provides services to the next higher layer.

The most commonly found 4 layers of a general information system are as follows.

* **Presentation layer** (also known as **UI layer**)
* **Application layer** (also known as **service layer**)
* **Business logic layer** (also known as **domain layer**)
* **Data access layer** (also known as **persistence layer**)

#### Usage

* General desktop applicaitons
* E-commerce web apps

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Client-Server Pattern

This pattern consists of two parties; a **server** and multiple **clients**. The server component will provide services to multiple client components. Clients request services from the server and the server provides relevant services to those clients. Furthermore, the server continues to listen to client requests.

#### Usage

* Online apps such as email, document sharing, and banking

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Master-Slave Pattern

This pattern consists of two parties; master and slaves. The master component distributes the work among identical slave components, and computes a final result from the results which the slaves return.

#### Usage

* In database replication, the master database is regarded as the authoritative source, and the slave databases are synchronized to it.
* Peripherals connected to a bus in a computer system (master and slave drives).

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Pipe-Filter Pattern

This pattern can be used to structure systems which produce and process a stream of data. Each processing step is enclosed within a filter component. Data to be processed is passed through pipes. These pipes can be used for buffering or for synchronization purposes.

#### Usage

* Compilers. The consecutive filters perform lexical analysis, parsing, semantic analysis, and code generation.
* Workflows in bioinformatics.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Broker Pattern

This pattern is used to structure distributed systems with decoupled components. These components can interact with each other by remote service invocations. A **broker** component is responsible for the coordination of communication among **components**.

Servers publish their capabilities (services and characteristics) to a broker. Clients request a service from the broker, and the broker then redirects the client to a suitable service from its registry.

#### Usage

* Message borker software such as Apache ActiveMQ, Apache Kafka, RabbitMQ, and JBoss Messaging

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Peer-to-Peer Pattern

In this pattern, individual components are known as **peers**. Peers may function both as a **client**, requesting services from other peers, and as a **server**, providing services to other peers. A peer may act as a client or as a server or as both, and it can change its role dynamically with time.

#### Usage

* File-sharing networks such as Gnutella and G2)
* Multimedia protocols such as P2PTV and PDTP.
* Cryptocurrency-based products such as Bitcoin and Blockchain

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Event-Bus Pattern

This pattern primarily deals with events and has 4 major components; event source, event listener, channel and event bus. Sources publish messages to particular channels on an event bus. Listeners subscribe to particular channels. Listeners are notified of messages that are published to a channel to which they have subscribed before.

#### Usage

* Android development
* Notification services

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Blackboard Pattern

This pattern is useful for problems for which no deterministic solution strategies are known. The blackboard pattern consists of 3 main components.

* **blackboard** — a structured global memory containing objects from the solution space
* **knowledge source** — specialized modules with their own representation
* **control component** — selects, configures and executes modules.

All the components have access to the blackboard. Components may produce new data objects that are added to the blackboard. Components look for particular kinds of data on the blackboard, and may find these by pattern matching with the existing knowledge source.

#### Usage

* Speech recognition
* Vehicle identification and tracking
* Protein structure identification
* Sonar signals interpretation.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#

### Interpreter Pattern

This pattern is used for designing a component that interprets programs written in a dedicated language. It mainly specifies how to evaluate lines of programs, known as sentences or expressions written in a particular language. The basic idea is to have a class for each symbol of the language.

#### Usage

* Database query languages such as SQL.
* Languages used to describe communication protocols.

#### Implementation

##### Java

##### JavaScript

##### Python

##### C#
