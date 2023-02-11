## UML Intro

1. What is the key differences between composition and aggregation relationships (visual and interpretation)?

   (c) Composition has a filled (black) diamond while Aggregation has a hollow (white) diamond both use a solid line
   (n) Composition has a hollow (white) diamond while Aggregation has a filled (black) diamond both use a solid line
   (n) Both have a filled (black) diamond but Composition uses a dashed line while Aggregation uses a solid line
   (n) Both have a hollow (white) diamond but Composition uses a dashed line while Aggregation uses a solid line

2. What is the key differences between realization and generalization relationships (visual and interpretation)?

   (c) Both use a white triangle arrow head on the abstraction side, but Generalization uses a solid line while Realization uses a dashed line.
   (n) Both use a white triangle arrow head on the abstraction side, but Realization uses a solid line while Generalization uses a dashed line.
   (n) Generalization uses a white triangle arrow head and Realization uses an open arrow head on the abstraction side, both use a solid line.
   (n) Realization uses a white triangle arrow head and Generalization uses an open arrow head on the abstraction side, both use a solid line.

# OO Lang Features

3. Which of the following access modifiers require that the a component be either the same class or a descendant in order to access the item?

  (n) public
  (n) private
  (c) protected
  (n) package-protected

4. True or False. A method X in class A has default (no access modifier specified) access. Class B extends A. Class A is in package foo and class B is in package foo.bar. True or False, objects of type B can access method X in objects of class A?

  (c) False

5. True or False. A package can be split across multiple modules.

  (c) False

6. Let's say you currently working on a release called "v0.1.0" you started using gitflow. Select the one which best describes what happens when you execute the following command:

  `$ git flow release finish v0.1.0`

  (c)  Checks out develop
       Merges releases/v0.1.0 with develop
       Checks out main
       Merges develop with main
       Tags main as "v0.1.0"
       Checks out develop
       Deletes branch releases/v0.1.0

  (n)  Checks out develop
       Merges releases/v0.1.0 with develop
       Checks out main
       Merges develop with main
       Tags main as "v0.1.0"
       Checks out develop

  (n)  Checks out develop
       Checks out main
       Merges develop with main
       Merges releases/v0.1.0 with develop
       Checks out develop
       Tags main as "v0.1.0"
       Deletes branch releases/v0.1.0

  (n)  Checks out develop
       Merges releases/v0.1.0 with develop
       Checks out main
       Merges develop with main
       Tags main as "v0.1.0"

# Principles

Matching

* SRP - Classes should not have more than one focus
* OCP - Code should be open for extension but closed for modification
* ISP - Clients should not be forced to depend on methods they don't use
* DIP - Don't depend on concrete classes, depend on abstractions
* DRY - Avoid duplicate code
* LC - Strive for loosely coupled designs of autonomous, interacting objects
* EV - Encapsulate code that changes a lot.
* SoC
* LSP
* LoK

# Exceptions

* Which of the following types of exceptions cannot be caught?
  - **Error**
  - Checked Exception
  - Runtime Exception

* Which of the following types of exceptions must either caught or thrown in order for your code to compile?
  - Error
  - **Checked Exception**
  - Runtime Exception
