---
author:
- Isaac Griffith
title: Design and Implementation
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Topics covered

* Design patterns
* Implementation issues
* Open source development

#

\centering
\vfill
\Huge Design patterns

# Design patterns

* A design pattern is a way of reusing abstract knowledge about a problem and its solution.
* A pattern is a description of the problem and the essence of its solution.
* It should be sufficiently abstract to be reused in different settings.
* Pattern descriptions usually make use of object-oriented characteristics such as inheritance and polymorphism.

# Patterns

* Patterns and Pattern Languages are ways to describe best practices, good designs, and capture experience in a way that it is possible for others to reuse this experience.

# Pattern elements

* Name
  - A meaningful pattern identifier.
* Problem description.
* Solution description.
  - Not a concrete design but a template for a design solution that can be instantiated in different ways.
* Consequences
  - The results and trade-offs of applying the pattern.


# The Observer pattern

* Name
  - Observer.
* Description
  - Separates the display of object state from the object itself.
* Problem description
  - Used when multiple displays of state are needed.
* Solution description
  - See slide with UML description.
* Consequences
  - Optimizations to enhance display performance are impractical.

# The Observer pattern

* **Description**
  - Separates the display of the state of an object from the object itself and allows alternative displays to be provided. When the object state changes, all displays are automatically notified and updated to reflect the change.

* **Problem Description**
  - In many situations, you have to provide multiple displays of state information, such as a graphical display and a tabular display. Not all of these may be known when the information is specified. All alternative presentations should support interaction and, when the state is changed, all displays must be updated.
  - This pattern may be used in all situations where more than one display format for state information is required and where it is not necessary for the object that maintains the state information to know about the specific display formats used.

* **Solution Description**
  - This involves two abstract objects, Subject and Observer, and two concrete objects, ConcreteSubject and ConcreteObject, which inherit the attributes of the related abstract objects. The abstract objects include general operations that are applicable in all situations. The state to be displayed is maintained in ConcreteSubject, which inherits operations from Subject allowing it to add and remove Observers (each observer corresponds to a display) and to issue a notification when the state has changed.
  - The ConcreteObserver maintains a copy of the state of ConcreteSubject and implements the Update() interface of Observer that allows these copies to be kept in step. The ConcreteObserver automatically displays the state and reflects changes whenever the state is updated.

* **Consequences**
  - The subject only knows the abstract Observer and does not know details of the concrete class. Therefore there is minimal coupling between these objects. Because of this lack of knowledge, optimizations that enhance display performance are impractical. Changes to the subject may cause a set of linked updates to observers to be generated, some of which may not be necessary.

# Multiple displays (observer)

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/design/design09.eps}

# Observer UML model

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/design/design10.eps}

# Design problems

* To use patterns in your design, you need to recognize that any design problem you are facing may have an associated pattern that can be applied.
  - Tell several objects that the state of some other object has changed (Observer pattern).
  - Tidy up the interfaces to a number of related objects that have often been developed incrementally (Façade pattern).
  - Provide a standard way of accessing the elements in a collection, irrespective of how that collection is implemented (Iterator pattern).
  - Allow for the possibility of extending the functionality of an existing class at run-time (Decorator pattern).

#

\centering
\vfill
\Huge Implementation issues

# Implementation issues

* Focus here is not on programming, although this is obviously important, but on other implementation issues that are often not covered in programming texts:
  - \color{Roarange}Reuse \color{Black}Most modern software is constructed by reusing existing components or systems. When you are developing software, you should make as much use as possible of existing code.
  - \color{Roarange}Configuration management \color{Black}During the development process, you have to keep track of the many different versions of each software component in a configuration management system.
  - \color{Roarange}Host-target development \color{Black}Production software does not usually execute on the same computer as the software development environment. Rather, you develop it on one computer (the host system) and execute it on a separate computer (the target system).

# Reuse

* From the 1960s to the 1990s, most new software was developed from scratch, by writing all code in a high-level programming language.
  - The only significant reuse or software was the reuse of functions and objects in programming language libraries.
* Costs and schedule pressure mean that this approach became increasingly non-viable, especially for commercial and Internet-based systems.
* An approach to development based around the reuse of existing software emerged and is now generally used for business and scientific software.

# Reuse levels

* The abstraction level
  - At this level, you don’t reuse software directly but use knowledge of successful abstractions in the design of your software.
* The object level
  - At this level, you directly reuse objects from a library rather than writing the code yourself.
* The component level
  - Components are collections of objects and object classes that you reuse in application systems.
* The system level
  - At this level, you reuse entire application systems.

# Software reuse

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/design/design11.eps}

# Reuse costs

* The costs of the time spent in looking for software to reuse and assessing whether or not it meets your needs.
* Where applicable, the costs of buying the reusable software. For large off-the-shelf systems, these costs can be very high.
* The costs of adapting and configuring the reusable software components or systems to reflect the requirements of the system that you are developing.
* The costs of integrating reusable software elements with each other (if you are using software from different sources) and with the new code that you have developed.

# Configuration management

* Configuration management is the name given to the general process of managing a changing software system.
* The aim of configuration management is to support the system integration process so that all developers can access the project code and documents in a controlled way, find out what changes have been made, and compile and link components to create a system.
* See also Chapter 25.

# Configuration management activities

* Version management, where support is provided to keep track of the different versions of software components. Version management systems include facilities to coordinate development by several programmers.
* System integration, where support is provided to help developers define what versions of components are used to create each version of a system. This description is then used to build a system automatically by compiling and linking the required components.
* Problem tracking, where support is provided to allow users to report bugs and other problems, and to allow all developers to see who is working on these problems and when they are fixed.

# Conf mgmt tool interaction

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/design/design12.eps}

# Host-target development

* Most software is developed on one computer (the host), but runs on a separate machine (the target).
* More generally, we can talk about a development platform and an execution platform.
  - A platform is more than just hardware.
  - It includes the installed operating system plus other supporting software such as a database management system or, for development platforms, an interactive development environment.
* Development platform usually has different installed software than execution platform; these platforms may have different architectures.

# Host-target development

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/design/design13.eps}

# Development platform tools

* An integrated compiler and syntax-directed editing system that allows you to create, edit and compile code.
* A language debugging system.
* Graphical editing tools, such as tools to edit UML models.
* Testing tools, such as JUnit that can automatically run a set of tests on a new version of a program.
* Project support tools that help you organize the code for different development projects.

# IDEs

* Software development tools are often grouped to create an integrated development environment (IDE).
* An IDE is a set of software tools that supports different aspects of software development, within some common framework and user interface.
* IDEs are created to support development in a specific programming language such as Java. The language IDE may be developed specially, or may be an instantiation of a general-purpose IDE, with specific language-support tools.

# Component/system deployment

\footnotesize
* If a component is designed for a specific hardware architecture, or relies on some other software system, it must obviously be deployed on a platform that provides the required hardware and software support.
* High availability systems may require components to be deployed on more than one platform. This means that, in the event of platform failure, an alternative implementation of the component is available.
* If there is a high level of communications traffic between components, it usually makes sense to deploy them on the same platform or on platforms that are physically close to one other. This reduces the delay between the time a message is sent by one component and received by another.

#

\centering
\vfill
\Huge Open source development

# Open source development

* Open source development is an approach to software development in which the source code of a software system is published and volunteers are invited to participate in the development process
* Its roots are in the Free Software Foundation (www.fsf.org), which advocates that source code should not be proprietary but rather should always be available for users to examine and modify as they wish.
* Open source software extended this idea by using the Internet to recruit a much larger population of volunteer developers. Many of them are also users of the code.

# Open source systems

* The best-known open source product is, of course, the Linux operating system which is widely used as a server system and, increasingly, as a desktop environment.
* Other important open source products are Java, the Apache web server and the mySQL database management system.

# Open source issues

* Should the product that is being developed make use of open source components?
* Should an open source approach be used for the software’s development?

# Open source business

* More and more product companies are using an open source approach to development.
* Their business model is not reliant on selling a software product but on selling support for that product.
* They believe that involving the open source community will allow software to be developed more cheaply, more quickly and will create a community of users for the software.

# Open source licensing

* A fundamental principle of open-source development is that source code should be freely available, this does not mean that anyone can do as they wish with that code.
  - Legally, the developer of the code (either a company or an individual) still owns the code. They can place restrictions on how it is used by including legally binding conditions in an open source software license.
  - Some open source developers believe that if an open source component is used to develop a new system, then that system should also be open source.
  - Others are willing to allow their code to be used without this restriction. The developed systems may be proprietary and sold as closed source systems.

# License models

* The GNU General Public License (GPL). This is a so-called ‘reciprocal’ license that means that if you use open source software that is licensed under the GPL license, then you must make that software open source.
* The GNU Lesser General Public License (LGPL) is a variant of the GPL license where you can write components that link to open source code without having to publish the source of these components.
* The Berkeley Standard Distribution (BSD) License. This is a non-reciprocal license, which means you are not obliged to re-publish any changes or modifications made to open source code. You can include the code in proprietary systems that are sold.

# License management

* Establish a system for maintaining information about open-source components that are downloaded and used.
* Be aware of the different types of licenses and understand how a component is licensed before it is used.
* Be aware of evolution pathways for components.
* Educate people about open source.
* Have auditing systems in place.
* Participate in the open source community.

# Key points

* When developing software, you should always consider the possibility of reusing existing software, either as components, services or complete systems.
* Configuration management is the process of managing changes to an evolving software system. It is essential when a team of people are cooperating to develop software.
* Most software development is host-target development. You use an IDE on a host machine to develop the software, which is transferred to a target machine for execution.
* Open source development involves making the source code of a system publicly available.  This means that many people can propose changes and improvements to the software.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
