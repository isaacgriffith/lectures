---
author:
- Dr. Isaac Griffith
title: Building Software Systems
institute: |
  CS 2263

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand why we use build and dependency management tools
* Understand the general process of software build
* Understand the general idea of dependency management
* Understand a brief history of these tools
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

<!-- # Configuration Management

\centering
\includegraphics[width=.85\textwidth]{images/build/dcm} -->

# 5 Facts I Know

Take out a sheet of paper or open a text editor, pause the lecture and complete the following:

1. At the top of the page write the topic: **Building Software**
2. Write the numbers 1 - 5 along the left column of the sheet
3. Brainstorm to identify 5 facts that you know about this topic
   * If you are having a hard time, consult the reading material
   * If you are still having a hard time, use the internet.

# Thought Experiment

\centering
\Large \textbf{Consider Bob}

\includegraphics[width=.85\textwidth]{images/build/bob}

\pause
\Large \textbf{Is this a familiar approach?}

\pause
\Large \textbf{Is this a good approach?}


# Thought Experiment

\centering
\Large \textbf{Sandra Joins the Project...}

::: columns
:::: column

\includegraphics[width=\textwidth]{images/build/sandra_bob}

::::
:::: column

* What can go wrong here?

\pause
\vskip1em

* What if we add 5 more people?

\pause
\vskip1em

* How about 5 more teams of 7 people?

::::
:::

# Two Components

::: columns
:::: column
* **Build Tools** - Automate the build process

* **Dependency Management** - Automate 3rd-party library management
::::
:::: column
\centering
\includegraphics[width=.75\textwidth]{images/build/tools.png}
::::
:::

\centering
\Huge All About the Automation

# Building Software Sucks!

::: columns
:::: column
* Software Build Process
  - Develop
  - Test
  - Assemble
  - Deploy
  - Integrate
  - Repeat (again and again and again)
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/build/build.png}
::::
:::

# Build Systems

\centering
\includegraphics[width=\textwidth]{images/build/man_vs_auto}

\pause

##

\centering
\Large Building and deploying the project should be as easy as possible.

# Automated Build Systems

::: columns
:::: column

**Automated Build Systems allow us to:**

* Download and install required libraries
* Build the software
* Execute test cases
* Package/Deploy Executables

::::
:::: column

\centering
\only<2>{\includegraphics[width=\textwidth]{images/build/devops.eps}}
\only<3-4>{\includegraphics[width=\textwidth]{images/build/cicd.eps}}

::::
:::

\only<4>{
\begin{block}
\centering
\Large
Automating repetitive tasks allows them to be run at-will.
\end{block}
}

# Build Lifecycle

::: columns
:::: column

1. **Validate** the project is correct and all necessary information is available
2. **Compile** the source code of the project
3. **Test** the compiled source code using a suitable unit testing framework
   - Run **unit tests** against classes and **subsystem integration tests** against groups of classes
4. Take the compiled code and **package** it in its distributable format (i.e., a JAR file)

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/build/build_lifecycle}

::::
:::

# Build Lifecycle

::: columns
:::: column

5. **Verify** - run system tests to ensure quality criteria are met
   - System tests require a packaged executable
   - This is also when tests of non-functional criteria like performance are executed
6. **Install** the package for use as a dependency in other projects locally
7. **Deploy** the package to the installation environment

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/build/build_lifecycle}

::::
:::

<!--
# Midway Summary Check

Let's take a break for the next 5 minutes and do the following:

1. Everyone stand up, leaving your notes where they are
2. Find a partner from another part of the room
3. There are two roles
   - **Person summarizing** - this person summarizes important concepts covered so far
   - **Person clarifying** - responds by clarifying or adding to the summary
4. Select your roles
5. Consider the following additional questions
   - How do you see this as applicable to your work/life?
   - How important is this information to the issues that this course addresses?
-->

# Dependency Management

::: columns
:::: column

\scriptsize
* All but the simplest programs rely/reuse existing artifacts
* **Dependencies** - represent the relationship between your program and these other artifacts
  - \tiny Note, these artifacts are themselves other projects
* Dependencies may be
  - \tiny Installed programs (i.e., the `JDK`)
  - \tiny System Packages (i.e., `openssl`)
  - \tiny Programming Libraries (i.e., `JUnit`)
* Dependency management tools - provide a means to
  - \tiny Host dependencies
  - \tiny Download dependencies
  - \tiny Store dependencies
  - \tiny Install dependencies

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/build/dep_mgmt.png}

::::
:::

# Dependency Repos

::: columns
:::: column

* Currently, most dependencies are provided via a **repository**

* Providing
  - A singular location to download from
  - Convenient mechanism for installation

* Examples
  - Java - Maven Central Repository
  - Python - PyPi (via `pip`)
  - Ubuntu - Apt repos
  - Ruby - RubyGems

::::
:::: column

\centering

\includegraphics[width=.65\textwidth]{images/build/maven.jpeg}

\includegraphics[width=.55\textwidth]{images/build/pypi.png}

\vskip.5em

\includegraphics[width=.55\textwidth]{images/build/gems.png}

::::
:::

# Identifying Artifacts

* An **artifact** is the component we depend upon
* Typically these are identified by two or three specific components
  - Group or Author identifier (i.e., "org.junit.jupiter")
  - The artifact identifier (i.e., "junit-jupiter-api")
  - The artifact version (i.e., 5.7.2)

* The first two may or may not be combined
  * The group/author identifier is for the organization which created it
  * The artifact identifier is for the item depend upon

* The last item, version number, deserves a bit more understanding

# Artifact Versions

* Most projects/libraries we depend upon issue a **version identifier** upon release
* Version identifiers are typically numerical, but not always
  - 8.1.3
  - 64.1.20192004
  - 5.8.0-M1
* Version Identifiers serve the following purposes
  - Ensure that the software using them continues to work

##

Imagine trying to build after release of a library, but failing because a request method no longer exists

# Semantic Versioning


::: columns
:::: column

* A relatively common versioning standard
* Every version number is of the form:

\centering
\includegraphics[width=.85\textwidth]{images/build/semantic_versioning}

##

\large What might be some advantages of this?

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/build/sv_rules}

::::
:::

# Lock Files

::: columns
:::: column

* Build and dependency management often are separate tools
* Dependency management system typically uses **lock files** to prevent dependency modification
* To upgrade dependencies you must explicitly use the management tool
  - pip in python
  - bundler in ruby

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/build/lock_file}

::::
:::

# Continuous Integration

::: columns
:::: column

* Changing large software projects often requires:
  - Updating project documentation
  - Deploy the compiled system
  - Release the code to a dependency management repo
  - Run the test suite
  - ...

\pause

##

* Automated builds can provide all of this
* But how do we activate the automated build?

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/build/button_push.jpg}

::::
:::

\pause
\centering
\large \textbf{This is the purpose of a Continuous Integration system!}

# Continuous Integration

* Basically, this is an umbrella term for:
  - Stuff that runs automatically anytime a change to the system occurs

* Currently there are many options for CI
  - Travis CI
  - Circle CI
  - GitHub Actions
  - GitLab CI
  - Azure Pipelines
  - Jenkins

# Continuous Integration

\centering
\includegraphics[width=\textwidth]{images/build/ci_process}

##

Later in the course, we will discuss this in greater detail.

# Examples of Tools

::: columns
:::: column

**Build Tools**

- Java: Ant, Maven, Gradle
- Android: Gradle
- .NET: MSBuild, NAnt
- Scala: sbt
- Ruby: Bundler, Rake
- C/C++: make

::::
:::: column

**Continuous Integration**

* GitHub Actions
* GitLab
* Jenkins
* TravisCI
* CircleCI

::::
:::

# Timeline of Tools

\centering
\includegraphics[width=\textwidth]{images/build/timeline}

# Complete A Sentence

1. Take out a sheet of paper.

2. Take a few minutes to finish the following sentence:

\begin{block}{}

\textbf{Today, the most important thing I learned was ...}

\end{block}

3. Keep this as part of your notes, for when you review the lecture

# For Next Time

::: columns
:::: column
* Review the InfoQ Article
* Review this Lecture
* Come to Class
* Continue working on Homework 01
* Review the Gradle Readings
* Look at the Gradle Sample Article

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
