


# Project 01

(5 Members)

Develop a tool which allows a user to:

* Web side (via microservice) (Javalin + Vue.js)
  - Create a user account
  - Be capable of viewing and editing both UI Wireframes and IFML Diagrams
  - Be Able to store the diagrams in separate folders
  - Be extensible to later allow collaborative editing (but not at this time)
* Desktop (via JavaFX)
  - Be capable of logging into the server and open diagrams for editing
  - Be able to create and/or edit both UI Wireframes and IFML Diagrams
  - Be extensible enough to later allow collaborative editing (but not at this time)
* Both
  - Be able to export drawings in the following formats (minimal):
    * SVG
    * PNG
    * JPG

# Project 02

Develop a tool which allows a user to:

* Create the following UML Diagrams:
  - Class Diagrams
  - Sequence Diagrams
  - State Charts
  - Use Case Diagrams
* The diagrams should be correct to UML 2.5
  - Should have an underlying model
* The interface should allow users to interact via the web (microservice using Javaline + Vue.js) or Desktop (JavaFX)
  - Users should login
  - Users should be able to store/retrieve/update diagrams
  - Users should be able to export diagrams as:
    * SVG
    * PNG

# Project 03

(4 Members)

Develop a tool which allows a user to:

* Create and manage a library of essentialized practices
* Play the essence serious games with the essence alphas and any alphas from additional practices they have included
* The interface should allow users to interact via the Web (via microservice) (Javalin + Vue.js) or Desktop (JavaFX)
  - Create a user account and associate the user to a team and be able to login
  - Be able to create models of an essentialized practice
  - Be able to manage a library of practices
  - Be able to generate cards for each of the essence components (i.e., alphas, work products, etc.)
  - Be able to edit cards
  - Be able to delete cards and/or practices
  - Provide a means to play the serious games
* Be able to export generated cards in the following formats
  - SVG
  - PNG
* Be able to provide charts based on game data on either the web interface or the desktop app

# Project 04

Develop a tool which allows a user to:

* Construct a new project on GitHub populated with a standard set of Scrum Columns
* Allows a user to add, edit, and update projects cards using templates
  - One for User Stories
    - Including Acceptance Criteria
  - One for Use Cases
    - Including Acceptance Criteria
  - Both templates should include ability to set the following items
    - Team member to which the card is assigned
    - Priority of the item
    - Effort estimation in Engineering Hours, Ideal Hours, Story Points
      * Worst Case (optional)
      * Best Case (optional)
      * Nominal Case
    - Actual Effort required in Engineering Hours, Ideal Hours, Story Points
  - Ability to update the current level of each item as defined by the Essence Cards
    - User Story
    - Test Cases / Acceptance Criteria
    - Use Cases
  - Allow for the ability to create User Story Splits and managing the relationship between Epics and User Stories
  - Allow for the ability to create Use Case Slices and managing the relationship between Slices and Use Cases
  - Generate an image depicting the Use Case Model
* Adding, editing, or updating cards should update the project board on GitHub (via GitHub's APIs)
* You will need to construct two User Interfaces
  - A simple web interface using Vue.js that allows users to login (using their GitHub credentials) and connect to their related GitHub account
    * Additionally, this interface should show some basic charts that track progress of the project beyond what is provided by GitHub
  - A Desktop app that connects to your server and github to display and manage the cards
    * You should have the ability to see the same/similar charts here
