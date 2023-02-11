---
author:
- Isaac Griffith
title: Integration and Object Oriented Testing -- Part 2
institute: |
  SE 6630 - Software Testing, Maintenance, and Evolution

  Department of Software Engineering

  Idaho State University
fontsize: 12pt
cornerLogo: "../../../images/spirit.png"
wideLogo: "../../../images/wide.png"
lowerCornerLogo: "../../../images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}

* Understand the basic idea of integration testing and what it is for
* Understand the concepts of mutation testing applied to integration testing
* Understand and use the 4 basic types of mutation operators
* Understand and use the 5 basic integration mutation operators
* Start to understand the ideas of integration mutation applied to java and other OO languages

::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Inspiration

\vfill
\centering
> "Lots of methodologies have come and gone, paradigms have changed but the requirements are always the same; Make it good and make it fast." -- Anonymous

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Integration and OO Testing
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 6630}
\end{minipage}
\end{minipage}

# Inheritance Operators

\begin{block}{6. IOR -- Overridden Method Rename}
Renames the parent's versions of methods that are overridden in a subclass so that the overriding does not affect the parent's method
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.3\textwidth]{../../../images/part01/mutation/ior_ex.eps}
\end{center}
\end{example}

# Inheritance Operators

\begin{block}{7. ISI -- Super Keyword Insertion}
Inserts the super keyword before overriding variables or methods (if the name is also defined in an ancestor class)
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.2\textwidth]{../../../images/part01/mutation/isi_ex.eps}
\end{center}
\end{example}

# Inheritance Operators

\begin{block}{8. ISD -- Super Keyword Deletion}
Delete each occurrence of the super keyword
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.225\textwidth]{../../../images/part01/mutation/isd_ex.eps}
\end{center}
\end{example}

# Inheritance Operators

\begin{block}{IPC -- Explicit Parent Constructor Deletion}
Each call to a super constructor is deleted
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.3\textwidth]{../../../images/part01/mutation/ipc_ex.eps}
\end{center}
\end{example}

# Class Mutation Operators for Java

## (1) Encapsulation

AMC

## (2) Inheritance

IHI, IHD, IOD, IOP, IOR, ISI, ISD, IPC

## **(3) Polymorphism**

**PNC, PMD, PPD, PCI, PCD, PCC, PRV, OMR, OMD, OAC**

## (4) Java-Specific

JTI, JTD, JSI, JSD, JID, JDC

# Polymorphism Operators

\begin{block}{10. PNC -- new Method Call with Child Class Type}
The actual type of a new object is changed in the new() statement
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.35\textwidth]{../../../images/part01/mutation/pnc_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{11. PMD -- Member Variable Declaration with Parent Class Type}
The delcared type of each new object is changed in the declaration
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.35\textwidth]{../../../images/part01/mutation/pmd_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{12. PPD -- Parameter Variable Declaration with Child Class Type}
The declared type of each parameter object is changed in the declaration
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.4\textwidth]{../../../images/part01/mutation/ppd_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{PCI -- Type Cast Operator Insertion}
The actual type of an object reference is changed to the parent or to the child of the original declared type
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.375\textwidth]{../../../images/part01/mutation/pci_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{PCD -- Type Cast Operator Deletion}
Type casting operators are deleted
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.375\textwidth]{../../../images/part01/mutation/pcd_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{PPC -- Cast Type Changed}
Changes the type to which an object reference is being cast
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.45\textwidth]{../../../images/part01/mutation/ppc_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{PRV -- Reference Assignment with Other Compatible Type}
The right side objects of assignment statements are changed to refer to objects of a compatible type
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.45\textwidth]{../../../images/part01/mutation/prv_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{OMR -- Overloading Method Contents Replacement}
For each pair of methods that have the same name, the bodies are interchanged
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.3\textwidth]{../../../images/part01/mutation/omr_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{OMD -- Overloading Method Deletion}
Each overloaded method declaration is deleted, one at a time
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.3\textwidth]{../../../images/part01/mutation/omd_ex.eps}
\end{center}
\end{example}

# Polymorphism Operators

\begin{block}{OAC -- Arguments of Overloading Method Call Changed}
The order of the arguments in method invocations is changed to the same as that of another overloading method, if one exists
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.5\textwidth]{../../../images/part01/mutation/oac_ex.eps}
\end{center}
\end{example}

# Class Mutation Operators for Java

## (1) Encapsulation

AMC

## (2) Inheritance

IHI, IHD, IOD, IOP, IOR, ISI, ISD, IPC

## (3) Polymorphism

PNC, PMD, PPD, PCI, PCD, PCC, PRV, OMR, OMD, OAC

## **(4) Java-Specific**

**JTI, JTD, JSI, JSD, JID, JDC**

# Java-Specific Operators

\begin{block}{JTI -- this Keyword Insertion}
The keyword this is inserted whenever possible
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.25\textwidth]{../../../images/part01/mutation/jti_ex.eps}
\end{center}
\end{example}

# Java-Specific Operators

\begin{block}{JTD -- this Keyword Deletion}
The keyword this is deleted whenever possible
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.25\textwidth]{../../../images/part01/mutation/jtd_ex.eps}
\end{center}
\end{example}

# Java-Specific Operators

\begin{block}{JSI -- Static Modifier Insertion}
The static modifier is added to instance variables
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.25\textwidth]{../../../images/part01/mutation/jsi_ex.eps}
\end{center}
\end{example}

# Java-Specific Operators

\begin{block}{JSD -- Static Modifier Deletion}
Each instance of the static modifier is removed
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.25\textwidth]{../../../images/part01/mutation/jsd_ex.eps}
\end{center}
\end{example}

# Java-Specific Operators

\begin{block}{JID -- Member Variable Initialization Deletion}
Remove initialization of each member variable
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.20\textwidth]{../../../images/part01/mutation/jid_ex.eps}
\end{center}
\end{example}

# Java-Specific Operators

\begin{block}{JDC -- Java-supported Default Constructor Deletion}
Delete each declaration of default constructor (with no parameters)
\end{block}

\begin{example}
\begin{center}
\includegraphics[width=.20\textwidth]{../../../images/part01/mutation/jdc_ex.eps}
\end{center}
\end{example}

# Class Mutation Operators for Java

## (1) Encapsulation

AMC

## (2) Inheritance

IHI, IHD, IOD, IOP, IOR, ISI, ISD, IPC

## (3) Polymorphism

PNC, PMD, PPD, PCI, PCD, PCC, PRV, OMR, OMD, OAC

## (4) Java-Specific

JTI, JTD, JSI, JSD, JID, JDC

# Integration Mutation Summary

* Integration testing often looks at **couplings**
* We have not used **grammar testing** at the integration level
* Mutation testing modifies **callers** and **callees**
* **OO Mutation** focuses on inheritance, polymorphism, dynamic binding, information hiding and overloading
  - The access levels make it easy to make mistakes in OO software
* **muJava** is an educational & research tools for mutation of Java programs
  - [http://cs.gmu.edu/~offutt/mujava/](http://cs.gmu.edu/~offutt/mujava/)

# For Next Time

::: columns
:::: {.column width=.6}

::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
