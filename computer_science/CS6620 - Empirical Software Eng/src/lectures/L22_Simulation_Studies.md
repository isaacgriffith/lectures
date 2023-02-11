---
author:
- Isaac Griffith
title: Simulation Studies
institute: |
  CS 6620

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Why Simulation

* Simulations
  - analyze the behavior of complex processes

* Useful in SE Process Research
  - Static models even with data are still hard to anticipate
  - Software processes contain iterations and rework loops
    - leading to delays ranging from minutes to years

# Why Simulation

* Static process descriptions (i.e., flow charts)
  - Do not shed much light on the behavior of a process over time

* The usual process analysis method is a case study
  - requires actual engineers
  - extremely costly
  - does not generalize to other contexts

# Simulation

* Simulation provides
  - means to clarify assumptions/mental models
  - visualize the implicit mental models that govern observed process behavior
  - support understanding, analysis, prediction, and decision-support

* Simulations act like virtual laboratories
  - hypotheses about problems may be tested
  - corrective policies experimented with
  - provides significant benefits to management decision support
  - can be integrated with systematic experimentation and other empirical research
  - supports project planning and estimation

# Effective Simulation

* Simulation is only effective
  - model reflects real world
  - data used to drive the model reflects real world

* Quantitative output requires
  - quantitative expert estimates, or
  - measurement data

* To minimize data collection effort
  - focus on key variables
  - leads to identifying relevant factors for measurement program

# Simulation Modeling Process

\centering
\includegraphics[width=.80\textwidth]{images/experimentation/sim01.eps}

# Problem Statement

* Defines the modeling goal and focuses the modeling activities
* Defines model purpose and scope (Kellner 1999):
  - Purpose
    * strategic management
    * planning, control and operational management
    * process improvement and technology adoption
    * understanding
    * training and learning
  - Scope
    * a portion of the life cycle
    * a development project
    * multiple, concurrent projects
    * long-term product evolution
    * long-term organization

# Reference Behavior

* Ensures that the problem statement is sutable for simulation-based problem-solving
* **Reference Behavior**
  - captures dynamic variation of key attributes of real-world entities
  - can be both:
    - observed problematic behavior to be analyzed and improved
    - desired behavior to be achieved
  - Importance:
    - identifies important model (output) parameters
    - focuses subsequent modeling steps
    - input to model validation for comparing simulation results to observed (or desired) behavior

# Defining Model Concepts

1. Existing process, quality, and resource models
2. Implicit or explicit decision rules
3. Typical observed behavior patterns
4. Organizational information flows
5. Policies

# Model Concepts

* Either quantitative or qualitative models
  - abstractions of behaviors observed in reality
  - captures implicit and tacit expert knowledge as rules

* Domain Experts
  - have knowledge not found in documents/databases alone
  - help distinguish relevant and irrelevant real-world data

# Model Concepts

* Model concepts are implemented into a simulation tool
* Domain knowledge is represented in the simulation
* Result is then an **executable model**

# Executable Model

* Last step is **model calibration and experimentation**
  - Experiments are performed to understand the system's behavior
  - Calibration is the adjustment of model parameters until the output corresponds with real-world data
  - Both go hand-in-hand

* Calibration can be done through
  - expert estimation
  - parameter fitting based on historic data

# Executable Model

* Calibration helps to build confidence in the model
  - Once calibrated experiments are used to:
    - understand observed behavior
    - evaluate planning alternatives
    - explore improvement opportunities

* Output: **simulation results**

# Model V&V

- **Verification** - ensures the model fits its intended purpose
  * check internal correctness/appropriateness
  * requires expert knowledge concerning selected simulation technique
  * partially supported by tools
- **Validation** - ensures the model appropriately reflects the real-world behavior
  * check whether transformation steps defined in the simulation have been conducted correctly
  * checks whether the model represents structural/behavioral properties of the real system
  * partly supported by tools
  * requires expert knowledge about the real-world system
- These activities continue throughout the modeling life-cycle

# SE Applications

::: columns
:::: column
* Project management
* Risk management
* Product and Requirements Engineering
* Process Engineering
* Strategic Planning
* Quality assurance and management
::::
:::: column
* Software maintenance and evolution
* Global software development
* Software acquisition management and COTS
* Product-lines
* Training and education
::::
:::

# Simulation Techniques

* **Deterministic** vs. **Stochastic**
* **Static** vs. **Dynamic**
* **Continuous** vs. **Event-Driven**
* **Quantitative** vs. **Qualitative**

# Deterministic vs Stochastic

* **Stochastic** - has probabilistic components
  - outputs depend on stochastic variation of (due to random sampling of statistical distributions)
    * input parameters
    * internal model variables
* **Deterministic** - non-probabilistic
  - for same inputs will have same outputs

* You need to remember to repeat stochastic simulation runs to see the output distribution
  - number of runs is depends upon
    * computing power limitations
    * confidence required for results

# Static vs Dynamic

* **Static** - captures variation at one single point in time
  - Monte Carlo simulations
* **Dynamic** - captures variation over a period of time

# Continuous vs ED

* Both are types of Dynamic Simulations

* **Continuous**
  - update variables at equidistant time steps using defined equations
  - based on a set of linear differential equations
  - Best known approach: **System Dynamics** (SD)

* **Event-Driven**
  - updates values of variables as events occur
  - Best known approach: discrete-event (DE) simulation
    * Models are represented as a network of activities
    * Items then flow through the network triggering events
    * Events may occur at any time

# Quantitative vs Qualitative

* **Quantitative**
  - Model params are specified as real or integer numbers
    - needs empirical data of sufficient quantity and quality
    - experts to provide estimates

* **Qualitative**
  - approach to understand general behavior patterns of dynamic systems
  - useful when conclusions must be drawn from insufficient data

# Hybrid Simulation

* Combining continuous and event-driven
* Combining deterministic with stochastic elements

* Benefit
  - gain advantages of both model types
* Drawback
  - increased complexity

# SD vs. DE

* System Dynamics
  - captures complex process behavior via a small set of core constructs
  - possible to reuse a set of generic model patterns
  - focuses on modeling the average of a system
  - captures cause/effect relationships better

* Discrete Event
  - Complementary perspective to SD
  - Provides a more detailed view of system behavior
  - Utilizes attributes/properties of modeled components which may be refined
  - Easily adaptable to changes
  - Can model distinct real-world entities
  - may capture too many details

# Practical Aspects

* Simulation is not a "silver bullet"
  - Garbage in = Garbage out
  - Predictive power depends upon model validity
* Often simulation is not practical
  - human actors data gathering is often very costly
  - may not be able to reproduce simulated events for purposes of validation

# Practical Aspects

* Simulation is only a simplification of the real-world
  - we cannot prove a priori model correctness
  - more tests and observations leads to more confidence

* Simulation is not:
  - a means unto itself (requires follow-up action)
  - a means to generate ideas

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
