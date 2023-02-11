---
course: CSCI 2263
title: "HW 01 - "
assigned: ""
due: " @ 23:00h"
...

# Assignment {-}

You will implement the game Lights Out. Follow the instructions for the server part (Homework 1) on the README for the Lights Out starter kit.

Submit the assignment via Gradescope (see Piazza for Gradescope sign up Entry Code). Submit the whole project in the .zip. The project must be in the root of the .zip, not in a folder.

When you submit the assignment, the autograder will run tests and show you which are passing and which are failing. It won’t show you a final grade, however, because some tests are hidden from you. You have to read the API specification and follow it. Pay attention to the error cases. It may help you to add requests for error cases in Postman yourself.

“It works” is the biggest lie in software engineering. Your code must not only pass the tests, but also follow good basic software engineering principles course. The architecture of the To Do app is a good starting point. We will evaluate whether you are using proper Java packages and naming conventions, whether responsibilities are separated appropriately, and so forth. This will constitute 20% of your grade for this homework.

* All classes should be declared within packages, for example, edu.jhu.cs.pl.lights_out. Use of the default package is unacceptable in any large software project.
* All identifiers must meet Java naming convention standards. Non-final fields and local variables should be named in lower camel case, for example, helloWorld, variableName, testOneTwoThree. Types should be named in upper camel case, for example, ArrayList, MyVeryOwnClass, HtmlReader. Final fields should be named in underscore-separated caps, for example, SINGLETON, SPECIAL_VALUE, LOCAL_TAX_RATE. No identifier should contain the $ character under any circumstances.
* Give methods and variables meaningful names. The definition of a meaningful name is subjective, of course, but it should be obvious that connectionMapping is a more descriptive name than temp42.
* Empty catch blocks are bad practice. If a method throws an exception, it is trying to tell you something. Simply ignoring it is just as bad as ignoring a method’s return value or any other information at your disposal. If the exception is truly meaningless to you, at least throw some form of runtime exception wrapping it and include a comment indicating that the code cannot be reached for whatever logical reason.
* Program to interfaces, not to classes. For variables, always use the least specific interface which supports your needs. For instance, use List instead of ArrayList.
* Use generics when appropriate. For instance, declaring a variable of type List<String> is better practice than declaring a variable of type List. Using generic type variables drastically reduces the amount of time you spend debugging dyanmic type errors.
* If a method returns a boolean, make that clear in the method name: isWanted, etc.
Use active voice (imperative): i.e.: deleteInvoice()
Don’t re-use temporary variables


# Submission {-}
