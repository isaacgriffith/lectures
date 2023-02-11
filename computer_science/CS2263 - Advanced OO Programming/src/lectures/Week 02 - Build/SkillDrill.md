## Preliminaries

* Ensure that you have Gradle (most recent version) installed on your system
* Verify that you can run it from the command line

## Gradle

1. Create a new GitHub Repo called "gradle-skilldrill"
2. Clone your repo on your local machine
3. At the command line, initialize the newly cloned repo to be a gradle **Java Application** project
   - set the base package name to be "edu.isu.cs.cs2263"
   - Use JUnit Jupyter as the testing framework
4. Verify that you can test and run your code using the appropriate gradle commands
5. Commit and push your changes to GitHub
6. Create a release calling this version 1.0 of your repo

## JavaFX and Gson

1. Update your gradle build to include JavaFX and Gson
2. Run the build to verify everything still works
3. Let's build a very quick application
   1. Create two data classes
      - Student, which has a first and last name
      - Course, which has a Subject code (CS, PHYS, etc), a number (2263, 1181, etc), and a title
      - For both add a toString method which:
        - Student returns their first and last name concatenated together, i.e., Isaac Griffith
        - Course returns the subject code followed by number a dash and the title, i.e., CS 2263 - Advanced OO Programming
      - Both classes should be capable of being stored using Gson
      - 
