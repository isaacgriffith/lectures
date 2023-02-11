# Homework 01

## Purpose

* To gain familiarity with and an ability to utilize the tools and techniques associated with:
  - Version control including GitHub, Git, and GitFlow
  - Automated project build using Gradle
* To demonstrate familiarity with the following
  - Basic programming constructs in Java
  - Basic concepts associated with documenting a project including
    * Source code documentation according to project guidance for this course
    * Repository documentation using a README.md, LICENSE, and Changelog
  - Use of semantic versioning with GitFlow

## Part 01 - Setup

* Using GitHub, create a new repository called "cs2263_hw01"
  - Make it private (for now)
  - Add a README.md
  - Add a LICENSE - MIT
  - Add a gitignore file - Java
* While still on GitHub, grad the url to clone the repository
* On your development system, open a terminal/command line
  - Change to a parent directory into which you want to clone the repository from GitHub
  - Using git clone the newly create repository, using `git clone`
  - Change directories to the newly created repo directory
  - Verify that everything worked correctly, using either `dir` or `ls`
  - Initialize your newly cloned repo to use gitflow, using `git flow init`
  - Verify that you are on the development branch, using `git status`
* Now is a good time to do some minimal documentation
  - Using git flow, create a new feature called "initial documentation" (or something similar to that)
  - Setup the structure of the README.md file to that suggested by GitHub guides
  - Add a Changelog.md file and setup the structure according to `keepachangelog.org`
  - Modify your .gitignore file as noted in class (note the file may be hidden)
  - Once you've done all that you can finish the feature using git flow
* Verify, using `git status`, that you are currently on the `develop` branch
* Commit and push all of your changes to GitHub, using:
  - `git add .`
  - `git commit -m ""`
    * provide a useful message in the quotes
  - `git push --all`

## Part 02 - Java Refresher

We are going to create a simple mathematical expression evaluator just to be sure that we can write Java code and to ensure that everything works correctly. In this mini-project we will create three releases each adding new features to the project.

### Release 1.0.0

Assuming that you have completed Part 01 you should be nearly ready to get started coding.

The first step is to initialize your project as a Gradle project. So open a terminal (linux/mac), command prompt (windows), or powershell terminal (windows), if not already open. Using the appropriate commands (i.e., cd) navigate to, or ensure that you are at, the root directory of your project (the one created during setup). Now initialize the project as a gradle project using the following command:

`$ gradle init`

For this project (and assuming that you are using at least Gradle 7.0.2) select the following options:

* Type of project -> 2: application
* Implementation Language -> 3: Java
* Split functionality across multiple subprojects -> 1: no only one application project
* Build script DSL: 1: Groovy
* Test framework: 4: JUnit Jupiter
* Project name: cs2263_hw01
* Source Package: edu.isu.cs2263.hw01

It should inform you that the build was successful. You should now verify that everything was created.

Specifically, you should have (in the root folder) the following files/folders:

* app/
  - build.gradle
  - src/
    - main
      - java
        - edu
          - isu
            - cs2263
              - hw01
                - App.java
    - test
      - java
        - edu
          - isu
            - cs2263
              - hw01
                - AppTest.java
* gradle/
* .gradle/
* gradlew
* gradlew.bat
* settings.gradle

You should test your gradle build and the ability to run the newly create project using the following two commands from the project root:

```bash
gradle build
gradle run
```

Assuming everything works correctly, you should now import this project into your IDE. Once that is complete, from the command line, start a new feature using gitflow, and call it something like "cli_feature", where "cli" stands for "command line interface".

In you IDE open the file "app/build.gradle" and in the dependencies section add the following line:

```groovy
// Apache Commons CLI
implementation 'commons-cli:commons-cli:1.4'
```

This will add the dependency for Apache Commons CLI, which will allow for the correct processing of command line arguments.

Now what are we doing in this release?

1. Modify App.java by removing the generated method `getGreeting()`
2. Modify App.java removing the contents, but not the method, of the `main()` method.
3. Now you will need to read up on Apache Commons CLI and you will need to add the following three options
   - -h, --help -> which prints the help/usage message (see below)
   - -b <file>, --batch <file> -> which processes the provided file rather than standard input
   - -o <file>, --output <file> -> sends the output to the provided file and standard output
4. Implement the parsing of each of these such that:
   - When the user provides a "-h" or "--help" command line option, the help/usage message is shown and the program exits (regardless of other options). The help/usage display should look similar to this:

   ```
   usage: eval [OPTIONS]
   Evaluation of simple mathematical expressions

   -b,--batch <file>    batch file containing expressions to evaluate
   -h,--help            print usage message
   -o,--output <file>   output file

   Copyright (C) 2021 Isaac D. Griffith
   ```

   - When the user provides a "-b" or "--batch" command line option, the following is displayed:

   ```
   Batch value: lib
   ```

   Where lib is the name of the provided file

   - When the user provides a "-o" or "--output" command line option, the following is displayed:

   ```
   Output value: lib
   ```

   Where lib is the name of the provided folder

5. Once all of this is done you have complete the first feature, and ready to release version 1.0.0. Be sure to commit all of your changes to the feature. Use GitFlow to finish the feature. Then use GitFlow to start a release named "1.0.0". Update your Changelog.md file for Release 1.0.0, commit the changes, and finish the release.
6. Don't forget to push all branches and tags to the remote repo on GitHub.

### Release 1.1.0

In this release we will add the evaluation component. This component takes expressions such as: 4 + 5 * 9 / 3 - 1, and returns the result. The requirements for this part of the project are as follows:

* Be able to process the expression such that it is evaluated left to right without considering order of operations.
* Be able to input the expression from standard input (i.e., typing in at the terminal)
* Be able to input a batch of expressions from a file, which contains a single expression per line.
* Be able to output the result to the standard output (i.e., output to the terminal)

Examples:

```
$ eval

> 4 + 5 + 6
  -> 15
> 1 / 4 * 4 -1
  -> 0
Ctrl-C

$
```

```
$ eval -b test.txt

> 4 + 5 + 6
  -> 15
> 1 / 4 * 4 - 1
  -> 0

$
```

You should use GitFlow to create a new feature, to start implementing this work.

I suggest creating a component which processes and evaluates a given expression string. I would then create an Interface for accepting input. I would then create two classes which implement this interface. The first, handles the case of the endless loop accepting input from the console, and the second which reads the batch file. I would then modify your CLI processor to construct the correct version based on whether the batch option was provided. Additionally, if the batch option is provided I would verify that the provided filename is an actual file, and if not throw and exception, and tell the user that they need to provide an actual file.

Once you have completed all of this, I would commit my changes and finish the feature. Once the feature is finished, start a new release called "1.1.0". Update your changelog reflect the changes made. Once all of this is complete, finish the release, push all branches and tags.

### Release 1.2.0

Finally you are nearly done. In this section we are going to add in the ability to output to multiple locations.

So let's start a new feature using gitflow.

I would then suggest creating an interface for outputting the results, it should only need one method (something like output(String expr, String result)). You then should create two classes which implement this interface. The first class simply uses println's similar to what was already done. The second class is a bit more complex as it will output to the output file specified. Regardless of whether the user uses the output command line option, you will always need to output to the console. Thus, this implies you would need someway of registering output classes to your evaluator component, and the ability to have more than one. Additionally, you will need to modify the output option processing to both check for the file and if it does not exist to create it and to add an instance of the file output component to the evaluator.

An example of this program running would be as follows:

```
$ eval -o results.txt

> 4 + 5 + 6
  -> 15
> 1 / 4 * 4 - 1
  -> 0
Ctrl-C

$
```

The file "results.txt" should then look like:

```
4 + 5 + 6
-> 15
1 / 4 * 4 - 1
-> 0
```

Once you have implemented all of this, you should commit your changes and finish your feature. Once the feature is finished, start a new release named "1.2.0" and update your changelog. After the changelog is updated, finish your release, then push all branches and tags.

Finally, don't forget to submit your repo url to the assignment dropbox.

## Submission

Submit a single PDF formatted using LaTeX. If you are interested I would suggest using Gij's Homework Template from Overleaf. For the exercises with code be sure to add the code into the PDF (and make it look nice). For the project, simply include the URL to the repository.

## Grading

Students will be graded as follows:

* Project - 6 points
  - 1 points - The project is hosted on GitHub under the student's account
  - 3 points - The project uses GitFlow to release at least three versions
    - 1.0.0
    - 1.1.0
    - 1.2.0
  - 2 points - The project uses GitFlow to control the branching of the repository such that at the end of the project there are only two branches
    - development - which maintains the entire history of the code and the only branch to which any code is actively committed
    - main - which maintains the history of the releases
* Java
  - The program was coded using Java and compiles using Gradle on the command line and in the IDE
  - The program executes using gradle at the command line and in the IDE
  - The program executes as an executable Jar
  - The program executes from the command line using an assembled script provided during the assembly phase of gradle
* Documentation
  - The program source code is appropriately documented according to the standards defined by the project guidance
  - The program's repository is documented using the following components
    - A properly formatted README.md file found in the root directory of the project, which follows the GitHub guidline
    - A properly formatted Changlog.md file found in the root directory of the project, which follows the guidance found which documents the versions of the system which have been released.
    - A LICENSE file found in the root directory of the project, which meets the requirements noted above
