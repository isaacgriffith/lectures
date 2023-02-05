---
author:
- Dr. Isaac Griffith
title: Logical \LaTeX
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Basic Operators

::: columns
;::: {.column width=.25}

**Function Operators**

* $\geq$ - `\geq`
* $\leq$ - `\leq`
* $\neq$ - `\neq`
* $=$ - `=`
* $<$ - `<`
* $>$ - `>`
* $\equiv$ - `\equiv`
* $\circ$ - `\circ`

::::
:::: {.column width=.25}

**Logic Operators**

* $\land$ - `\land`
* $\lor$ - `\lor`
* $\oplus$ - `\oplus`
* $\lnot$ - `\lnot`
* $\to$ - `\to`
* $\leftrigharrow$ - `\leftrightarrow`
* $\vdash$ - `\vdash`
* $\vDash$ - `\vDash`
* $\top$ - `\top`
* $\bot$ - `\bot`
* $\exists$ - `\exists`
* $\forall$ - `\forall`

::::
:::: {.column width=.25}

**Set Theory Operators**

* $\cup$ - `\cup`
* $\cap$ - `\cap`
* $\times$ - `\times`
* $\subset$ - `\subset`
* $\subseteq$ - `\subseteq`
* $\setminus$ - `\setminus`
* $\in$ - `\in`
* $\notin$ - `\notin`
* $\varnothing$ - `\varnothing`

::::
:::: {.column width=.25}

**Big Operators**

* $\bigvee$ - `\bigvee`
* $\bigwedge$ - `\bigwedge`
* $\bigcap$ - `\bigcap`
* $\bigcup$ - `\bigcap`
* $\sum$ - `\sum`
* $\prod$ - `\prod`

**Relations Operators**

* $\sqsubset$ - `\sqsubset`
* $\sqsubseteq$ - `\sqsubseteq`
* $\nsqsubset$ - `\nsqsubset`
* $\nsqsubseteq$ - `\nsqsubseteq`

::::
:::

# Creating Proof Trees

* You need to include the following packages:

  ```latex
  \usepackage{bussproofs}
  \usepackage{cancel}
  ```

* We then create the proof tree structure using the following commands
  * `\AxiomC{value}` - Create an assumption or axiom for which there is nothing before it.
  * `\UnaryInfC{value}` - Creates an inference for a single (last defined) result.
  * `\BinaryInfC{value}` - Creates an inference for the prior two results.
  * `\TrinaryInfC{value}` - Creates an inference for the prior three results.
  * `\QuinaryInfC{value}` - Creates an inference for the prior four results.
  * `\RightLabel{value}` - Creates a label (on the right) of the line for an inference

# Creating Proof Trees

::: columns
:::: column

**\LaTeX Code**

```latex
\begin{prooftree}
\AxiomC{$\left(P \land Q) \lor (P \land R)\right)$}
\AxiomC{$\cancel{P \land Q}$}
  \RightLabel{\scriptsize $\{\land E_L\}$}
  \UnaryInfC{$P$}
\AxiomC{$\cancel{P \land R}$}
  \RightLabel{\scriptsize $\{\land E_L\}$}
  \UnaryInfC{$P$}
\RightLabel{\scriptsize $\{\lor E\}$}
\TrinaryInfC{$P$}
\end{prooftree}
```

::::
:::: column

**Results**

\footnotesize

\begin{prooftree}
\AxiomC{$\left(P \land Q) \lor (P \land R)\right)$}
\AxiomC{$\cancel{P \land Q}$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$P$}
\AxiomC{$\cancel{P \land R}$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$P$}
\RightLabel{\tiny $\{\lor E\}$}
\TrinaryInfC{$P$}
\end{prooftree}

::::
:::
