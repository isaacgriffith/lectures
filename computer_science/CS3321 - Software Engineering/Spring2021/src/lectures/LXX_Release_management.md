---
author:
- Isaac Griffith
title: Release Management
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Topics Covered

* Release management

# Release management

* A system release is a version of a software system that is distributed to customers.
* For mass market software, it is usually possible to identify two types of release: major releases which deliver significant new functionality, and minor releases, which repair bugs and fix customer problems that have been reported.
* For custom software or software product lines, releases of the system may have to be produced for each customer and individual customers may be running several different releases of the system at the same time.

# Release components

* As well as the the executable code of the system, a release may also include:
  - configuration files defining how the release should be configured for particular installations;
  - data files, such as files of error messages, that are needed for successful system operation;
  - an installation program that is used to help install the system on target hardware;
  - electronic and paper documentation describing the system;
  - packaging and associated publicity that have been designed for that release.

# Factors influencing system release planning

* **Competition** - For mass-market software, a new system release may be necessary because a competing product has introduced new features and market share may be lost if these are not provided to existing customers.

* **Marketing requirements** - The marketing department of an organization may have made a commitment for releases to be available at a particular date.

* **Platform changes** - You may have to create a new release of a software application when a new version of the operating system platform is released.

* **Technical quality of the system** - If serious system faults are reported which affect the way in which many customers use the system, it may be necessary to issue a fault repair release. Minor system faults may be repaired by issuing patches (usually distributed over the Internet) that can be applied to the current release of the system.

# Release creation

* The executable code of the programs and all associated data files must be identified in the version control system.
* Configuration descriptions may have to be written for different hardware and operating systems.
* Update instructions may have to be written for customers who need to configure their own systems.
* Scripts for the installation program may have to be written.
* Web pages have to be created describing the release, with links to system documentation.
* When all information is available, an executable master image of the software must be prepared and handed over for distribution to customers or sales outlets.

# Release tracking

* In the event of a problem, it may be necessary to reproduce exactly the software that has been delivered to a particular customer.
* When a system release is produced, it must be documented to ensure that it can be re-created exactly in the future.
* This is particularly important for customized, long-lifetime embedded systems, such as those that control complex machines.
  - Customers may use a single release of these systems for many years and may require specific changes to a particular software system long after its original release date.

# Release reproduction

* To document a release, you have to record the specific versions of the source code components that were used to create the executable code.
* You must keep copies of the source code files, corresponding executables and all data and configuration files.
* You should also record the versions of the operating system, libraries, compilers and other tools used to build the software.

# Release planning

* As well as the technical work involved in creating a release distribution, advertising and publicity material have to be prepared and marketing strategies put in place to convince customers to buy the new release of the system.
* Release timing
  - If releases are too frequent or require hardware upgrades, customers may not move to the new release, especially if they have to pay for it.
  - If system releases are  too infrequent, market share may be lost as customers move to alternative systems.

# Software as a Service

* Delivering software as a service (SaaS) reduces the problems of release management.
* It simplifies both release management and system installation for customers.
* The software developer is responsible for replacing the existing release of a system with a new release and this is made available to all customers at the same time.

# Key points

* System releases include executable code, data files, configuration files and documentation. Release management involves making decisions on system release dates, preparing all information for distribution and documenting each system release.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
