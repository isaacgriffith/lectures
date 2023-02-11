---
author:
- Isaac Griffith
title: Reuse and Domain Engineering
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand and describe reuse maturity models
* Understand and describe reuse cost models
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Reuse and\\Domain Engineering
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Maturity Models

* A reuse maturity model is an aid for performing planning and self-assessment to improve an organization’s capability to reuse existing software artifacts.
* Maturity model helps the organization’s understanding of their existing and future goals for reuse activities.
* Maturity model can be used in planning systematic reuse. Organizations developing and maintaining.
* In this section we discuss briefly three maturity models:
  * Reuse Maturity Model
  * Reuse Capability Model
  * RiSE Maturity Model

# Reuse Maturity Model

* In circa 1991, Koltun and Hudson presented the first reuse maturity model (RMM).
* The model provides a concise form of obtaining information on reuse practices in organizations.
* The model comprises five levels and ten dimensions of reuse maturity
* Maturity improves on a scale from 1 to 5, where level 1 corresponds to Initial/ Chaotic state and level 5 corresponds to the Ingrained state.
* This model was not applied in real case studies, but are considered as the key insights for the reuse capability model developed by Ted Davis

# Reuse Maturity Model

\centering
\includegraphics[width=.575\textwidth]{images/reuse/table9.1.eps}

# Reuse Capability Model

* RCM comprises two models, namely
  * an assessment model
  * an implementation model
* An organization can use the assessment model to:
  * understand its current capability to reuse artifacts
  * discover opportunities to improve its reuse capability
* A set of critical success factors are at the core of the assessment model.
* The success factors are described as goals that an organization uses to evaluate the present state of their reuse practice.
* The organization can apply the implementation model in prioritizing the critical factor goals by grouping them into stages.

# Assessment Model

* The success factors in the assessment model are grouped into four categories: **application development**, **asset development**, **management**, and **process and technology**

\centering
\includegraphics[width=.75\textwidth]{images/reuse/table9.2.eps}

# Assessment Model

* Each critical success factor is defined in terms of one or more goals.
* The goals describe what is to be achieved – and not how those goals can be realized.
* Therefore, there is much flexibility in achieving those goals.
* As an example, the needs identification factor has the following goals:
  * Identify the current needs for solutions of the developer.
  * Identify the anticipated needs for solutions of the developer.
  * Identify the current needs for solutions of the customer.
  * Identify the anticipated needs for solutions of the customer.
  * Use the identified needs as a reference to develop or acquire reusable assets to meet the specified needs.

# Implementation Model

* The goals are divided into four stages:
  - Opportunistic
  - Integrated
  - Leveraged
  - Anticipating

# Opportunistic

* A common reuse strategy does not fit all projects so each project develops its own strategy to reuse artifacts.
* The strategy includes:
  1. defining reuse activities in the project plan.
  2. using tools to support the reuse activities.
  3. identifying the needs of the developers and developing or acquiring reusable artifacts.
  4. identifying reusable artifacts throughout the lifecycle of the project.

# Implementation Model

**Integrated**

* The organization defines a reuse process and integrates it with its development process.
* It is important for the organization to support the reuse process by means of policies, procedures, resource allocation, and organizational structure.

**Leveraged**

* To extract the maximum benefits from reuse in groups of related products, a strategy for reuse in product lines is developed.

**Anticipating**

* Reusable assets are acquired or developed based on anticipated customer needs.

# RiSE Maturity Model

* The RiSE maturity model was developed during the RiSE project through discussions with industry partners.
* The RiSE maturity model includes:
  1. reuse practices grouped by perspectives and in organized levels representing different degrees of software reuse achieved.
  2. reuse elements describing fundamental parts of reuse technology, such as assets, documentation, tools and environments.
* The five maturity levels are as follows:
  - Level 1: Ad-hoc reuse.
  - Level 2: Basic Reuse.
  - Level 3: Initial Reuse.
  - Level 4: Integrated Reuse.
  - Level 5: Systematic Reuse.

# RiSE Maturity Model

* In the RiSE Maturity Model, fifteen factors were considered, and those are divided into four perspectives: **organizational**, **business**, **technological**, and **processes**.

\centering
\includegraphics[width=.65\textwidth]{images/reuse/table9.3.eps}

# RiSE Maturity Model

\centering
\includegraphics[width=.7\textwidth]{images/reuse/table9.4.eps}

\centering
\includegraphics[width=.7\textwidth]{images/reuse/table9.5.eps}

# RiSE Maturity Model

\centering
\includegraphics[width=.85\textwidth]{images/reuse/table9.6.eps}

# Economic Models of Software Reuse

* Project managers and financial managers can use the general economics model of software reuse in their planning for investments in software reuse.
* The project manager needs to estimate the costs and potential payoffs to justify systematic reuse.
* Increased productivity is an example of payoff of reuse.
* We will discuss:
  - \color{Roarange}\textbf{cost model}\color{Black}\ of Gaffney and Durek,
  - \color{Roarange}\textbf{application system cost model}\color{Black}\ of Gaffney and Cruickshank
  - \color{Roarange}\textbf{business model}\color{Black}\ of Poulin and Caruso.

# Gaffney & Durek Cost Model

* Two cost and productivity models proposed by Gaffney and Durek for software reuse are:
  * first order reuse cost model.
  * higher order cost model.
* The cost of reusing software components has been modeled in the first order reuse cost model.
* Whereas the higher order cost model considers the cost of developing reusable assets.

# First Order Reuse Cost Model

\footnotesize
* In this model, we assume the following conditions:
  * \scriptsize The reused software satisfies the black-box requirements in the sense that it is stable and reliable.
  * \scriptsize Users of the reusable components have adequate expertise in the context of reuse.
  * \scriptsize There is adequate documentation of the components to be reused.
  * \scriptsize The cost of reusing the components is negligible.
* Three broad categories of program code are used in a project:
  * \scriptsize $S_n$: It represents the new code added to the system.
  * \scriptsize $S_o$: It represents the original source code from the pre-existing system. So includes both lifted code and modified code. Lifted code means unchanged, original code taken from past releases of a product. The source code from modified (partial) parts are not considered as reused code.
  * \scriptsize $S_r$: It represents the reuse source code that are not developed or maintained by the organization. The reuse code is obtained from completely unmodified components normally located in a reuse library.

# First Order Reuse Cost Model

* The effective size, denoted by $S_e$, is an adjusted combination of the modified source code and the new source code, as given in the following equation:

  $S_e = S_n + S_o ( A_d \times F_d + A_i \times F_i + A_t \times F_t )$

  - where:
    - $A_d =$ is a normalized measure of design activity,
    - $A_i =$ is a normalized measure of integration activity,
    - $A_t =$ is a normalized measure of testing activity, and
    - $A_d + A_i + A_t = 1$

* Letting $S_r$ denote the estimated size of reusable components, the relative sizes of reusable components is given by $R$, where $R$ is expressed as follows:

  $R = S_r / (S_e + S_r)$

# First Order Reuse Cost Model

* Let C be the cost of software development for a given product relative to that for all new code (for which $C = 1$).
* Let R be the proportion of reused code in the product as defined earlier $(R \leq 1)$.
* Let b be the cost, relative to that for all new code, of incorporating the reused code into the new product.  Note that $b = 1$ for all new code.
* The relative cost for software development is:

  $[(relative\, cost\, of\, all\, new\, code) * (proportion\, of\, new\, code)] + [(relative\, cost\, of\, reused\, software) * (proportion\, of\, reused\, software)]$

* Therefore:
  - $C = (1)(1 − R) + (b) (R) = (b − 1)R + 1$
  - the associated relative productivity is:  $P = 1 / C = 1 / (b − 1)R + 1$
  - $b$ must be $< 1$ for reuse to be cost effective.

# First Order Reuse Cost Model

\centering
\includegraphics[width=.4\textwidth]{images/reuse/table9.7.eps}

* If we want to reuse a requirements component, the relative cost to reuse requirements is $b = (0.37 + 0.22 + 0.33) = 0.92$
* If code is reused, then the additional tasks will involve requirements and testing, the relative cost to reuse code is $b = (0.08 + 0.33) = 0.41$

# Higher Order Reuse Cost Model

\footnotesize

* Estimating the cost of developing reusable components is key to formulating a reuse cost model.
* By combining the development cost of the reusable components into the economic model, we have:

$$ C = (1 - R) \times 1 + \left(b + \frac{a}{n}\right) R $$

  - where:
    - \scriptsize $a$ is the cost of developing reusable components relative to the cost of building new non-reusable components from the scratch
    - \scriptsize $n$ is the number of uses over which the cost of reusable components is amortized

* Now, the model can be rewritten as:

$$ C = \left(b + \frac{a}{n} - 1\right) R + 1 $$

# Application System Cost Model

* An application system cost model based on domain engineering and application engineering was proposed by Gaffney and Cruickshank.
* The cost of an application system is expressed as the sum of two component costs:
  * the investment in domain engineering apportioned over $N$ application systems.
  * the cost of application engineering to develop a specific system.
* Therefore, the cost of an application system, $C_s$ is equal to the prorated cost of domain engineering plus the cost of application engineering.
* Let the cost of application engineering be the cost of the new code plus the cost of the reused code in the new application system, and let R denote the fraction of code that is reused code.

# Application System Cost Model

* Now, we have
  - $Cs = C_{dp} + C_a$
  - $\rightarrow Cs = Cd / N + Cn + Cr$

* Where:
  - $C_{dp} = C_d/N$
  - $C_a = C_n + C_r$
  - $C_s =$ the total cost of the application system
  - $C_d =$ the total cost of domain engineering
  - $C_{dp} =$ the prorated portion of $C_d$ shared by each of the $N$ application systems
  - $C_a =$ the cost of an application system
  - $C_n =$ the cost of the new code in the application system
  - $C_r =$ the cost of the reused code in the application system

# Application System Cost Model

\centering
\includegraphics[width=.85\textwidth]{images/reuse/slide45.eps}

# Application System Cost Model

\centering
\includegraphics[width=.85\textwidth]{images/reuse/slide46.eps}

# Business Model

* Poulin and Caruso developed a model at IBM to improve measurement and reporting software reuse. Their results are based on a set of data points as follows:
* **Shipped source instruction (SSI):** SSI is the total count of executable code lines in the source files of a product.
* **Changed source instruction (CSI):** CSI is the total count of executable code lines that are new, added, or modified in a new release of a product.
* **Reused source instruction (RSI):** RSI is the total source instructions shipped but not developed or maintained by the reporting organization.
* **Source instruction reused by others (SIRBO):** SIRBO is the total lines of source instructions of an organization reused by others. It is calculated as follows:
  * **SIRBO** = (Source instructions per part) $\times$ (The number of organizations using the part)

# Buisness Model

* **Software development cost (Cost per LOC):** This metric concerns the development of new software, and it is calculated in two steps:
  * Let $S$ denote the total cost of the organization, including overhead; and  divide S by the total outputs of the organization in number of lines of code (LOC).
* **Software development error rate (Error rate):** It is a historical average number of errors uncovered in the products. To estimate the cost of avoiding maintenance, a historical average value is used.
* **Cost per error:** To quantify the advantage of better quality reusable assets, the historical mean cost of maintaining components with traditional development methods is used as a base line. Now, the cost per error metric is calculated in two steps:
  - let $S$ denote the sum of all costs; and divide S by the number of errors repaired.

# Business Model

* The discussed metrics are combined to form three derived metrics:
  - reuse percent
  - reuse cost avoidance
  - reuse value added

# Reuse Percent

Reuse percent of a product $= \frac{RSI}{RSI + SSI} \times 100\%$

\vskip1.5em

Ruse percent of a product release $= \frac{RSI}{RSI + CSI} \times 100\%$

# Reuse Cost Avoidance

\scriptsize

* The purpose of this metric is to measure reduced total product costs as a result of reuse.
* One must retrieve and evaluate the reusable assets to choose the appropriate ones to be integrated into the system being developed.
* For example, the cost of integrating a reusable software element is 20% of the cost of developing the same element anew.
* The financial benefit due to adopting reuse in the development phase of a project is calculated as follows:

$$Development\, cost\, avoidance = RSI \times (1 - 0.2) \times (new\, code\, cost)$$

* In addition, saving in maintenance cost attributed to reuse is much more than those during software development, because of the fewer defects in reused components.  The saving is:

$$Service\, cost\, avoidance = RSI \times (error\, rate) \times (cost\, per\, error)$$

* The total reuse cost avoidance is calculated as the sum of cost avoidance in the development and maintenance activites, which is:

$$Reuse\, cost\, avoidance = Development\, cost\, avoidance + Service\, cost\, avoidance$$

# Reuse Value Added

* The main idea behind $RVA$ is to provide a metric to reward an organization that reuses software components and helps other organizations by developing reusable components.
* Reuse value added is derived from $SSI$, $RSI$, and $SIRBO$:

$$Reuse value added = \frac{(SSI + RSI) + SIRBO}{SSI}$$

* Organizations with no involvement in reuse have an $RVA = 1$.
* An $RVA = 2$ indicates the organization is twice as effective as it would be without reuse.

# For Next Time

::: columns
:::: {.column width=.6}
* Review EVO Chapter 9.3 - 9.6
* Read SA Chapter 1
* Watch Lecture 25
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
