# Tools and Environments

**Lecture Topics**
* Testing tools including static and dynamic analysis tools

**Learning Outcomes**
* Describe how available static and dynamic test tools can be integrated into the software development environment.

# Software Verification and Validation

**Lecture Topics**
* Verification and validation concepts
* Inspections, reviews, audits
* Testing types, including human computer interface, usability, reliability, security, conformance to specification
* Testing fundamentals
  - Unit, integration, validation, and system testing
  - Test plan creation and test case generation
  - Black-box and white-box testing techniques
  - Regression testing and test automation
* Defect tracking
* Limitations of testing in particular domains, such as parallel or safety-critical systems
* Static approaches and dynamic approaches to verification
* Test-driven development
* Validation planning; documentation for validation
* Object-oriented testing; systems testing
* Verification and validation of non-code artifacts (documentation, help files, training materials)
* fault logging, fault tracking and technical support for such activities
* Fault estimation and testing termination including defect seeding

**Learning Outcomes**
* Distinguish between program validation and verification. [F]
* Describe the role that tools can play in the validation of software. [F]
* Undertake, as part of a team activity, an inspection of a medium-size code segment. [U]
* Describe and distinguish among the different types and levels of testing (unit, integration, systems, and acceptance). [F]
* Describe techniques for identifying significant test cases for integration, regression and system testing. [F]
* Create and document a set of tests for a medium-size code segment. [U]
* Describe how to select good regression tests and automate them. [F]
* Use a defect tracking tool to manage software defects in a small software project. [U]
* Discuss the limitations of testing in a particular domain. [F]
* Evaluate a test suite for a medium-size code segment. [U]
* Compare static and dynamic approaches to verification. [F]
* Identify the fundamental principles of test-driven development methods and explain the role of automated testing in these methods. [F]
* Discuss the issues involving the testing of object-oriented software. [U]
* Describe approaches for the verification and validation of non-code artifacts. [F]
* Describe approaches for fault estimation. [F]
* Estimate the number of faults in a small software application based on fault density and fault seeding. [U]
* Conduct an inspection or review of software source code for a small or medium sized software project. [U]

# Formal Methods

**Lecture Topics**
* Role of formal specification and analysis techniques in the software development cycle
* Program assertion languages and approaches (including languages for writing and analyzing pre- and post-conditions, such as OCL, JML)
* Formal approaches to software modeling and analysis
  - Model checkers
  - Model finders
* Tools in support of formal methods

**Learning Outcomes**
* Describe the role formal specification and analysis techniques can play in the development of complex software and compare their use as validation and verification techniques with testing. [F]
* Apply formal specification and analysis techniques to software designs and programs with low complexity. [U]
* Explain the potential benefits and draw backs of using formal specification languages. [F]
* Create and evaluate program assertions for a variety of behaviors ranging from simple through complex. [U]
* Using a common formal specification language, formulate the specification of a simple software system and derive examples of test cases from the specification. [U]

# Static Analysis

**Lecture Topics**
* Relevant program representations, such as basic blocks, control-flow graphs, def-use chains, and static single assignment
* Undecidability and consequences for program analysis
* Flow-insensitive analyses, such as type-checking and scalable pointer and alias analyses
* Flow-sensitive analyses, such as forward and backward dataflow analyses
* Path-sensitive analyses, such as software model checking
* Tools and frameworks for defining analyses
* Role of static analysis in program optimization
* Role of static analysis in (partial) verification and bug-finding

**Learning Outcomes**
* Define useful static analyses in terms of a conceptual framework such as dataflow analysis. [U]
* Explain why non-trivial sound static analyses must be approximate. [F]
* Communicate why an analysis is correct (sound and terminating). [U]
* Distinguish "may" and "must" analyses. [F]
* Explain why potential aliasing limits sound program analysis and how alias analysis can help. [F]
* Use the results of a static analysis for program optimization and/or partial program correctness. [U]
