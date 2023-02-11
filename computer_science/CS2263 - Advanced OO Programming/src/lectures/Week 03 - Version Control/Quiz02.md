1. Which of the following is **not** a part of the general *software build process*?

   (n) Test
   (n) Assemble
   (n) Develop
   (n) Integrate
   (c) Analyze

2. Which of the following best describes the purpose of Build tools?

   (c) Provides a means by which we can automate conversion from source code to an executable program
   (c) Provides a means by which we can automate execution of test cases
   (c) Provides a means by which we can package and deploy the executable artifacts created
   (n) Provides a means by which we manage and share changes to the source code

3. Which of the following commands initializes a new **gradle** project

   (n) git init
   (c) gradle init
   (n) gradle clean
   (n) gradle build
   (n) gradle assemble

4. Which of the following best describes the purpose of Dependency Management tools?

   (c) Provides the ability to download required libraries or program artifacts
   (c) Provides a means by which required libraries or program artifacts can be installed for use in the development of a software system
   (c) Provides an ability to store locally the libraries or program artifacts needed for constructing a software system
   (n) Provides the ability to construct and upload program artifacts for use in other projects

5. Which of the following best describes the the gradle build lifecycle?

   (c) A project is first initialized, next it is configured which produces a graph of the tasks to be executed, finally the specified task(s) is executed.
   (n) A project is first configured, next it is inialized which produces a graph of the tasks to be executed, finally the specified task(s) is executed.
   (n) A project is first configured producing a graph of the tasks to be executed and then the specified task(s) is executed.

6. Match each concept to the best description of that concept

   This is the heart of the version control system. It stores the files shared between users and maintains the history of each file. -> Repository
   Provides a means by which versions of a repo may be named -> Tag
   Forks in the repository that create new lines of development -> Branch
   Storing changes from the working copy into the repository -> Commit
   The snapshot of the repository where the developer works on the project -> Working Copy
   -> Trunk

7. Match the following descriptions to the appropriate grade tasks.

   Compiles the project and executes the tests -> test
   Compiles the project and packages it into a jar file -> jar
   Compiles the project, packages it into a jar, and prepares execution scripts -> assemble
   Removes all remnant build artifacts from the project directory -> clean
   Generates the documentation for java projects -> javadoc
   Compiles the project, packages it into a jar, prepares execution scripts, and tests and checks the program -> build
   -> check

8. In semantic versioning when is the third number, PATCH, updated?

   (n) It is incremented when you make incompatible API changes
   (n) It is incremented when you add functionality that is backwards compatible
   (c) It is incremented when you make backwards compatible bug fixes

9. Match each description with the git command it describes.

   copy a git repository so you can add to it. -> git clone
   records a snapshot of the staging area -> git commit
   fetch from a remote repo and try to merge into the current branch -> git pull
   view the status of your files in the working directory and staging area -> git status
   create an empty git repository or reinitialize an existing one -> git init
   used to review the history of the repository -> git log
   integrates changes from one branch into another -> git merge
   places both staged and unstaged, but uncommitted, changes away for later use, and then reverts them from your working copy -> git stash
   -> git cherry-pick

10. True or false, the changelog maintains a list of changes and is simply a list of the commits to a project?

    (c) False

11. Which of the following best describes the basic process used to construct an OO system?

    (c) Abstract specification -> Conceptual Classes -> Implementation Classes -> Implementation
    (n) Conceptual Classes -> Abstract specification -> Implementation Classes -> Implementation
    (n) Abstract specification -> Implementation Classes -> Conceptual Classes -> Implementation
    (n) Implementation -> Abstraction Specification -> Conceptual Classes -> Implementation Classes

12. Which of the following best describes the concept of an object.

    (c) An object is an instance of a class which provides for the ability to store data (state) while providing the behaviors which manipulate that state (operations).
    (n) An object also known as a class provides the structure for storing data (state) while providing the definitions for the behaviors which manipulate that state (operations).
    (n) An object is simply the components of a class which provide class level scoped variables.
    (n) An object is simply the components providing methods with the ability to either input or output data.

13. Which of the following are types of dependencies?

    (c) Installed Programs
    (c) System Packages
    (c) Programming Libraries
    (n) JDK
    (n) Gradle

14. Which of the following best describes the purpose of a Continuous Integration System?

    (c) A tool/system that automatically executes the build system whenever a specific system change event occurs
    (n) This is simply another name for the automated build system
    (n) A tool/system that automatically executes system tests whenever a specific system change occurs
    (n) None of the other choices

15. Which of the following are true about version control systems?

    (c) Version control systems provide a means by which we can track all versions of a software system
    (c) Version control systems provide a means by which we can retrieve past versions and identify who change the files and when
    (c) Version control systems provide a scalable solution allowing thousands of contributors
    (n) All version control systems are deeply connected to how files are organized into directories

16. Which of the following are true regarding different types of version control systems?

    (c) Local version control approaches are known to be highly error prone
    (n) Local version control approaches tend to be overly complicated
    (n) Both distributed and centralized version control utilize a central server which tracks files and from which files are checked out
    (n) In centralized version control the client maintains a complete repository with full history of the changes
    (c) In distributed version control a clone of the repository acts as a full backup of the data

17. Match the following descriptions to the appropriate tools.

    executes a class, java source file, or jar file on the JVM -> java
    compiles java source files into class files -> javac
    provides a REPL for executing scripts written in java -> jshell
    compresses a collection of classes into a single java archive -> jar
    -> javah
    -> javaw

18. Which of the following is/are not a form of coupling discussed in class?

    (n) Association
    (c) Aggregation
    (c) Composition
    (n) Usage
    (c) Package dependency
    (n) Generalization
    (n) realization

19. True or False. Delegation is a mechanism used when composing objects and allows one object to utilize the functionality of another object in order to perform its functions.

    (c) True

20. Which of the following is are mechanisms for defining types in Java?

    (c) Class
    (c) Interface
    (c) Record
    (c) Enum
    (n) Trait
    (n) Object

21. The `finalize()` method provided by Object is what type of method?

    (c) Destructor
    (n) Constructor
    (n) Instance Method
    (n) Class Method

22. In Java, what is a lambda expression?

    (c) an unnamed block of code similar to a method
    (n) nothing, Java does not support lambdas
    (n) another name for a method
    (n) a reference to an existing method
