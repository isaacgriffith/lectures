---
courseInfo:
    number: CS 2263
    title: Object Oriented Programming -- Tools
    semester: Spring
    year: 2020
fontsize: 12pt
...

# Tools

In a use-case the "happy path" is the natural, error-free way through a scenario. So, here the "happy path" tools are the recommended tools we provide the most support for.

## Happy Path Tools and Frameworks

This is the recommended list of tools which we provide the most support for. If your group is not so experienced, stick to the happy path!

### Git

See the Git lecture.

### Java

Java 10 is the happy path back-end language. [Download the Java 12 SE from Oracle](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html).

#### Documentation

[The Java Standard Edition (SE) API & Documentation home](https://www.oracle.com/technetwork/java/javase/overview/index.html)
    This is the main Oracle page for Java SE docs.
[The Java 12 API docs](https://docs.oracle.com/en/java/javase/12/docs/api/index.html)
    this page documents every method in every class in the core API.
[The Java Tutorial](http://docs.oracle.com/javase/tutorial/index.html)
    Oracle's on-line Java tutorial. There are trails for both basic and advanced topics.
[A Lambda expressions tutorial](http://tutorials.jenkov.com/java/lambda-expressions.html)
    You may not have learned about Java's lambdas; we will be using them a lot so you may want to read up on them.
[Local type inference tutorial](https://www.baeldung.com/java-10-local-variable-type-inference)
    Java 12 allows you to leave off more type declarations, another new feature we recommend that you use; the above tutorial is an overview.

### Edit Compile Debug: IntelliJ

[IntelliJ](https://www.jetbrains.com/idea/) is the happy path IDE. There are many other just as good editors listed on the somewhat happy path below.

* It has integrated support for git, maven, JUnit, includes a test coverage tool, etc etc - its about as full-featured an IDE as there is out there for Java.
* The Community edition is free, but you may want to grab the Ultimate Edition which is also free for educational use -- [just fill out the form linked here with your ISU email](https://www.jetbrains.com/student/). Ultimate includes JavaScript support and database tools.

#### Java Build tool: Maven

Maven is a standard build tool for Java projects - its **make** for Java combined with Ruby's gems for automatic project configuration. It can build, test, run, deploy, generate documentation, and more.

* [A brief introduction to Maven](http://maven.apache.org/what-is-maven.html)
* [Maven Homepage](http://maven.apache.org/index.html) for documentation, tutorials, etc.

A Key to Maven is it can be used to build everything you want built, including compile, tests, docs, deployment, etc. Since your project group shares a single Maven file you will also all be on the same versions of all libraries and plugins declared in Maven.

The happy path dependencies for your projects are in the To Do app pom file, pom.xml: slf4j for logging, the Javalin web server setup, Jackson for json--object mapping, postgresql for incorporating a Postgres database, and junit-jupiter-engine for JUnit 5 testing. It also includes the maven-surefire-plugin for running unit tests and the maven-assembly-plugin for building a deployable JAR file.

#### Java unit testing with JUnit

JUnit is a unit testing framework developed for Java.

    We require use of JUnit 5, the latest version which includes JUnit Jupiter for more clean and powerful coding of tests.
    Simply use the Maven jupiter dependency and surefire plugin described above to use it, no download is necessary.
    JUnit Test Infected -- an example of JUnit in action if you are not familiar with it.

#### The Javalin RESTful Web Server

The happy path web server for the class is Javalin, a lightweight all-Java web server. You will use it in Homework 1.

    See the RESTful Web lecture where Javalin was covered.
    It has the distinct advantage of being a Java package so it integrates very well with Java applications
    Don't install it directly, use the Maven dependency information described above under Maven.

#### Javalin Tutorials

Javalin is designed to be simple -- the documentation is short and very readable. The Javalin website also has some tutorials for common operations. Here is a guide to some tutorials that could be useful for your group.

    Website example - this tutorial shows some basics of how endpoints are set up, but it also covers how session attributes can be used to support login. Javalin 2.0 has improved session management and this tutorial has been updated to include that. (It also shows how you can use the Javalin Context to render the webpages themselves, something we recommend you instead use JavaScript for to make a "Web 2.0" app).
    Deploying to Heroku - its dead simple! You may also need to configure your database but its easy to set up Postgres on Heroku.
    If you are wanting to poll the server like we did in the To Do app, consider using Web Sockets instead, a newer technology which allows the server to push updates to the browser and avoid the overhead of polling. See Websocket example for a simple tutorial you can build on.

### Databases

Many projects will make use of a database back-end. There is unfortunately no one optimal database solution for all purposes, but the happy path is to use Postgresql for your projects.

    Its very easy to deploy Postgres on Heroku, but you also need to download and install it on your computer for development. For Windows we recommend installing the EDB version. For Mac postgres.app is probably the easiest route.
    Note that Postgres is a server running in the background and it requires some initial configuration before it will run; read the docs.
    There are many client applications to inspect/edit database tables which are helpful for debugging. pgAdmin is one such free app.
    If you did not take a databases class you will need to read a tutorial or two on basic SQL operations on databases.

### Javascript

The happy path is to use vanilla JavaScript for a web front-end for your project. With vanilla JavaScript you are at the controls and will understand whats going on more clearly, so its a good starting point. If you want to learn a web front-end framework, ReactJS is on the somewhat-happy path below.

    The JavaScript lecture gave an overview of JavaScript
    For general JavaScript information the Mozilla documentation is excellent. It both describes JavaScript and goes over the APIs needed for broswer programming.
    javascript.info is a smaller tutorial than the previous. Part 1 covers the language and Part 2 covers the browser; Part 3 is misc info but make sure to read on promises and async/await.
    For another simple example, the course To Do app contains a simple vanilla Javascript front-end example.

#### Vanilla JavaScript Tutorial

See Leandro's video tutorial which builds on the JavaScript lecture video to show how to build more realistic front-ends.

Other tutorial examples include a JavaScript Front-End Web App Tutorial and a Pure JavaScript app example.

#### RESTful API testing via Postman

Postman is the happy path to both design and test RESTful APIs, and is how we will specify the RESTful API for the first assignment.

    A Postman Collection is the API; top-level Folders are the API endpoints; and each Request in a folder is one interaction with the endpoint, exercising the success case as well as the error cases.
    Design the API by adding a Description to the endpoints and Examples to each request. You can add Examples by hand, before you develop the server.
    Document the API by exporting the Collection and checking the resulting .json in version control. Alternatively, use Postman’s own facilities for publishing the documentation—but you may run into the limits of the free tier.
    Test the API with the Runner built into Postman. Use Newman to automate the execution of your tests in the Continuous Integration server.
    To debug web apps, all the major browsers (Chrome, Firefox, Safari) have excellent built-in debuggers which are generally similar - use your favorite.

#### Postman Tutorial

Follow along this series of short videos on Postman.

### Continuous integration: TravisCI

Continuous integration frameworks automatically run your tests on each push to your master branch. It is a great gatekeeper to make sure your master branch is always working.

    All projects must use TravisCI as it has strong integration with GitHub
    All projects in the course jhu-oose organization at GitHub have been granted free access to the private, commercial Travis-CI.com service.
    (For public repositories after OOSE you can use travis-ci.org for free.)

#### Using Travis-CI

    The documentation, which includes tutorials on how to set up the Continuous Integration server for different kinds of projects.
    Travis has been enabled for all your projects and all you need to do to set is up is to push an appropriate .travis.yml file to your repository - no other actions at all are needed!
    When setup is done, every time you push code to your repository, Travis is going to build your project, run your tests and do whatever more you configure it to do (e.g. run static analysis tools, report code coverage metrics).
    Go to travis-ci.com and hit the login button to login and to see the output (use your GitHub ID to log in).
    You can also set it up to get a summary via e-mail (see here) and on the Pull Request page you create on GitHub. Finally, you can add a badge (see here for details) to your project's README.
    In order to get the integration tests running, you can use Newman. Refer to the To Do App for an example of how to set it up.

#### Deployment: PaaS on Heroku

The happy path for deploying your app is Heroku, but there are many other good options, see below on the somewhat-happy paths.

Heroku is a Platform as a Service (PaaS) architcture: you are relying on a third party to deploy and run your server on their platform.

    You give them the code for your application and a specification for language/database/frameworks/etc needed, and they build and run it for you.
    Your application has to be reasonably standard and fit their expectations and assumptions, otherwise it won't work. For example you can't access the file system.

Heroku is free, working across many languages/platforms, and having excellent documentation, so it is the OOSE happy path.

    The Heroku dev center documents how to deploy your app to Heroku.
    The basic idea for a Java project is
        You push a branch from GitHub to Heroku
        The Heroku server will run mvn install on your repo
        You set up a Heroku Procfile which will contain the command to fire up your server
        Your server will then be running on your assigned Heroku URL
    GitHub can also be configured to automatically push a certain branch to Heroku when it changes -- see Deploying with Git.
    An alternative to deploying from GitHub is to deploy directly from your computer; for example if you are using Java/Maven, see this Maven plugin to directly deploy from Maven.
    Its also possible to add a button to your GitHub README - Deploy to Heroku button info.

Video Tutorial on Deploying to Heroku

### Version Control and collaboration: Git and Github

See the OOSE Git page.

## Somewhat Happy Path Options

Here are listed other excellent tools and frameworks for your projects which are supported by the course staff but not necessarily as thoroughly as the above, and they also may be inherently more complex to use.

### Python Backends

While the course default language is Java since all undergraduates take Java, Python is an excellent option for RESTful servers.

    We recommend Flask as the back-end framework, it is a simple RESTful micro-server in the style of Javalin.
    The other common RESTful option, Django, has more "magic" happening and you won't see as clearly whats actually happening and so it is not on the somewhat happy path.
    Python has many testing frameworks; start with unittest aka PyUnit as it is the most commonly used one.

#### Learning Flask

Satish recommends the tutorials by Miguel Grinberg, who wrote the book, "Flask Web Development: Developing Web Applications with Python". These tutorials cover everything from how a Flask apps project structure should look, to Bootstrap, Databases, Forms, Passwords, Logins, API Authentication, Pagination, etc.

Video; Code; Slides.

### iOS

iOS is its own universe: the XCode IDE, the Swift programming language, etc. The tools are very good for app development and we have some CAs with iOS experience so it is a reasonable choice for project front-ends.

#### Learning iOS

Here are some references produced by Yash for iOS tutorials.

    raywenderlich.com iOS tutorials
    appcoda.com tutorials

Here are some libraries/frameworks that may be useful for your projects.

    AsyncRequests
    Grand Central Dispatch - GCD provides and manages FIFO queues to which your application can submit tasks
    CoreData - allows you to store information on device (should not be used as a replacement for a proper backend)
    CoreML - - for groups that have small-scale NLP or CV, you can look to do it on device
    HealthKit - - provides comprehensive information about user that Apple uses for advanced analysis
    SpeechKit - For speech to text tasks, you need not look beyond Apple's in-built library
    Swift Package Manager - allows you to easily build, test and run your Swift code (not critical)
    We strongly recommend you go with Swift 4. It was built to be backwards compatible with Swift 3 and has very good framework integration and support.

### Android

Android is somewhat easier to learn than iOS as it uses Java. But, dealing with the devices and simulators can be frustrating so its on the somewhat-happy path.

    If you have your own Android device you will be able to use it as your test device, they are all programmable.
    If you need a device, the department has some Android tablets that can be checked out by group members; a post on Piazza will show up about the check-out process (if its not showing up, ask there and it will).
    The developer site at developer.android.com is a very thorough site which has all the resources you need to get going.
    Android Studio is a version of IntelliJ for editing Android apps. You can't just add a plug-in to IntelliJ, you need to get the special Android version at the above link.
    Android Studio uses Gradle, not Maven, as its build tool. Gradle is very similar to Maven in terms of functionality.
    The somewhat-happy path JSON parser on Android is Jackson, the same parser used by default in Javalin.
    If you need a local database on the phone SQLite is built-in, and there is also an API called Room which may be easier to use.

#### Learning Android

Here are some suggestions from Anuraag.

    Build your first Android app
    RecyclerView (for lists) tutorial
    Glide (for images) tutorial
    Retrofit (to consume APIs) tutorial
    Android app with Flask backend
    Android Design Guidelines - if you are not familiar with UI design this is required reading
    Realm (an alternative database)

### React front-end

While the happy path for a web front-end is to simply use vanilla JavaScript, React is an excellent framework and very worthwhile to learn and use.

React Native is a variation on React which lets you write front-ends for iOS and Android. It is a good alternative to using the default iOS/Android front-end frameworks.

### Editors / Integrated Development Environments

While IntelliJ (and the closely related Android Studio) is the happy path editor, other modern editors are equally as good. But, don't use an old-fashioned editor, vim and emacs are for people with grey hair like your Professor.

    Atom -- This Github-sponsored editor is excellent; you need to use the command-line for building, debugging, etc however.
    Sublime --The modern lightweight editor that Atom ripped off.
    Visual Studio Code -- Yes Microsoft makes an excellent IDE.
    Pycharm and Ruby Mine are also made by the makers of IntelliJ and are great IDEs for Python and Ruby, respectively.

### Other Deployment options besides Heroku

Other excellent PaaS options besides Heroku include AWS Elastic Beanstalk and Google App Engine.

#### Infrastructure as a Service (IaaS)

If you need more control than PaaS, consider IaaS: this is like PaaS except you have your own (usually Linux) VM to configure however you want as you are the super-user for it.

    This requires either experience with or willingness to learn some basic Linux
    Fortunately for running back-ed software Linux is not that hard (its hard for the front-end stuff like drivers, peripherals, etc).
    Industry IaaS standards include AWS EC2, Google Cloud Compute Engine, Digital Ocean and Linode.
    JHU CS also can host you for free: go to this page and request a VM. Make sure to also request a public IP with some ports open so you can access it.

With the GitHub Student Pack you can get credits for AWS and Digital Ocean, and the JHU CS hosting is also free.

## Diagramming

The happy path is to simply use pencil and paper and scanner. But there are also good tools for drawing UML diagrams, e.g. Draw.io, a free web-based editor, Lucidchart (Free for students, just request upgrade) and Visual Paradigm Community Edition.

## Wireframing and prototyping

A wireframe is just a sketch of how the webpage or phone screen will appear. Again the happy path is to sketch these on paper. But there are countless wireframing tools which let you mock how your app will look, e.g. Moqups is a web-based mocking tool which is free for small projects.

Protyping tools let you put together detailed page mockups to make a clickable prototype of your app -- click on a button in one screen and the appropriate next screen will appear. InVision is one such app which has a usable free tier.
