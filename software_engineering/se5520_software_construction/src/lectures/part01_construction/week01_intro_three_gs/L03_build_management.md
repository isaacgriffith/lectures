---
author:
- Isaac Griffith
title: Build and Dependency Management
institute: Fall 2021
course: |
  SE 5520 - Software Construction

  and Configuration Management
fontsize: 11pt
cornerLogo: "../../../images/spirit.png"
wideLogo: "../../../images/wide.png"
lowerCornerLogo: "../../../images/roar.eps"
...

# Outcomes

At the end of Today's Lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand why we use build and dependency management tools
* Understand the basics of gradle
* Initiate a gradle project
* Utilize the basic gradle tasks to build a java project
* Configure a gradle project
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Inspiration


#

\centering
\vfill
\begin{minipage}{.7\textwidth}
\begin{minipage}{3.5em}
\vskip-1.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Build Management
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Build Tools?

::: columns
:::: column
Build Tools

* Provide the capability to manage and automate the build process

Dependency Management

* Provides the capability to automate the management of third-party libraries
::::
:::: column
\centering
\includegraphics[width=.75\textwidth]{../../../images/gradle/tools.png}
::::
:::

# Software What?

\begin{center}
\LARGE \textbf{Building Software Sucks!}
\end{center}

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
\includegraphics[width=\textwidth]{../../../images/gradle/build.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-1.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.5\textwidth}
\includegraphics[width=\textwidth]{../../../images/gradle/gradle.png}
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# What is Gradle?

* Gradle is a general purpose **build system**
* It comes with a rich build description language (DSL) based on **Groovy**
* It supports "**build-by-convention**" principle
* But it is very **flexible** and **extensible**
* It has **built-in plug-ins** for Java, Groovy, Scala, Web, OSGi
* It derives all the best and integrates well with **Ivy, Ant and Maven**

# What is Gradle?

* Gradle is also a dependency management system
* It downloads required libraries (with specific versions) for use in your project.

* Gradle is similar to other tools used in other languages
  - Python has `pip`
  - JavaScript has `npm`
  - C\# has `nuget`
  - C++ has `cmake` and `conan`
  - Ruby has `bundler`

# Gradle Features

::: columns
:::: column
* Declarative builds and build-by-convention
* Language for dependency based programming and many ways to manage dependencies
* Groovy as a base langauge allows imperative programming
::::
:::: column
\centering
\includegraphics[width=\textwidth]{../../../images/gradle/features.jpg}
::::
:::

# Gradle Features

::: columns
:::: column
* Deep and rich API for managing projects, tasks, dependency artifacts and much more
* State of the art support for multi-project builds
* Ease of integration and migration
* Free and open source
::::
:::: column
\centering
\includegraphics[width=\textwidth]{../../../images/gradle/features.jpg}
::::
:::

# Advanced Features

::: columns
:::: column
* Parallel unit test execution
* Dependency build
* Incremental build support
* Dynamic tasks and task rules
* Gradle daemon
::::
:::: column
\centering
\includegraphics[width=\textwidth]{../../../images/gradle/features.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.475\textwidth}
\begin{minipage}{3.5em}
\vskip-1.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Using Gradle
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# A Java Project

**build.gradle** file

\footnotesize
```groovy
plugins {
  id 'java'
}

repositories {
  mavenCentral()
}

dependencies {
  testRuntime "org.junit.jupiter:junit-jupiter-engine:5.5.2"
  testRuntime "org.junit.platform:junit-platform-runner:1.5.2"
}

test {
  useJUnitPlatform()
}
```

# Core Concepts

::: columns
:::: column
* **Build Script**: a build configuration script supporting one or more project
* **Project**: a component that needs to be built. It is made up of one or more tasks
* **Task**: a distinct step required to perform the build. Each task/step is atomic (either succeeds or fails).
* **Publication**: the artifact produced by the build process
::::
:::: column
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Dependency Resolution

::: columns
:::: column
\footnotesize
* **Dependencies**: tasks and projects depending on each other (internal) or on third-party artifacts (external).
* **Transitive dependencies**: the dependencies of a project may themselves have dependencies
* **Repositories**: the "places" that hold external dependencies (Maven/Ivy repos, local folders).
* **DAG**: the directed acyclic graph of dependencies (what depends on what)
* **Dependency configurations**: named sets (groups) of dependencies (e.g. per task)
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{../../../images/gradle/depresol.eps}
::::
:::

# Plugins

::: columns
:::: column
* A plugin applies a set of extensions to the build process.
  - Add tasks to a project
  - Pre-configure these tasks with reasonable defaults.
  - Add dependency configurations
  - Add new properties and methods to existing objects
* Plugins implement the "build-by-convention" principle in a flexible way
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{../../../images/gradle/plugin-puzzle-pieces.jpg}
::::
:::

# The Build Lifecycle

1. **Initialization**: initialization of the project
2. **Configuration**: configuration of the project (computes the DAG)
3. **Execution**: executes the sequence of build tasks

\centering
\includegraphics[width=.85\textwidth]{../../../images/gradle/build_lifecycle.eps}

#

\centering
\vfill
\begin{minipage}{.675\textwidth}
\begin{minipage}{3.5em}
\vskip-1.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge A Simple Example
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Initiating a Project

* To initilize a project as a gradle project, you need to:
  - include a "build.gradle" in the root project directory
  - setup the proper directory structure
* Alternatively, you can let gradle do this for you by
  - Executing the following in the root project directory

  ```bash
  > gradle init
  ```

# Run a build task

```bash
> gradle test
```
Compiles the source and runs the tests

```bash
> gradle tasks
```
clean, assemble, build, classes, testClasses, test, jar, etc

# Standard Java Tasks

::: columns
:::: column
**Tasks added by Java Plugin**

* `compileJava`
* `jar`
* `javadoc`
* `clean`
* `test`
::::
:::: column
**Lifecycle Tasks**

* `assemble`
* `check`
* `build`
::::
:::

\vfill
\centering
\includegraphics[width=\textwidth]{../../../images/gradle/tasks.eps}

#

\centering
\vfill
\begin{minipage}{.65\textwidth}
\begin{minipage}{3.5em}
\vskip-1.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Another Example
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-3.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Dependency\\Management
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Repository Configuration

```groovy
repositories {
  mavenCentral()
}
```

\footnotesize
```groovy
{
  mavenCentral name: 'single-jar-repo', urls: "http://repo.mycompany.com/jars"
  flatDir name: 'localRepository',
  dirs: 'lib' flatDir dirs: ['lib1', 'lib2']
}
```

# Referencing Dependencies

\footnotesize
```groovy
dependencies {
  testImplementation 'junit:junit:4.7'
  implementation group: 'org.springframework', name: 'spring-core', version: '2.5'
}
```

\small
* General Syntax
  - `<configuration> '<reference-string>'`
  - `<configuration> group: '<group-name>', name: '<artifact-name>', version: '<version>'`

# Dependency Configurations

* Plugins like `java` and `groovy` have predefined dependency configurations, but you may also create your own

```groovy
configurations {
  foobar
}

dependencies {
  foobar 'junit:junit:4.7'
}
```

# Built-in Java Configurations

* `implementation` - implementation only dependencies
  - extends `compile`
* `compileOnly` - compile time only dependencies, not used at runtime
* `compileClasspath` - compile classpath, used when compiling source. Used by task `compileJava`
  - extends `compile`, `compileOnly`, `implementation`
* `annotationProcessor` - annotation processors used during compilation
* `runtimeOnly` - runtime only dependencies
* `runtimeClasspath` - runtime classpath contains elements of the implementation, as well as runtime only elements
  - extends `runtimeOnly`, `runtime`, `implementation`

# Built-in Java Configurations

* `testImplementation` - implementation only dependencies for tests
  - extends `testCompile`, `implementation`
* `testCompileOnly` - additional dependencies only for compiling tests, not used at runtime
* `testCompileClasspath` - test compile classpath, used when compiling test sources. Used by task `compileTestJava`
  - extends `testCompile`, `testCompileOnly`, `testImplementation`
* `testRuntimeOnly` - runtime only dependencies for running tests
  - extends `runtimeOnly`
* `testRuntimeClasspath` - runtime classpath for tunning tests. Used by task `test`
  - extends `testRuntimeOnly`, `testRuntim`, `testImplementation`
* `archives` - artifacts (e.g., jars) produced by this project. Used by task `uploadArchives`

#

\centering
\vfill
\begin{minipage}{.775\textwidth}
\begin{minipage}{3.5em}
\vskip-1.5em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Using Gradle Plugins
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Extending Your Build

**Any Gradle script can be a plug-in:**

```groovy
apply from: 'otherScript.gradle'
apply from: 'http://mycomp.com/otherScript.gradle'
```

**Use many of the standard or 3rd-party plug-ins:**

```groovy
plugins {
  id 'java'
  id 'groovy'
  id 'scala'
  id 'war'
}
```

# Standard Plugins

+----------------------------+---------------------------------------------+
| Plug-in ID                 | Plug-in ID                                  |
+:===========================+:============================================+
| base                       | application (java, groovy)                  |
+----------------------------+---------------------------------------------+
| java-base                  | jetty (war)                                 |
+----------------------------+---------------------------------------------+
| groovy-base                | maven (java, war)                           |
+----------------------------+---------------------------------------------+
| scala-base                 | osgi (java-base, java)                      |
+----------------------------+---------------------------------------------+
| reporting-base             | war (java)                                  |
+----------------------------+---------------------------------------------+
| java (java-base)           | code-quality (reporting-base, java, groovy) |
+----------------------------+---------------------------------------------+
| groovy (java, groovy-base) | eclipse (java, groovy, scala, war)          |
+----------------------------+---------------------------------------------+
| scala (java, scala-base)   | idea (java)                                 |
+----------------------------+---------------------------------------------+
| antlr (java)               | project-report (reporting-base)             |
+----------------------------+---------------------------------------------+
| announce                   | sonar                                       |
+----------------------------+---------------------------------------------+
| java-library               | jacoco                                      |
+----------------------------+---------------------------------------------+
| spotbugs                   | pmd                                         |
+----------------------------+---------------------------------------------+

# Resources

* [Getting Started Guide](https://docs.gradle.org/current/userguide/getting_started.html)
* [Plugin Reference](https://docs.gradle.org/current/userguide/plugin_reference.html)
* [Plugin Development Tutorials](https://gradle.org/guides/?q=Plugin%20Development)

# Summary


# For Next Time

::: columns
:::: {.column width=.6}

::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
