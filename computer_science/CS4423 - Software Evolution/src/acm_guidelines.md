# Software Evolution

**Lecture Topics**
* Software development in the context of large, pre-existing code bases
  - Software change
  - Concerns and concern location
  - Refactoring
* Software evolution
* Characteristics of maintainable software
* Reengineering systems
* Software reuse
  - Code segments
  - Libraries and frameworks
  - Components
  - Product lines

**Learning Outcomes**
* Identify the principle issues associated with software evolution and explain their impact on the software lifecycle. [F]
* Estimate the impact of a change request to an existing product of medium size. [U]
* Use refactoring in the process of modifying a software component. [U]
* Discuss the challenges of evolving systems in a changing environment. [F]
* Outline the process of regression testing and its role in release management. [F]
* Discuss the advantages and disadvantages of different types of software reuse. [F]

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
