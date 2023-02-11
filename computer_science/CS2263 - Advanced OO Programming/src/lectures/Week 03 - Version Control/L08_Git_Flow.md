---
author:
- Dr. Isaac Griffith
title: Git Flow
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
* Understand git repo management using the git flow method
* Apply git flow to your own repos
* Use the git flow tool
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.35\textwidth}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge GitFlow
\vskip-.25em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Git Flow?

* Git Flow is a method and tool for managing the workflow of git.
* Is it better than other approaches
  * Yes and No, but it does simplify the majority of git operations within a project
* Just like all techniques and approaches there are champions and detractors
  * But, if you follow the approach it works quite well

# Git Flow Workflow

\begin{center}
\includegraphics[width=.85\textwidth]{images/git/flow1.png}
\end{center}

# How Git Flow Works

\begin{center}
\includegraphics[width=.55\textwidth]{images/git/flow2.png}
\end{center}

* The Git Flow workflow uses a central repository as the communication hub for all developers.
* Developers work locally and push branches to the central repo.

# Historical Branches

\begin{center}
\includegraphics[width=.7\textwidth]{images/git/flow3.png}
\end{center}

* Instead of a single `main` branch, this workflow uses two branches to record the history of the project.
  - The `main` branch stores the official release history
  - The `develop` branch serves as an integration branch for Features
  - You should also tag all commits in the `main` branch with a version number

# Feature Branches

\begin{center}
\includegraphics[width=.65\textwidth]{images/git/flow4.png}
\end{center}

* Each new feature should reside in its own branch
  - Which is pushed to the central repo for backup/collaboration
  - `develop` is the parent branch for feature branches
  - Upon completion a feature branch is merged into `develop`
  - Features should never interact directly with `main`

# Feature Branches - Best Practices

* May branch off: `develop`

* Must merge back into: `develop`

* Branch naming convention: anything except:
  - `main`
  - `develop`
  - `release-*`
  - `hotfix-*`

# Release Branches

\begin{center}
\includegraphics[width=.7\textwidth]{images/git/flow5.png}
\end{center}

# Maintenance Branches

\begin{center}
\includegraphics[width=.55\textwidth]{images/git/flow6.png}
\end{center}

* Used to quickly patch production releases
* Upon complete it is to be merged both into `main` and `develop`

# Maintenance Branches -- Bests Practices

* May branch off: `main`

* Must merge back into: `main` and `develop`

* Tag: increment `patch` number

* Branch naming convention: `hotfix-*` or `hotfix/*`

# Git Flow Example

::: columns
:::: column
**Create A Develop Branch**

\begin{center}
\includegraphics[width=.65\textwidth]{images/git/flow7.png}
\end{center}

\footnotesize
* Complement `main` with a `develop` branch locally and push it to the server.

* `develop` contains the project history, `main` contains an abridged version

* New developers should clone `develop` rather than `main`

::::
:::: column
**Beginning New Features**

\begin{center}
\includegraphics[width=.65\textwidth]{images/git/flow8.png}
\end{center}

\footnotesize
* Each developer should create a `feature` branch off of `develop`
::::
:::

# Git Flow Example

::: columns
:::: column
**Finishing a Feature**

\begin{center}
\includegraphics[width=.75\textwidth]{images/git/flow9.png}
\end{center}

\footnotesize
* Once a feature is complete, the branch owner should either
  - make a pull request to have the branch merged with `develop`
  - or, merge it with their local copy of `develop` and push to the central repository

::::
:::: column
**Preparing a Release**

\begin{center}
\includegraphics[width=.55\textwidth]{images/git/flow10.png}
\end{center}

\footnotesize
* Once ready to create a release, a new `release` branch off of `develop` should be created and named using Semantic Versioning

* The allows for cleanup of the release

* When ready it needs to be pushed to the central repository, where it becomes **feature-frozen**
::::
:::

# Git Flow Example

::: columns
:::: column
**Finishing a Release**

\begin{center}
\includegraphics[width=.45\textwidth]{images/git/flow11.png}
\end{center}

\footnotesize
* Once ready to ship the `release` branch should be merged with both `main` and `develop`, and then it should be deleted.

* This is a great point at which to conduct a code review.

* At this point `main` should be tagged with the release version number
::::
:::: column
**End-User Discovers a Bug**

\begin{center}
\includegraphics[width=.55\textwidth]{images/git/flow12.png}
\end{center}

\scriptsize
* End-user opens a ticket about a bug in the current release.

* To address this a new maintenance branch, aka `hotfix`, off of `main` is created

* Fixes are added and committed to the new branch and when fixed the branch is merged back into `main`

* `main` is tagged at this point with a version number updated by incrementing the `patch` number
  - v0.1.0 -> v0.1.1
::::
:::

# Using Git Flow

* To setup a repo to be a git flow repository simply execute the `init` command:

  ```
  git flow init
  ```

  - This setups both the main and develop branches, and what naming convention will be used for the feature and hotfix branches

* Working with a feature

  - To start a new feature (e.g., "initial-implementation") execute the `feature` command:

    ```
    git flow feature start initial-implementation
    ```
  - Once you are ready to finish the feature

    ```
    git add .
    git commit -m "some commit message"
    git flow feature finish initial-implementation
    git push origin --all
    ```

  - If you are working with others and want to share your progress

    ```
    git add .
    git commit -m "some commit message"
    git flow feature publish initial-implementation
    ```

  - You can pull a feature

    ```
    git flow feature pull initial-implementation
    ```

# Using Git Flow

* Time to release

  - To start a new release (ensure that the current branch is clean) for version `v0.1.0`:

    ```
    git flow release start v0.1.0
    ```

  - Once you are ready to finish the release and merge with both `main` and `develop`

    ```
    git add .
    git commit -m "some commit message"
    git flow release finish v0.1.0
    git push origin --all
    git push origin --tags
    ```

  - Again, to publish your progress:

    ```
    git add .
    git commit -m "some commit message"
    git flow release publish v0.1.0
    ```

  - You can track a release

    ```
    git flow release track v0.1.0
    ```

# Using Git Flow

* Users found an issue, time for a hotfix

* To start a hotfix:

  ```
  git flow hotfix start v0.1.1
  ```

* To finish a hotfix:

  ```
  git flow hotfix finish v0.1.1
  git push origin --all
  git push origin --tags
  ```

* To start a bugfix

  ```
  git flow bugfix start v0.1.1
  ```

* To finish a bugfix

  ```
  git flow bugfix finish v0.1.1
  git push origin --all
  git push origin --tags
  ```

# Git Flow Reference

\vfill
\begin{center}
\includegraphics[width=\textwidth]{images/git/commands.eps}
\end{center}

# Resources

* [Semantic Versioning](https://semver.org/)
* [keep a changelog](https://keepachangelog.com/en/1.0.0/)
* [Documenting your projects on GitHub](https://guides.github.com/features/wikis/)
* [A Successful Branching Model](https://nvie.com/posts/a-successful-git-branching-model/)
* [Atlassian's Tutorial on GitFlow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
* [GitFlow Cheatsheet](https://danielkummer.github.io/git-flow-cheatsheet/)


# For Next Time

::: columns
:::: column

* Review the GitFlow Articles
* Review this Lecture
* Come to Class
* Continue working on Homework 02
* Complete Quiz 02
* Read Chapter 2.7

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
