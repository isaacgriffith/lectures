\chapter{Design Pattern RBML Specifications}\label{chap:apprbml}
The following subsections describe the structural and behavioral definitions for the GoF design patterns [28]. Each pattern’s structural specification is described using RBML Structural Pattern Specification (SPS) diagrams with associated metamodel-level constraints and constraint templates defined using the Object Constraint Language (OCL) . The behavioral specification is defined using RBML Interaction Pattern Specification (IPS) diagrams.

\section{Abstract Factory}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/abstract_factory-sps.eps}
\caption{Abstract Factory design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:absfact-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractFactory
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and
	self.isAbstract() = true)

context |AbstractProduct
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and
	self.isAbstract() = true)

context |ConcreteFactory
inv: self.isAbstract() = false

context |ConcreteProduct
inv: self.isAbstract() = false

context |FactoryGeneralization
inv: self.parent.evaluationType() =
	self.child.evaluationType()

context |ProductGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |FactoryRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |ProductRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |Fact
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Cln
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Clnt
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Prod
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/abstract_factory-ips.eps}
\caption{Abstract Factory design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:absfact-ips}
\end{figure}

\section{Object Adapter}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/adapter-sps.eps}
\caption{Object Adapter design pattern SPS\cite{izurieta_decay_2009}.}\label{fig:adapter-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractAdapter
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and
	self.isAbstract() = true)

context |ConcreteAdapter
inv: self.isAbstract() = false

context |SubjectGeneralization
inv: self.parent.evaluationType() =
		self.child.evaluationType() 

context |SubjectGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Adaptee
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |Adr
inv: self.lowerBound() = 0 and self.upperBound() = 1

context |Ade
inv: self.lowerBound() = 0 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Adapter::|Request()
pre: true
post: |Adaptee^|SpecificRequest()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/adapter-ips.eps}
\caption{Object Adapter design pattern IPS.}\label{fig:adapter-ips}
\end{figure}

\section{Bridge}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/bridge-sps.eps}
\caption{Bridge design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:bridge-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractAbstraction
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractImplementor
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteAbstraction
inv: self.isAbstract() = false

context |ConcreteImplementor
inv: self.isAbstract() = false

context |AbsRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |ImplRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |AbsGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |ImplGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Abs
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Imp
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Abstraction::|Operation()
pre: true
post: |ConcreteImplementor^|Operation()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/bridge-ips.eps}
\caption{Bridge design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:bridge-ips}
\end{figure}

\section{Builder}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/builder-sps.eps}
\caption{Builder design pattern SPS.}\label{fig:builder-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractBuilder
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true

context |ConcreteBuilder
inv: self.isAbstract = false

context |BuilderRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |BuilderGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Director
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Builder
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/builder-ips.eps}
\caption{Builder design pattern IPS.}\label{fig:builder-ips}
\end{figure}

\section{Chain of Responsibility}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/chain_of_responsibility-sps.eps}
\caption{Chain of Responsibility design pattern SPS.}\label{fig:chain-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractHandler
inv: self.isAbstract() = true

context |ConcreteHandler
inv: self.isAbstract() = false

context |HandlerGenralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |succ
inv: self.lowerBound() = 0 and self.upperBound() = *

context |prev
inv: self.lowerBound()= 1 and self.upperBound() = 1

context |Clnt
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Handle
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/chain_of_responsibility-ips.eps}
\caption{Chain of Responsibility design pattern IPS.}\label{fig:chain-ips}
\end{figure}

\section{Command}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/command-sps.eps}
\caption{Command design pattern SPS.}\label{fig:command-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractCommand
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteCommand
inv: self.isAbstract = false

context |Reciever
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |CommandRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and 
	self.supplier.isAbstract() = true))
	and self.client.oclIsTypeOf(Class)

context |CommandGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Inv
inv: self.upperBound() = * and self.lowerBound() = 1

context |Cmd
inv: self.upperBound() = * and self.lowerBound() = 1

context |Clnt
inv: self.upperBound() = 1 and self.lowerBound() = 1

context |Rcvr
inv: self.upperBound() = 1 and self.lowerBound() = 1

context |R
inv: self.upperBound() = 1 and self.lowerBound() = 1

context |C
inv: self.upperBound() = 1 and self.lowerBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |ConcreteCommand::|Execute()
pre: true
post: |Receiver^|HandleRequest()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/command-ips.eps}
\caption{Command design pattern IPS.}\label{fig:command-ips}
\end{figure}

\section{Composite}

\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/composite-sps.eps}
\caption{Composite design pattern SPS.}\label{fig:composite-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Leaf
inv: self.isAbstract() = false

context |AbstractComposite
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteComposite
inv: self.isAbstract() = false

context |CompGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType() 

context |CompRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |Clnt
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Comp
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Children
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Parent
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |ConcreteComposite::|Add(|c:|Component)
pre: true
post: self.|Children = 
	self.|Children@pre->including(|c)

context |ConcreteComposite::|Remove(|c:|Component)
pre: self.|Children->includes(|c)
post: self.|Children = 
	self.|Children@pre->excluding(|c)

context |ConcreteComposite::|GetChild(|i:Integer)
pre: self.|children->notEmpty() and 
	self.|Children->size() >= |i
post: return = self.|Children[|i]
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/composite-ips.eps}
\caption{Composite design pattern IPS.}\label{fig:composite-ips}
\end{figure}

\section{Decorator}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/decorator-sps.eps}
\caption{Decorator design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:decorator-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractComponent
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractDecorator
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteComponent
inv: self.isAbstract() = false

context |ConcreteDecorator
inv: self.isAbstract() = false

context |CompRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |DecoRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |CompGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |DecoGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |CompDecReal inv:
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |CompDecGen 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |AbsComp 
inv: self.lowerBound() = 1 and self.upperBound() = *

context |AbsDec
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |ConcreteDecorator::|Operation()
pre: true
post: self^|AddedBehavior() and
	|Component^|Operation()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/decorator-ips.eps}
\caption{Decorator design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:decorator-ips}
\end{figure}

\section{Facade}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/facade-sps.eps}
\caption{Facade design pattern SPS.}\label{fig:facade-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Facade
inv: self.isAbstract() = false

context |Fac
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Sys
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\section{Factory Method}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/factory_method-sps.eps}
\caption{Factory Method design pattern SPS.}\label{fig:factmeth-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractProduct
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractCreator
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteProduct
inv: self.isAbstract() = false

context |ConcreteCreator
inv: self.isAbstract() = false

context |ProductRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |ProductGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |CreatorRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |CreatorGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/composite-ips.eps}
\caption{Factory Method design pattern IPS.}\label{fig:factmeth-ips}
\end{figure}

\section{Flyweight}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/flyweight-sps.eps}
\caption{Flyweight design pattern SPS.}\label{fig:flyweight-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractFlyweight
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |UnsharedAbstractFlyweight
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |Client
inv: self.isAbstract() = false

context |ConcreteFlyweight
inv: self.isAbstract() = false

context |UnstructuredConcreteFlyweight
inv: self.isAbstract() = false

context |FlyweightRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |FlyweightGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/flyweight-ips.eps}
\caption{Flyweight design pattern IPS.}\label{fig:flyweight-ips}
\end{figure}

\section{Interpreter}
\begin{figure}[h]
\centering
\includegraphics[scale=.65]{rbml/interpreter-sps.eps}
\caption{Interpreter design pattern SPS.}\label{fig:interpreter-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractTerminalExpr
inv: self.oclIsTypeOf(Inteface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractNonterminalExpr
inv: self.oclIsTypeOf(Inteface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteTerminalExpr
inv: self.isAbstract() = false

context |ConcreteNonterminalExpr
inv: self.isAbstract() = false

context |ExpressionGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |ExpressionRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |Ctx
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Cln
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Clnt
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Comp
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\section{Iterator}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/iterator-sps.eps}
\caption{Iterator design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:iterator-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractAggregate
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractIterator
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteAggregate
inv: self.isAbstract() = false

context |ConcreteIterator
inv: self.isAbstract() = false

context |AggregateRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true) and
	self.client.oclIsTypeOf(Class)

context |IteratorRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true) and
	self.client.oclIsTypeOf(Class)

context |AggregateGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |IteratorGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Aggr
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Iter
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Agt
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Item
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Iterator::|First()
pre: self.|Aggr.|Itm->notEmpty()
post: self.|Index = self.|Aggr.|Itm
	->indexOf(self.|Aggr.|Itm->first())

context |Iterator::|Next()
pre: self.|Aggr.|Itm->notEmpty() and
	self.|Index < self.|Aggr.|Itm->size()
post: self.|Index = self.|Index@pre + 1

context |Iterator::|IsDone()
pre: true
post: return = (self.|Index >= 
	self.|Aggr.|Itm->size())

context |Iterator::|CurrentItem()
pre: not self.|IsDone()
post: return = self.|Aggr.|Itm[self.|Index]
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/iterator-ips.eps}
\caption{Iterator design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:iterator-ips}
\end{figure}

\section{Mediator}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/mediator-sps.eps}
\caption{Mediator design pattern SPS.}\label{fig:mediator-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractColleague
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteColleague 
inv: self.isAbstract() = false

context |AbstractMediator
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteMediator 
inv: self.isAbstract() = false

context |ColleagueRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |MediatorRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |ColleagueGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |MediatorGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Med 
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Col
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |CM
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |CC
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/mediator-ips.eps}
\caption{Mediator design pattern IPS.}\label{fig:mediator-ips}
\end{figure}

\section{Memento}
\begin{figure}[h]
\centering
\includegraphics[scale=.65]{rbml/memento-sps.eps}
\caption{Memento design pattern SPS.}\label{fig:memento-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Mem
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Care
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Originator::|SetMemento(|m:|Memento)
pre: true
post: return = self.|St

context |Memento::|GetState()
pre: true
post: return = self.|St

context |Memento::|SetState(|st:|MemoState)
pre: true
post: self.|St = |st
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/memento-ips.eps}
\caption{Memento design pattern IPS.}\label{fig:memento-ips}
\end{figure}

\section{Observer}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/observer-sps.eps}
\caption{Observer design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:observer-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractSubject
inv: self.oclIsTypeOf(Interface) or 	
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteSubject
inv: self.isAbstract() = false

context |ConcreteObserver
inv: self.isAbstract() = false

context |AbstractObserver
inv: self.oclIsTypeOf(Interface) or
 	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |SubjectRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
     (self.supplier.oclIsTypeOf(Class) and 	
     self.supplier.isAbstract() = true)) and
     self.client.oclIsTypeOf(Class)

context |SubjectGeneralization inv:
inv: self.parent.evaluationType() = 
	self.child.evalutionType()

context |ObserverRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
     (self.supplier.oclIsTypeOf(Class) and
     self.supplier.isAbstract() = true)) and
     self.client.oclIsTypeOf(Class)

context |ObserverGeneralization
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Sub
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Obs
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Subject::|Attach(|obsv:|ConcreteObserver)
pre: true
post: self.|Obs = self.|Obs@pre -> including(|obsv)

context |Subject::|Detach(|obsv:|ConcreteObserver)
pre: |ConcreteObserver -> includes(|obsv)
post: |ConcreteObserver@pre -> excluding(|obsv)

context |Subject::|GetState():|SubjStateType
pre: true
post: result = |SubjectState

context |Subject::|SetState(|newState:|SubStateType)
pre: true
post: |SubjectState = |newState

context |Observer::|Update(|subj:|ConcreteSubject)
pre: true
post: let observerMessage: OclMessage = 
	|ConcreteSubject^^|GetState() -> notEmpty() in
	observerMessage.hasReturned() and 
	message.result() = st
    |ObserverState = st
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/observer-ips.eps}
\caption{Observer design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:observer-ips}
\end{figure}

\section{Prototype}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/prototype-sps.eps}
\caption{Prototype design pattern SPS.}\label{fig:prototype-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractPrototype
inv: self.oclIsTypeOf(Interace) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcretePrototype
inv: self.isAbstract() = false

context |PrototypeGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |PrototypeRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |Clnt
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Proto
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Client::|Operation()
pre: true
post: |Prototye^|Clone()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/prototype-ips.eps}
\caption{Prototype design pattern IPS.}\label{fig:prototype-ips}
\end{figure}

\section{Proxy}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/proxy-sps.eps}
\caption{Proxy design pattern SPS.}\label{fig:proxy-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractRealSubject
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractProxy
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |RealSubject
inv: self.isAbstract() = false

context |Proxy
inv: self.isAbstract() = false

context |SubjectRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |SubjectGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Sub
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Prox
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Clnt
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Subj
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Proxy::|Request()
pre: true
post: self.|Sub^|Request()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/proxy-ips.eps}
\caption{Proxy design pattern IPS.}\label{fig:proxy-ips}
\end{figure}

\section{Singleton}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/singleton-sps.eps}
\caption{Singleton design pattern SPS\cite{izurieta_decay_2009}.}\label{fig:singleton-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractSingleton
inv: self.oclIsTypeOf(Interace) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteSingleton
inv: self.isAbstract() = false

context |SingletonGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |SingletonRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |Sing
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Cln
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/singleton-ips.eps}
\caption{Singleton design pattern IPS.}\label{fig:singleton-ips}
\end{figure}

\section{State}
\begin{figure}[h]
\centering
\includegraphics[scale=.5]{rbml/state-sps.eps}
\caption{State design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:state-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Context
inv: self.isAbstract() = false

context |AbstractState
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |StateRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true)) and
	self.client.oclIsTypeOf(Class)

context |StateGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |Cont 
inv: self.lowerBound() = 1 and self.upperBound() = *

context |St
inv: self.lowerBound() = 1 and self.upperBound() = 1
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Context::|Request()
pre: true
post: |ConcreteState^|Handle()

\section{Strategy}
context |AbstractStrategy
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteStrategy
inv: self.isAbstract() = false

context |StrategyGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()

context |StrategyRealization
inv: (self.supplier.oclIsTypeOf(Interface) or
	(self.supplier.oclIsTypeOf(Class) and
	self.supplier.isAbstract() = true))
	and self.client.oclIsTypeOf(Class)

context |Ctx
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Struct
inv: self.lowerBound() = 1 and self.upperBound() = *

\subsection{Metamodel-Level Constraints}
context |Context::|Operation()
pre: true
post: |ConcreteStrategy^|StrategyOp()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/state-ips.eps}
\caption{State design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:state-ips}
\end{figure}

\section{Strategy}
\begin{figure}[h]
 \centering
 \includegraphics[scale=.75]{rbml/strategy-sps.eps}
 \caption{Strategy design pattern SPS.}\label{fig:strategy-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
 \begin{lstlisting}[language=OCL]
  
 \end{lstlisting}

\end{singlespace}

\subsection{Contraint Templates}
\begin{singlespace}
 \begin{lstlisting}[language=OCL]
  
 \end{lstlisting}

\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/strategy-ips.eps}
\caption{Strategy design pattern IPS.}\label{fig:strategy-ips}
\end{figure}


\section{Template Method}
\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/template-sps.eps}
\caption{Template design pattern SPS.}\label{fig:template-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractTemplate
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteTemplate
inv: self.isAbstract() = false

context |TemplateGeneralization 
inv: self.parent.evaluationType() = 
	self.child.evaluationType()
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |Template::|StrategyOp()
pre: true
post: |ConcreteStrategy^PrimitiveOp()
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/template_method-ips.eps}
\caption{Template design pattern IPS.}\label{fig:template-ips}
\end{figure}

\section{Visitor}
\begin{figure}[h]
\centering
\includegraphics[scale=.65]{rbml/visitor-sps.eps}
\caption{Visitor design pattern SPS\cite{kim_meta-modeling_2004}.}\label{fig:visitor-sps}
\end{figure}

\subsection{Metamodel-Level Constraints}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |AbstractVisitor
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |AbstractElement
inv: self.oclIsTypeOf(Interface) or
	(self.oclIsTypeOf(Class) and 
	self.isAbstract() = true)

context |ConcreteVisitor
inv: self.isAbstract() = false

context |ConcreteElement
inv: self.isAbstract() = false

context |Obj
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Elem
inv: self.lowerBound() = 1 and self.upperBound() = 1

context |Visit
inv: self.lowerBound() = 1 and self.upperBound() = *

context |Ele
inv: self.lowerBound() = 1 and self.upperBound() = *
\end{lstlisting}
\end{singlespace}

\subsection{Constraint Templates}%\cite{kim_meta-modeling_2004}}
\begin{singlespace}
\begin{lstlisting}[language=OCL]
context |ConcreteElement::|Accept(|v:|Visitor)
pre: not |v.oclIsTypeOf(OclVoid)
post: |v^|VisitElement(self)
\end{lstlisting}
\end{singlespace}

\begin{figure}[h]
\centering
\includegraphics[scale=.75]{rbml/visitor-ips.eps}
\caption{Visitor design pattern IPS\cite{kim_meta-modeling_2004}.}\label{fig:visitor-ips}
\end{figure}