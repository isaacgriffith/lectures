---
author:
- Dr. Isaac Griffith
title: Software Measurement
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\centering
\vfill
\begin{minipage}{.7\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Software Measurement
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Software measurement

* Software measurement is concerned with deriving a numeric value for an attribute of a software product or process.
* This allows for objective comparisons between techniques and processes.
* Although some companies have introduced measurement programs, most organizations still don’t make systematic use of software measurement.
* There are few established standards in this area.

# Software metric

* Any type of measurement which relates to a software system, process or related documentation
  - Lines of code in a program, the Fog index, number of person-days required to develop a component.
* Allow the software and the software process to be quantified.
* May be used to predict product attributes or to control the software process.
* Product metrics can be used for general predictions or to identify anomalous components.

# Types of process metric

* The time taken for a particular process to be completed
  - This can be the total time devoted to the process, calendar time, the time spent on the process by particular engineers, and so on.
* The resources required for a particular process
  - Resources might include total effort in person-days, travel costs or computer resources.
* The number of occurrences of a particular event
  - Examples of events that might be monitored include the number of defects discovered during code inspection, the number of requirements changes requested, the number of bug reports in a delivered system and the average number of lines of code modified in response to a requirements change.

# Predictor and control measurements

\begin{center}
\includegraphics[width=.75\textwidth]{images/quality/quality06.eps}
\end{center}

# Use of measurements

* To assign a value to system quality attributes
  - By measuring the characteristics of system components, such as their cyclomatic complexity, and then aggregating these measurements, you can assess system quality attributes, such as maintainability.
* To identify the system components whose quality is sub-standard
  - Measurements can identify individual components with characteristics that deviate from the norm. For example, you can measure components to discover those with the highest complexity. These are most likely to contain bugs because the complexity makes them harder to understand.  

# Metrics assumptions

* A software property can be measured accurately.
* The relationship exists between what we can measure and what we want to know. We can only measure internal attributes but are often more interested in external software attributes.
* This relationship has been formalized and validated.
* It may be difficult to relate what can be measured to desirable external quality attributes.

# Software attribute relationships

\begin{center}
\includegraphics[width=.70\textwidth]{images/quality/quality07.eps}
\end{center}

# Problems with measurement in industry

* It is impossible to quantify the return on investment of introducing an organizational metrics program.
* There are no standards for software metrics or standardized processes for measurement and analysis.
* In many companies, software processes are not standardized and are poorly defined and controlled.
* Most work on software measurement has focused on code-based metrics and plan-driven development processes. However, more and more software is now developed by configuring ERP systems or COTS.
* Introducing measurement adds additional overhead to processes.

# Empirical software engineering

* Software measurement and metrics are the basis of empirical software engineering.
* This is a research area in which experiments on software systems and the collection of data about real projects has been used to form and validate hypotheses about software engineering methods and techniques.
* Research on empirical software engineering, this has not had a significant impact on software engineering practice.
* It is difficult to relate generic research to a project that is different from the research study.

# Product metrics

* A quality metric should be a predictor of product quality.
* Classes of product metric
  - Dynamic metrics which are collected by measurements made of a program in execution;
  - Static metrics which are collected by measurements made of the system representations;
  - Dynamic metrics help assess efficiency and reliability
  - Static metrics help assess complexity, understandability and maintainability.

# Dynamic and static metrics

* Dynamic metrics are closely related to software quality attributes
  - It is relatively easy to measure the response time of a system (performance attribute) or the number of failures (reliability attribute).
* Static metrics have an indirect relationship with quality attributes
  - You need to try and derive a relationship between these metrics and properties such as complexity, understandability and maintainability.

# Static software metrics

* **Fan-in/Fan-out**:
  - Fan-in - a measure of the number of functions or methods that call another function or method (say X).
  - Fan-out - the number of functions that are called by function X.
  - A high value for fan-in means that X is tightly coupled to the rest of the design and changes to X will have extensive knock-on effects.
  - A high value for fan-out suggests that the overall complexity of X may be high because of the complexity of the control logic needed to coordinate the called components.

* **Length of code** - This is a measure of the size of a program.
  - Generally, the larger the size of the code of a component, the more complex and error-prone that component is likely to be.
  - Length of code has been shown to one of the most reliable metrics for predicting error-proneness in components.

# Static software metrics

* **Cyclomatic complexity** - This is a measure of t he control complexity of a program. This control complexity may be related to program understandability.
  - This metric is further discussed in Chapter 8.

* **Length of identifiers** - a measure of the average length of identifiers (names for variables, classes, methods, etc.) in a program
  - The longer the identifiers, the more likely they are to be meaningful and hence the more understandable the program.

* **Depth of conditional nesting** - This is a measure of the depth of nesting of if-statements in a program.
  - Deeply nested if-statements are hard to understand and potentially error-prone.

* **Fog index** - This is a measure of the average length of words and sentences in documents.
  - The higher the value of a document's Fog index, the more difficult the document is to understand.

# The CK object-oriented metrics suite

* **Weighted methods per class (WMC)** - This is the number of methods in each class, weighted by the complexity of each method. Therefore, a simple method may have a complexity of 1, and a large and complex method a much higher value.
  - The larger the value for this metric, the more complex the object class. Complex objects are more likely to be difficult to understand.
  - They may not be logically cohesive, so cannot be reused effectively as superclasses in an inheritance tree.

* **Depth of inheritance tree (DIT)** - This represents the number of discrete levels in the inheritance tree where subclasses inherit attributes and operations (methods) from superclasses.
  - The deeper the inheritance tree, the more complex the design.
  - Many object classes may have to be understood to undersand the object classes at the leaves of the tree.

# The CK object-oriented metrics suite

* **Number of children (NOC)** - This is a measure of the number of immediate subclasses in a class. It measures the breadth of a class hierarchy, whereas DIT measures its depth.
  - A high value for NOC may indicate greater reuse.
  - It may mean that more effort should be made in validating base classes because of the number of subclasses that depend on them.

* **Coupling between object classes (CBO)** - Classes are coupled when methods in one class use methods or instance variables in a different class. CBO is a measure of how much coupling exists.
  - A high value for CBO means that classes are highly dependent, and therefore it is more likely that changing one class will affect other classes in the program.

# The CK object-oriented metrics suite

* **Response for a class (RFC)** - RFC is a measure of the number of methods that could potentially be executed in response to a message received by an object of that class. Again, RFC is related to complexity.
  - The higher the value for RFC, the more complex a class and hence the more likely it is that it will include errors.

* **Lack of cohesion in methods (LCOM)** - LCOM is calculated by considering pairs of methods in a class. LCOM is the difference between the number of method pairs without shared attributes and the number of method pairs with shared attributes.
  - The value of this metric has been widely debated and it exists in several variations.
  - It is not clear if it really adds any additional, useful information over and above that provided by other metrics

# Software component analysis

* System component can be analyzed separately using a range of metrics.
* The values of these metrics may then compared for different components and, perhaps, with historical measurement data collected on previous projects.
* Anomalous measurements, which deviate significantly from the norm, may imply that there are problems with the quality of these components.

# The process of product measurement

\begin{center}
\includegraphics[width=.85\textwidth]{images/quality/quality08.eps}
\end{center}

# Measurement ambiguity

* When you collect quantitative data about software and software processes, you have to analyze that data to understand its meaning.
* It is easy to misinterpret data and to make inferences that are incorrect.
* You cannot simply look at the data on its own. You must also consider the context where the data is collected.

# Measurement surprises

* Reducing the number of faults in a program leads to an increased number of help desk calls
  - The program is now thought of as more reliable and so has a wider more diverse market. The percentage of users who call the help desk may have decreased but the total may increase;
  - A more reliable system is used in a different way from a system where users work around the faults. This leads to more help desk calls.

# Software context

* Processes and products that are being measured are not insulated from their environment.
* The business environment is constantly changing and it is impossible to avoid changes to work practice just because they may make comparisons of data invalid.
* Data about human activities cannot always be taken at face value. The reasons why a measured value changes are often ambiguous. These reasons must be investigated in detail before drawing conclusions from any measurements that have been made.

# Key points

* Software measurement can be used to gather quantitative data about software and the software process.
* You may be able to use the values of the software metrics that are collected to make inferences about product and process quality.
* Product quality metrics are particularly useful for highlighting anomalous components that may have quality problems. These components should then be analyzed in more detail.
* Software analytics is the automated analysis of large volumes of software product and process data to discover relationships that may provide insights for project managers and developers.
