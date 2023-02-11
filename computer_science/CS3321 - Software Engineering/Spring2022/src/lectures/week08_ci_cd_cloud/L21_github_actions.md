---
author:
- Dr. Isaac Griffith
title: GitHub Actions
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the basics of applying CI/CD fundamentals using GitHub Actions
* Describe and identify the components of GitHub Actions
* Execute a basic Gradle build using GitHub Actions
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
\begin{minipage}{.595\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge GitHub Actions Basics
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

\vfill
\scriptsize [https://docs.github.com/en/actions/learn-github-actions/understanding-github-actions](https://docs.github.com/en/actions/learn-github-actions/understanding-github-actions)

# GitHub Actions Components

* \small There are several components used
  - \footnotesize Workflows
  - \footnotesize Events
  - \footnotesize Jobs
  - \footnotesize Actions
  - \footnotesize Runners

# Workflows

* \small \textcolor{Roarange}{\textbf{Workflow}}: a configurable automated process that runs one or more jobs
  - \footnotesize defined using a YAML file checked into your repo
  - \footnotesize triggered by
    * \scriptsize an event in your repo
    * \scriptsize manually
    * \scriptsize at a defined schedule
* \small A repo may have multiple workflows each for a different set of steps and events
  - \footnotesize Additionally you can reuse workflows

# Events

* \small A specific activity which triggers a workflow run
* \small Examples include:
  - \footnotesize pushing a commit
  - \footnotesize pull request
  - \footnotesize opening an issue

* \small A Full list can be found:
  - \footnotesize https://docs.github.com/en/actions/learn-github-actions/events-that-trigger-workflows

# Jobs

* \small A set of \textcolor{Roarange}{\textbf{steps}} in a workflow executing on the same runner
* \small Can be run as either
  - \footnotesize A shell script
  - \footnotesize An action
* \small Jobs will run in parallel, unless dependencies between jobs are defined

# Actions

* \small \textcolor{Roarange}{\textbf{Action}}: a custom application for GitHub actions that performs a complex but repeated task
  - \footnotesize These allow you to:
    * \scriptsize pull a repo from GitHub
    * \scriptsize setup a toolchain for the build
    * \scriptsize setup authentication with a cloud provider
    * \scriptsize ...
  - \footnotesize You can define your own actions if you wish

# Runners

* \small \textcolor{Roarange}{\textbf{Runner}}: a server that executes workflows when triggered
  - \footnotesize Can run a single job at a time
  - \footnotesize GitHub provides the following types of runners
    * \scriptsize Ubuntu (*default*)
    * \scriptsize Windows
    * \scriptsize MacOS
  - \footnotesize If you need different runners or a specific hardware config you can host your own

# Example Workflow

::: columns
:::: column

* \small \small All workflows are stored as YAML files in the `.github/workflows/` directory of your repo
  - \footnotesize workflows are separated into individual files
  - \footnotesize file naming requirements:
    * \scriptsize contains no spaces
    * \scriptsize ends in ".yml"

::::
:::: column

\footnotesize
\textcolor{Roarange}{\textbf{.github/workflows/learn-github-actions.yml}}

```yaml
name: learn-github-actions
on: [push]
jobs:
  check-bats-version:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-node@v2
        with:
          node-version: '14'
      - run: npm install -g bats
      - run: bats -v
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.595\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Essential Features
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

https://docs.github.com/en/actions/learn-github-actions/essential-features-of-github-actions

# Workflow Variables

::: columns
:::: column

* \small GitHub Actions include default environment variables
* \small If you need your won, you can set them in the YAML workflow file
  - \footnotesize using and `env` section where each component is a pair
    * \scriptsize `VAR: value`

::::
:::: column

\textcolor{Roarange}{\textbf{Example}}

\footnotesize

```yaml
jobs:
  example-job:
    steps:
      - name: Connect to PostgreSQL
        run: node client.js
        env:
          POSTGRES_HOST: postgres
          POSTGRES_PORT: 5432
```

::::
:::

# Running Additional Scripts

::: columns
:::: column

* \small You can use actions to execute other scripts or shell commands
* \small These are assigned to a runner, using the `run` command

::::
:::: column

\footnotesize

\textcolor{Roarange}{\textbf{Example}}

```yaml
jobs:
  example-job:
    steps:
      -run: npm install -g bats
```

\textcolor{Roarange}{\textbf{Example}}

```yaml
jobs:
  example-job:
    steps:
      - name: Run build script
        run: ./.github/scripts/build.sh
        shell: bash
```

::::
:::

# Artifacts

::: columns
:::: column

* \small \textcolor{Roarange}{\textbf{Artifacts}} provide the ability to store and share data between jobs
* \small All actions and workflows called within a run have write access to that run's artifacts
* \small You can download an artifact from a separate workflow run using
  - \footnotesize `actions/download-artifact@v2`

::::
:::: column

\vspace{-1em}
\tiny

```yaml
jobs:
  example-job:
    name: Save output
    steps:
      - shell: bash
        run: |
          expr 1 + 1 > output.log
      - name: Upload output file
        uses: actions/upload-artifact@v2
        with:
          name: output-log-file
          path: output.log
```

```yaml
jobs:
  example-job:
    steps:
      - name: Download a single artifact
        uses: actions/download-artifact@v2
        with:
          name: output-log-file
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.595\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Building/Testing Java with Gradle
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

\vfill
\scriptsize [https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle](https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle)

# Gradle Template

::: columns
:::: column

* \footnotesize GitHub provides a basic Gradle workflow template
  - \scriptsize You can choose this template when creating a new workflow
  - \scriptsize You can also manually add it to the `.github/workflows` directory of your repo

* \footnotesize This workflow does the following
  1. \scriptsize `checkout` step downloads a copy of your repo onto the runner
  2. \scriptsize `setup-java` configures the Java 11 JDK by Adoptium
  3. \scriptsize "Validate Gradle wrapper" - validates the wrapper JAR files
  4. \scriptsize "Build with Gradle" - runs `gradlew` to build, test, and package your code

::::
:::: column

\vspace{-1em}
\scriptsize
```yaml
name: Java CI

on: [push]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          java-version: '11'
          distribution: 'adopt'
      - name: Validate Gradle wrapper
        uses: gradle/wrapper-validation-action@
          e6e38bacfdf1a337459f332974bb2327a31aaf4b
      - name: Build with Gradle
        run: ./gradlew build
```

::::
:::

# Selecting Your OS

* \small The template uses `ubuntu-latest` runners.
* \small If you don't want to use linux for you can change to a different OS
  - \footnotesize `runs-on: windows-latest` for windows
  - \footnotesize `runs-on: macos-latest` for mac
* \small Additionally, you can choose to run jobs using Docker containers

# Selecting JVM

::: columns
:::: column

* \footnotesize You can choose to use a different JVM from a different distribution and for a different architecture:
  - \scriptsize JVM Versions available are based on the specific distribution selected
    * \tiny Major versions: `8`, `11`, `16`, `17`
    * \tiny Specific Versions: `17.0`, `11.0`, `11.0.4`
    * \tiny You can select basically any version since 8
  - \scriptsize Distributions
    * \tiny `temurin` from Eclipse
    * \tiny `zulu` from Zulu OpenJDK
    * \tiny `adopt` from Adopt OpenJDK
    * \tiny `liberica` from Liberica JDK
    * \tiny `microsoft` from MS Build of OpenJDK
  - \scriptsize Architectures: `x86` or 'x64'

::::
:::: column

\vspace{-1em}
\footnotesize

```yaml
steps:
  - uses: actions/checkout@v2
  - uses: actions/setup-jdk@v2
    with:
      distribution: 'adopt'
      java-version: '17'
      check-latest: true
      distribution: 'x64'
```

* \small For more info: [setup-java](https://github.com/actions/setup-java)

::::
:::


# Using Multiple JVMs

* \small You can also test against multiple Java versions

\footnotesize
```yaml
    jobs:
      build:
        runs-on: ubuntu-latest
        strategy:
          matrix:
            java: ['8', '11', '13', '15', '17']
        name: Java ${{ matrix.Java }} sample
        steps:
          - uses: actions/checkout@v2
          - name: Setup java
            uses: actions/setup-java@v2
            with:
              distribution: '<distribution>'
              java-version: ${{ matrix.java }}
          - run: java -cp java HelloWorldApp
```

# Building and Testing

::: columns
:::: column

* \small We use the same commands that we use on our local machine to build and test the code

* \small By default the template will run the `build` task
  - \footnotesize Downloads dependencies
  - \footnotesize Builds classes
  - \footnotesize Runs tests
  - \footnotesize Packages classes into JAR file

* \small But we can run different commands if we wish
  - \footnotesize We can also have a separate gradle file for CI

::::
:::: column

\vspace{-1em}
\footnotesize

```yaml
steps:
  - uses: actions/checkout@v2
  - uses: actions/setup-java@v2
    with:
      java-version: '11'
      distribution: 'adopt'
  - name: Validate Gradle wrapper
    uses: gradle/wrapper-validation-action@
      e6e38bacfdf1a337459f332974bb2327a31aaf4b
  - name: Run the Gradle package task
    run: ./gradlew -b ci.gradle package
```

::::
:::

# Packaging Workflow Data

::: columns
:::: column

* \small Often we want to provide the capability to download the constructed artifacts
* \small You can use the `upload-artifact` action to upload the contents of a directory
* \small For example to upload the results of packaging

::::
:::: column

\vspace{-1em}
\footnotesize

```yaml
steps:
  - uses: actions/checkout@v2
  - uses: actions/setup-java@v2
    with:
      java-version: '17'
      distribution: 'adopt'
  - name: Validate Gradle wrapper
    uses: gradle/wrapper-validation-action@
      e6e38bacfdf1a337459f332974bb2327a31aaf4b
  - run: ./gradlew package
  - uses: actions/upload-artifact@v2
    with:
      name: Package
      path: build/distributions
```

::::
:::

# A Full Example

* \footnotesize This example will use gradle to build, test, package, and upload a distribution of your application on a push of a release

::: columns
:::: column

\vspace{-1em}
\tiny

```yaml
name: Java Deployment CI
on: [push]
jobs:
  prod-release:
    if: ${{ github.ref == 'refs/heads/main' }}
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 17
        uses: actions/setup-java@v2
        with:
          java-version: '17'
          distribution: 'adopt'
      - name: Validate Gradle wrapper
        uses: gradle/wrapper-validation-action@
          e6e38bacfdf1a337459f332974bb2327a31aaf4b
      - name: Build with Gradle
        run: ./gradlew package
      - name: Upload artifacts
        with:
          name: Package
          path: build/distributions
```

::::
:::: column

\vspace{-1em}
\scriptsize

```yaml
  dev-build:
    if: ${{ github.ref == 'refs/heads/develop' }}
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 17
        uses: actions/setup-java@v2
        with:
          java-version: '17'
          distribution: 'adopt'
      - name: Validate Gradle wrapper
        uses: gradle/wrapper-validation-action@
          e6e38bacfdf1a337459f332974bb2327a31aaf4b
      - name: Build with Gradle
        run: ./gradlew build
```

::::
:::

# For Next Time

::: columns
:::: column

* Review the Reading
* Review this Lecture
* Come to Class

\vskip1em

* For more info on GitHub Actions
  - See: [https://docs.github.com/en/actions](https://docs.github.com/en/actions)

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
