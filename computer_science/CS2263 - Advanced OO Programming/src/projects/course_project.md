* Need a lecture that covers logging
* Need a lecture that covers UI Design


2263 Project

Project Description:

Todo List manager, which has the following capabilities.

* The system

  - The system tracks items a user wishes to complete
  - Each item, or task, has a priority (highest, high, medium, low (default)), a title, a description, an optional due date (default is today), a set of labels, and a list (or project) to which it belongs. Additionally, an item can be complete or overdue, but not both.
  - Tasks are able to have subtasks, but subtasks are not allowed for any task that has a parent task.
  - Tasks are organized into lists, or projects, a given task may belong to more than one list. Each list has a title and a description. Additionally, lists/projects can have sublists/projects, thus forming a tree structure.
  - Lists belong to Users, thus User's are key to the system. No User can edit another user's list. Users have a unique identifier, first and last name, a picture, a short bio, an email address (used for login) and a password. Before using the system, users need to login. For now user information should be stored in a file called "./config/users.json". Users can also add comments to their list (e.g., as a reminder)
  - Lists can be further subdivided into sections. All lists come with a default section (which has no title). Each additional section (beyond default) can have a specific title and a short description to describe it. Items within a list can be moved between sections at the user's will.
  - A list can also be archived, and thus does not normally appear unless requested by the user.
  - Additionally, there is a special user called "admin" who has the capability to see a list of all users, and to reset their password, but cannot see their individual lists. Additionally, the admin user does not have any lists of their own.
  - Users should be able to search for items in the application, the results should show items matching:
    * tasks, subtasks, etc.
    * sections of a list/project
    * lists/projects, sublists/projects
    * labels
  - Users should also be able to filter or sort a list by:
    - labels (user created tags associated with items)
    - priority
    - due date
  - The system should maintain a number of settings including the following
    * base directory name for user information (i.e., "./data") relative to the base program's directory or possibly stored in the user's home directory
    * whether to log system information or not and where to store that information
    * default number of items to show per page of a list display

* When the program starts:

  - A splash screen showing the logo with copyright information should be shown for 3-5 seconds before the main application screen is loaded
  - The main screen should show the login or register screen
  
* When the User logs out of the system

  - Their data is saved and the list manager is emptied and the screen returns to login/register

* When the application is closed

  - If a user is logged in, they are first logged out
  - The application exits

* Whenever a list or task is changed:

  - The system should save the information in the JSON data file for that user
  - User data should be saved in a folder called "./data" in a file called "<user_id>.json" where `<user_id>` is the user's identifier

* Whenever a system setting is changed:

  - The application should save the information in the JSON settings file
  - System settings should be stored in "./config/config.json"

* For any task users should be able to:

  - Schedule the task for:
    - a specific date
    - the following day (tomorrow)
    - the coming weekend
    - one week later (from today)
    - or to remove the date completely
  - Set the priority to be one of the following:
    - Highest
    - High
    - Medium
    - Low
  - Add/remove a label from the task
  - Add a subtask (if not already a subtask)
  - If Overdue
    - Reschedule
  - Move to another list
  - duplicate
  - Mark as completed
  - Completed tasks from a specific list are not normally show, but can be if requested by the user.

* For the overdue task list, specifically

  - Users should be given the option to reschedule all tasks for:
    - Today
    - Tomorrow
    - This weekend
    - Next Week
    - A specific date
    - or No Date
    
* For tasks in the completed lists

  - Users should be able to move them back to their original list
  - When displaying lists, search results, overdue items, or today's items, completed items should not appear
  
* List management should allow users to:

  - Add or remove any list except:
    * Today
    * Overdue
    * Upcoming
    * Completed  
  - Select a list for display
  - Add a sublist or move a sublist from one list to another or to have no parent list

Your are required to use the following design patterns:

* Singleton: for the main class of your UI
* Command: for each command in the UI
* State: to maintain the state of your UI
* Visitor: to find labeled items
* MVC: for your UI

Your Project is Required to use the following

* Java - as the language (JDK 13+)
* GitHub - for projects
* Git - Source Code Managment
* GitFlow - Managing your git repo
* Gradle - Build and Dependency Managment
* JavaFX - UI
* GSON - for JSON data
* Checkstyle - to check your project's code style
* PMD - to check for coding issues
* SpotBugs - to check for coding issues
* Travis CI - to automate building in a fresh environment
* JPackage and JLink (part of JDK) - to create your installer
* LucidCharts - UML Diagrams
* GitHub Wiki - Project Documentation
* GitHub Pages - Project Page

Optionally you can use the following libraries/tools

* Project Lombok - to reduce boilerplate overhead

* Part 0 - Team Formation - (Week 3)
  - Team Meet and Greet
  - Team Building Activity 1
  - Team Building Activity 2
  - Work a Small Git Project as a Team
  - Select Roles
  - Team Meetings
  - Team Naming
  - Create an organization on GitHub (add your team members and me)
  - Create a Wiki

* Part 1 - Requirements (Weeks 4 - 6)
  - Requirements Gather and Specification
  - Using Use Cases
  - Test Design
  - Use Case Diagram to Relate the requirements, and actors together
  - Team Checkin
  
* Part 2 - Design (Weeks 7 - 9)
  - Class Diagrams
  - Sequence Diagrams
  - UI Diagram
  - Setup your project
    * Gradle
    * Changelog
    * License
    * Readme
    * GitFlow
  - Team Checkin
  
* Part 3 - Implementation (Weeks 10 - 12)
  - Implement Data Layer
  - Implement Logic Layer
  - Test Data and Logic Layers
  - Travis CI to automate the build and tests
  - Add in Style Checks
  - Team Checkin
  
* Part 4 - Release and Deploy (Weeks 13 - 15) 
  - Implement the UI Layer
  - Release version 1.0.0
  - Improve the Data Layer to use a DB
  - Create a Release
  - Finalize your Implementation
  - Implement an Installer
  - Prepare your presentation
  - Present
  - Team Checkin
