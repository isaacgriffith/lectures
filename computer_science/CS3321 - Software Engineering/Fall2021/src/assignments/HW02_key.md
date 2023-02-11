Homework 02 - CS 3321 / INFO 3307

1.) In Scrum, during the daily scrum meeting the Product Owner is only allowed to ask the developers the same three questions. What are these questions? What two additional questions might you want to ask? For each, explain its benefit toward achieving the goals of the meeting.

(5 points in total)

* (1 point): Something to the effect of: "What have you done prior to the meeting?"
* (1 point): Something to the effect of: "What are you going to work on before the next meeting?"
* (1 point): Something to the effect of: "What is currently blocking your progress?"

(2 points) for any other interesting question related to the software endeavor (health/progress)

2.) During this course you and your team will be working on an endeavor. Towards this, you will need to define your teams' method. From the perspective of a Essence, what is the concept of a method. And, what is the method you and your team have agreed to use for your project. Please describe in as much detail as needed.

(8 points in total)

(3 points) for the following definition (or something very similar)

A "method" provides guidance for all thengs you need to do when developing and sustaining software. In simple terms this is a set of practices used by a team to complete the project.

(5 points) for a reasoned answer to the second part

3.) Construct a set of user stories for the MVP of a game of blackjack for a virtual casino. Assume there is a dealer, a single player, and the ability to make bets. As part of your user stories, include the associated acceptance tests. For each story created, the expected level of detail is: Acceptance Criteria Listed. Once you have the initial user stories defined, refine them into what would be able to be completed in a two week sprint. Through your refinement, identify any epics that may exist.

(15 points total)

Read through their user stories, ensure that each tells the story from the perspective of
a person playing the game. Each user story should be written in the form: 

As a <user/role>, I want to <describe the function the system performs>, so that <list the objective to be achieved by the user>

Each user story should have an acceptance criteria attached. Each acceptance criteria should be in the following form:

Given <initial conditions>
When <action to be performed>
Then <result>

(note: Given, When, and Then can be followed by either And or But to add additional conditions/actions)

(5 points) for stories all following the format
(5 points) for acceptance criteria following the format, and designed to evaluate the story to which they belong
(5 points) for a collection of user/stories and acceptance criteria that together describe the whole system, and which can be reasonably completed in a two-week sprint by an undergraduate CS student.

4.) Using the user stories created in #3 above, construct a set of Use Cases capturing the details of each user story. The expected level of detail for any Use-Case narrative you define is "Bulleted Outline". Once you have completed the initial use cases, estimate the time required to implement these use cases. For any use case that would take longer than a two-week sprint to complete, extract use case slices for that use case. Finally, once you have complete this work, construct a Use Case model using Lucid Charts or another UML modeling tool, to show how your use-cases and actors relate.

(10 points):
All features defined as User Stories are captured as Use Cases
* Uses the bulleted (or enumerated) outline approach
* There is at least a "basic flow" for each use case, and it does not deviate from the happy path of the feature described
* All deviations are described in the alternate flows.
* Each use case provides a time estimate (either in story points or real time)
* Each use case that would take longer than 2 weeks has been split.


(5 points): Correctly modeled UML Use Case Diagram
 * A Box with the name of the system (i.e., Blackjack centered at top of box (but inside box))
 * An oval per use case defined
 * No interconnections between use-cases implying one happens before another (i.e., constructing an algorithm from a set of use cases)
 * Only connections are between actors and use cases
 * All actors are outside the system (i.e., outside the box) with primary actors on the left-hand side

5.) Now consider how we might implement the described BlackJack system using a microservice approach. Using UML (as described in the book), design the necessary components and interfaces needed. As you finalize the design, create a table for each component (service) noting the following information: Path, HTTP method, Data Format, Data to be sent/received.

(5 points): The Component Diagram shows a client and a server with the interfaces defined in the table.

(5 points): The table meets the conditions above, and appears to show all the necessary components needed to pass information between a client and a server implementing a blackjack game, where the server contains the game logic, and the client the UI logic (i.e., display capability).
