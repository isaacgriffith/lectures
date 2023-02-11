# Team 01 - Project

Develop a tool that allows a user to:

* Design and/or prototype a User Interface including the ability to:
  - Construct both UI Wireframe and IFML Diagrams using a vector drawing approach
  - Be capable of viewing and editing both types of diagrams
  - Associate diagrams to a specific user and be able to save these into "folders" associated with the user
  - Be extensible to later allow collaborative editing
  - Be able to export diagrams to either PNG or SVG formats
  - Each of these functions should be provided by both the Web and Desktop UIs

# Team 02 - Project

Develop a tool that allows a user to:

* Create the following types of UML diagrams: Class, State Chart, Sequence, Use Case
  - Construct each type of diagram using a vector drawing approach and in accordance with UML 2.5
  - Be capable of viewing and editing these diagrams
  - Associate diagrams to a specific user and be able to save these into "folders" associated with the user
  - Be extensible to later allow collaborative editing
  - Be able to export diagrams to either PNG or SVG formats
  - Each of these functions should be provided by both the Web and Desktop UIs

# Team 03 - Project

Develop a tool that allows a user to:

* Create and manage a library of Essentialized practices
* Play the essence serious games
* Create both overview diagrams and cards
* Generate cards and export them to PNG or SVG
* Associate users to a team (for the games)
* Generate charts based on data from games played

# Team 04 - Project

Develop a tool that allows a user to:

* Construct a new project on GitHub populated with a standard set of Scrum Columns
* Allow the user to add, edit, and update project cards using templates for both User Stories and Use Cases
  - Should provide templates for users to fill in
  - Should include the ability to provide effort estimates in multiple units
  - Should include the ability to provide task assignments to a team member
  - Should include the ability to set priority
  - Should include the ability to update with the actual effort to complete the task
  - Should include the ability to split/slice User Stories/Use Cases 
  - Should track relationships between epics and user story splits or use cases and slices
  - Should allow the ability to add in acceptance/test criteria
  - Should connect to a user's GitHub account and use the GitHub API
  
# Project Overview

## General Project Requirements:

* As a team you will need to implement the following major components
  - A **client desktop application** implemented using JavaFX
  - A **backend server and a web frontend** implemented using Javalin and Vue.js
  - Both UI's should provide similar functionality, which includes the basic functionality (common to all projects)
    * User Login
    * Data management
    * REST API
  - The web frontend and server should be capable of being containerized using **docker** and deployable to **the cloud**
  - Your team will need to determine their testing strategy/frameworks
* As part of this, your team will need to use **Scrum** and **Essence** to guide your endeavor towards completion
  - Your team will need to fill in the details such as the programming language or languages you will be using
  - Your team will need to identify the exact underlying frameworks that will be used to implement parts of the project such as the User   Interface for the client and the server microservice.
  - Your team will also need to determine how it plans to document the requirements of the system (i.e., **user stories** or **use cases**)
  - Your team will need to host the project on **GitHub (as a private repo)** and provide access to your professor for grading.
  - Your team will need to setup a GitHub project, as this is where you will create your project board, and set up your backlog.
  - Your team will need to create items in the backlog before **sprint planning**, and demonstrate the completed items during the **sprint review**

## Minimum Viable Product 

As each project is different, each team will be required during the first week to identify the MVP of their project. This MVP must be completely functional and contain the general requirements (Desktop and Web UIs + server backend) while providing key features of the product. Also, note that each team will need to take into account that they will need to learn about the domain of their project as well as the tools necessary to implement the project.

## Project Timeline:

* Week 6: Initial project setup
* Week 7 - 8: Sprint 1
* Week 9 - 10: Sprint 2
* Week 11 - 12: Sprint 3
* Week 13 - 14: Sprint 4
* Week 15: Project Presentations

# Week 6: Initial Project Setup

By the end of this week you will need to have completed the following:

* Setup your project on GitHub
  - Including adding in a basic project structure for the languages/frameworks you have selected (be aware that you will have two coding projects within the single github project, document them accordingly)
  - Initial README.md created and a skeleton of a proper README fleshed out following GitHub's guidelines for project README's
  - Initial Changlog.md based on the template from keepachangelog.com
* Create a Project Wiki documenting the following information (which you will need to keep up-to-date as the project moves forward)
  - Team member names and their currently assigned roles
  - Programming languages and technologies used (including libraries, build systems, testing frameworks, IDE, etc.)
  - Method the team will be using for documenting project requirements
  - A Brief description of the project
* Assign roles to your team members for the first sprint, specifically the team must select a **Product Owner** and a **Scrum Master**
* Create a **GitHub Project** and a project board that will be used for maintaining your backlog and planning your sprints
* Identify the following (minimal set) of technologies that the team will be using for the project
  - Programming language for the frontend client
  - Programming language for the backend server
  - Microservice framework
  - User Interface framework
  - Testing frameworks for both frontend and backend
* Identify what your team will consider the MVP (in detail) for both the Service and Client
* Methods that team will be using to track their progress and the health of the endeavor

## Weeks 7 - 8: Sprint 01

* Sprint planned in class during Sprint Planning
* Initial server service has been implemented and runs on dev machines
* Initial client has been created
* Identified how you will connect the two together
* Initial testing complete for both the service and the client
* Project was demoed in class at the Sprint Review
* Team completed a Sprint Retrospective
* Project has been released
  - Project has a README.md documented according to the GitHub guide for README's
  - Project Changelog.md has been updated according to keepachangelog.com
  - All code is well documented
* Each team member has completed short documentation about team activities
* Each team member has completed a peer evaluation
* New Roles assigned for Sprint 2

## Weeks 9 - 10: Sprint 02

* Sprint planned in class during Sprint Planning
* Basics of gameplay have been encoded into the game manager service
* Basics of the UI have encoded into the Client
* The connection between the Client and UI have been established.
* Team completed a Sprint Retrospective
* Project has been released
  - Project has a README.md documented according to the GitHub guide for README's
  - Project Changelog.md has been updated according to keepachangelog.com
  - All code is well documented
* Each team member has completed short documentation about team activities
* Each team member has completed a peer evaluation
* New Roles assigned for Sprint 3

## Weeks 11 - 12: Sprint 03

* Sprint planned in class during Sprint Planning
* MVP for the client is complete
* MVP for the server is complete
* Project was demoed in class at the Sprint Review
  - Two dev machines connected to a single service showing the game capable of being played by two players across a network.
* Team completed a Sprint Retrospective
* Project has been released
  - Project has a README.md documented according to the GitHub guide for README's
  - Project Changelog.md has been updated according to keepachangelog.com
  - All code is well documented
* Each team member has completed short documentation about team activities
* Each team member has completed a peer evaluation
* New Roles assigned for Sprint 4

## Weeks 13 - 14: Sprint 04

* Sprint planned in class during Sprint Planning
* Service has been deployed to the cloud using a combination of docker and amazon web services
* Client if further refined
* Any capabilities of the MVP not already complete, have been completed.
* Project was demoed in class at the Sprint Review
  - Two dev machines connected to a single service showing the game capable of being played by two players across a network.
* Team completed a Sprint Retrospective
* Project has been released
  - Project has a README.md documented according to the GitHub guide for README's
  - Project Changelog.md has been updated according to keepachangelog.com
  - All code is well documented
* Each team member has completed short documentation about team activities
* Each team member has completed a peer evaluation

## Weeks 15: Project Presentation

Team has prepared a final presentation, discussing at a minimum (C-) the following

* The project
* Their development process, tools, techniques, etc.
* What they learned
* How they followed Scrum
* What they learned each sprint and how they improved
* Overall what could have gone better, what went well

**For more information see the Project Presentation assignment in Week 15.**

# Grading

* 5% - Project Setup
* 20% - Sprint 01
* 20% - Sprint 02
* 20% - Sprint 03
* 20% - Sprint 04
* 10% - Project Presentation
* 5% - Peer Evaluations

**Note:** The grading scheme above is for the group grade. Individual grades may differ based on individual participation within the project.

# Final Project Grade

* Completion of the overall Minimal Viable Product (MVP) as you have defined it (and deemed appropriate by your professor). Will lead to at most a C.
* To achieve a grade higher than a C, your team will need to achieve, in general, the following:
  - Show evidence that Scrum was followed throughout your project
  - Achieved at least 85% Code Coverage during testing
  - Complete at least two features beyond the MVP, with documented evidence of the completion
  - Complete documentation of your code in accordance with a style guide
  - Selected a style guide for your code, and follow it.
* More specific guidance will be in each project assignment.
