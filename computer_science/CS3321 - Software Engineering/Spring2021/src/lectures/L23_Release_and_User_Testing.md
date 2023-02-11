---
author:
- Isaac Griffith
title: Release and User Testing
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

* Release testing
* User testing

# Release testing

* Release testing is the process of testing a particular release of a system that is intended for use outside of the development team.
* The primary goal of the release testing process is to convince the supplier of the system that it is good enough for use.
  - Release testing, therefore, has to show that the system delivers its specified functionality, performance and dependability, and that it does not fail during normal use.
* Release testing is usually a black-box testing process where tests are only derived from the system specification.

# Release testing and system testing

* Release testing is a form of system testing.
* Important differences:
  - A separate team that has not been involved in the system development, should be responsible for release testing.
  - System testing by the development team should focus on discovering bugs in the system (defect testing). The objective of release testing is to check that the system meets its requirements and is good enough for external use (validation testing).

# Requirements based testing

* Requirements-based testing involves examining each requirement and developing a test or tests for it.
* Mentcare system requirements:
  - If a patient is known to be allergic to any particular medication, then prescription of that medication shall result in a warning message being issued to the system user.
  - If a prescriber chooses to ignore an allergy warning, they shall provide a reason why this has been ignored.

# Requirements tests

\footnotesize
* Set up a patient record with no known allergies. Prescribe medication for allergies that are known to exist. Check that a warning message is not issued by the system.
* Set up a patient record with a known allergy. Prescribe the medication to that the patient is allergic to, and check that the warning is issued by the system.
* Set up a patient record in which allergies to two or more drugs are recorded. Prescribe both of these drugs separately and check that the correct warning for each drug is issued.
* Prescribe two drugs that the patient is allergic to. Check that two warnings are correctly issued.
* Prescribe a drug that issues a warning and overrule that warning. Check that the system requires the user to provide information explaining why the warning was overruled.

# A usage scenario for the Mentcare system

\scriptsize
George is a nurse who specializes in mental healthcare. One of his responsibilities is to visit patients at home to check that their treatment is effective and that they are not suffering from medication side effects.

On a day for home visits, George logs into the Mentcare system and uses it to print his schedule of home visits for that day, along with summary information about the patients to be visited. He requests that the records for these patients be downloaded to his laptop. He is prompted for his key phrase to encrypt the records on the laptop.

One of the patients that he visits is Jim, who is being treated with medication for depression. Jim feels that the medication is helping him but believes that it has the side effect of keeping him awake at night. George looks up Jim’s record and is prompted for his key phrase to decrypt the record. He checks the drug prescribed and queries its side effects. Sleeplessness is a known side effect so he notes the problem in Jim’s record and suggests that he visits the clinic to have his medication changed. Jim agrees so George enters a prompt to call him when he gets back to the clinic to make an appointment with a physician. George ends the consultation and the system re-encrypts Jim’s record.

After, finishing his consultations, George returns to the clinic and uploads the records of patients visited to the database. The system generates a call list for George of those patients who He has to contact for follow-up information and make clinic appointments.

# Features tested by scenario

* Authentication by logging on to the system.
* Downloading and uploading of specified patient records to a laptop.
* Home visit scheduling.
* Encryption and decryption of patient records on a mobile device.
* Record retrieval and modification.
* Links with the drugs database that maintains side-effect information.
* The system for call prompting.

# Performance testing

* Part of release testing may involve testing the emergent properties of a system, such as performance and reliability.
* Tests should reflect the profile of use of the system.
* Performance tests usually involve planning a series of tests where the load is steadily increased until the system performance becomes unacceptable.
* Stress testing is a form of performance testing where the system is deliberately overloaded to test its failure behavior.

#

\centering
\vfill
\Huge User testing

# User testing

* User or customer testing is a stage in the testing process in which users or customers provide input and advice on system testing.
* User testing is essential, even when comprehensive system and release testing have been carried out.
  - The reason for this is that influences from the user’s working environment have a major effect on the reliability, performance, usability and robustness of a system. These cannot be replicated in a testing environment.

# Types of user testing

* Alpha testing
  - Users of the software work with the development team to test the software at the developer’s site.
* Beta testing
  - A release of the software is made available to users to allow them to experiment and to raise problems that they discover with the system developers.
* Acceptance testing
  - Customers test a system to decide whether or not it is ready to be accepted from the system developers and deployed in the customer environment. Primarily for custom systems.

# The acceptance testing process

\begin{center}
\includegraphics[width=.85\textwidth]{images/testing/test10.eps}
\end{center}

# Stages in the acceptance testing process

* Define acceptance criteria
* Plan acceptance testing
* Derive acceptance tests
* Run acceptance tests
* Negotiate test results
* Reject/accept system

# Agile methods and acceptance testing

* In agile methods, the user/customer is part of the development team and is responsible for making decisions on the acceptability of the system.
* Tests are defined by the user/customer and are integrated with other tests in that they are run automatically when changes are made.
* There is no separate acceptance testing process.
* Main problem here is whether or not the embedded user is ‘typical’ and can represent the interests of all system stakeholders.

# Key points

* Acceptance testing is a user testing process where the aim is to decide if the software is good enough to be deployed and used in its operational environment.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
