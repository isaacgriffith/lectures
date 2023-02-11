# PD/Distributed Systems

Topics:
* Distributed Service design
  - Stateful versus stateless protocols and services
  - Session (connection-based) designs
  - Reactive (IO-triggered) and multithreaded designs
* Distributed message sending
  - Data conversion and transmission
  - Sockets
  - Message sequencing
  - Buffering, retrying, and dropping messages
* Faults
  - Network-based (including partitions) and node-based failures
  - Impact on system-wide guarantees (e.g., availability)

Outcomes:
* Explain why no distributed system can be simultaneously consistent, available, and partition tolerant. [F]
* Implement a simple server -- for example, a spell checking service. [U]
* Explain the tradeoffs among overhead, scalability, and fault tolerance when choosing a stateful v. stateless design for a given service. [F]
* Describe the scalability challenges associated with a service growing to accommodate many clients, as well as those associated with a service only transiently having many clients. [F]

# SE/Requirements Engineering

Topics:
* Describing functional requirements using, for example, use cases or user stories
* Properties of requirements including consistency, validity, completeness, and feasibility
* Software requirements elicitation
* Describing system data using, for example, class diagrams or entity-relationship diagrams
* Non-functional requirements and their relationship to software quality
* Evaluation and use of requirements specifications
* Requirements analysis modeling techniques
* Acceptability of certainty/uncertainty considerations regarding software/system behavior
* Prototyping
* Basic concepts of formal requirements specification
* Requirements specification
* Requirements validation
* Requirements tracing

Outcomes:
* List the key components of a use case or similar description of some behavior that is required for a system [F]
* Describe how the requirements engineering process supports the elicitation and validation of behavioral requirements. [F]
* Interpret a given requirements model for a simple software system. [F]
* Describe the fundamental challenges of and common techniques used for requirements elicitation. [F]
* List the key components of a data model (e.g., class diagrams or ER diagrams). [F]
* Identify both functional and non-functional requirements in a given requirements specification for a software system. [U]
* Conduct a review of a set of software requirements to determine the quality of the requirements with respect to the characteristics of good requirements. [U]
* Apply key elements and common methods for elicitation and analysis to produce a set of software requirements for a medium-sized software system. [U]
* Compare the plan-driven and agile approaches to requirements specification and validation and describe the benefits and risks associated with each. [F]
* Use a common, non-formal method to model and specify the requirements for a medium-size software system. [U]
* Translate into natural language a software requirements specification(e.g., a software component contract) written in a formal specification language. [U]
* Create a prototype of a software system to mitigate risk in requirements. [U]
* Differentiate between forward and backward tracing and explain their roles in the requirements validation process. [F]

# SE/Software Design

Topics:
* Relationsips between requirements and designs: tranformation of models, design of contracts, invariants
* Software architecture concepts and standard architectures (e.g., client-server, n-layer, tranform centered, pipes-and-filters)
* The use of components in design: component selection, design, adaptation and assembly of components, components and patterns, components and objects
* Measurement and Analysis of design quality
* Tradeoffs between different aspects of quality
* Application frameworks
* Middleware: the object-oriented paradigm within middleware, object request brokers and marshalling, transaction processing monitors, workflow systems

Outcomes:
* Explain the relationships between the requirements for a software product and its design, using appropriate models. [A]
* For the design of a simple software system within the context of a single design paradigm, describe the software architecture of that system. [F]
* Given a high-level design, identify the software architecture by differentiating among common software architectures such as 3-tier, pipe-and-filter, and client-server. [F]
* Investigate the impact of software architectures selection on the design of a simple system. [A]
* Apply simple examples of patterns in a software design. [U]
* Select suitable components for use in the design of a software product. [U]
* Explain how suitable components might need to be adapted for use in design of a software product. [F]
* Design a contract for a typical small software component for use in a given system. [U]
* Discuss and select appropriate software architecture for a simple system suitable for a given scenario. [U]
* Apply models for internal and external qualities in designing software components to achieve an acceptable tradeoff between conflicting quality aspects. [U]
* Explain the role of objects in middleware systems and the relationship with components. [Familiarity]
* Apply component-oriented approaches to the design of a range of software, such as using componetns for concurrency and transactions, for reliable communication services, for database interaction including services for remote query and database management, or for secure communication and access. [U]

Software Structure and Architecture

Topics:

* Architectural Structures and Viewpoints

* Architectural Styles

* Design Patterns

* Architectural Design Decisions

* Families of Programs and Frameworks

Software Configuration Management

Topics:

* Software Building

* Software Release Management

Software Requirements

Topics:

* Software Requirements Fundamentals
  - Definition of a requirement
  - Product and Process Requirements
  - Functional and Nonfunctional Requirements
  - Emergent Properties
  - Quantifiable Requirements
  - System Requirements and Software Requirements
* Requirements Process
  - Process Models
  - Process Actors
  - Process Support and Management
  - Process Quality and Improvement
* Requirements Elicitation
  - Requirements Sources
  - Elicitation Techniques
* Requirements Analysis
  - Requirements Classification
  - Conceptual Modeling
  - Architectural Design and Requirements Allocation
  - Requirements Negotiation
  - Formal Analysis
* Requirements Specification
  - System Definition Document
  - System Requirements Specification
  - Software Requirements Specification
* Requirements Validation
  - Requirements Reviews
  - Prototyping
  - Model Validation
  - Acceptance Tests
* Practical Considerations
  - Iterative Nature of the Requirements Process
  - Change Management
  - Requirements Attributes
  - Requirements Tracing
  - Measureing Requirements
