---
author:
- Dr. Isaac Griffith
title: GitFlow
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Daily Quiz

* Starting at 14:02
  - You will have 5 minutes
  - You may not use your notes, books, lectures, or the internet
  - You may not help each other

\vfill
\centering

\LARGE \underline{Passcode}

\Huge \textbf{8836}

# Practicum

**Create a new Repository on GitHub named "gitflow-test", and during creation be sure to allow GitHub to add the following:**

* a `README.md`
* default `.gitignore` file for the `Java` language
* use the `MIT` license

**Next clone the repo on your local machine**

* In the cloned folder, initialized it as a gradle project using the defaults for a `Java Application` tested using `JUnit Jupiter`
* Once all of this is done, commit the changes and push to the `orgin` as the "Initial Commit"

**Once everyone is ready we will move on to the next section**

# Practicum


**Using GitFlow**

\footnotesize

1. Initialize the project using GitFlow
2. Start a new Feature called "first-feature"
   - \scriptsize Make some small change to the `App.java` file (but one that compiles and visibly changes the behavior of the program)
3. Finish the Feature
   - \scriptsize Don't forget to `push --all` to the `origin`
4. Start a new Release called "v0.0.1"
   - \scriptsize Add a ChangeLog, with the appropriate documentation for the release v0.0.1
   - \scriptsize Update your README.md as needed
5. Finish the release
   - \scriptsize Once finished be sure to `push --all` and `push --tags` to the `origin`
   - \scriptsize Verify that the tag for `v0.0.1` exists on GitHub and that it shows a release
