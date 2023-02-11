\chapter{PGCL Definitions}\label{app:pgcl}

\section{(Object) Adapter}
\begin{lstlisting}[language=pgcl]
pattern "(Object)Adapter" {
    cue "default", {
        role "ConcreteAdapater::Request()", content: '''\
            [Ade].[SpecificRequest()];
        '''
    }
}
\end{lstlisting}

\section{Bridge}
\begin{lstlisting}[language=pgcl]
pattern "Bridge" {
    cue "default", {
        role "Abstraction::Operation()", content: '''\
            [Imp].[OperationImp]();
        '''
    }
}
\end{lstlisting}

\section{Chain of Responsibility}
\begin{lstlisting}[language=pgcl]
pattern "Chain of Responsibility" {
    cue "default", {
        role "ConcreteHandler::HandleRequest()", content: '''\
            if ([succ] != null)
                [succ].[HandleRequest]();
        '''
    }
}
\end{lstlisting}

\section{Command}
\begin{lstlisting}[language=pgcl]
pattern "Command" {
    cue "default", {
        role "ConcreteCommand::Execute()", content: '''\
            [Rcvr].[Action]();
        '''
    }
}
\end{lstlisting}

\section{Composite}
\begin{lstlisting}[language=pgcl]
pattern "Composite" {
    cue "default", {
        role "ConcreteComposite::Operation()", content: '''\
            for ([AbstractComponent] c : [Child])
                c.[Operation]();
        '''
    }
}
\end{lstlisting}

\section{Decorator}
\begin{lstlisting}[language=pgcl]
pattern "Decorator" {
    cue "default", {
        role "AbstractDecorator::Operation()", content: '''\
            [Component].[Operation]();
        '''
        role "ConcreteDecoratorB::Operation()", content: '''\
            super.[Operation]();
            [AddedBehavior]();
        '''
    }
}
\end{lstlisting}

\section{Factory Method}
\begin{lstlisting}[language=pgcl]
pattern "Factory Method" {
    cue "default", {
        role "AbstractCreator::AnOperation()", content: '''\
            [Product] product = [FactoryMethod()];
        '''

        role "ConcreteCreator::FactoryMethod()::Product", content: '''\
            return new [ConcreteProduct]();
        '''
    }
}
\end{lstlisting}

\section{Observer}
\begin{lstlisting}[language=pgcl]
pattern "Observer" {
    cue "default", {
        role "AbstractSubject::Notify()", content: '''\
            for ([Observer] o : [Obs])
                o.[Update()]
        '''

        role "ConcreteSubject::GetState()", content: '''\
            return [SubjectState];
        '''

        role "ConcreteObserver::Update()", content: '''\
            [ObserverState] = [Sub].[GetState()];
        '''
    }
}
\end{lstlisting}

\section{Prototype}
\begin{lstlisting}[language=pgcl]
pattern "Prototype" {
    cue "default", {
        role "Client::Operation()", content: '''\
            p = [Proto].[Clone()];
        '''
    }
}
\end{lstlisting}

\section{Proxy}
\begin{lstlisting}[language=pgcl]
pattern "Proxy" {
    cue "default", {
        role "Proxy::Request()", content: '''\
            [Sub].[Request()];
        '''
    }
}

\end{lstlisting}

\section{Singleton}
\begin{lstlisting}[language=pgcl]
pattern "Singleton", {
  cue "eagerInit", {
    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
	private [InstName]() {
	}'''

    role "ConcreteSingleton::Instance", definition: '''\
	private static final [TypeName] instance = new [TypeName]();'''

    role "ConcreteSingleton::GetInstance()", content: "return instance;"
  }

  cue "billPugh", {
    role "ConcreteSingleton", event: "MethodsComplete", content: '''\
        private static class [InstName]Holder {
	        private static final [InstName] INSTANCE = new [InstName]();
        }'''

    role "ConcreteSingleton::GetInstance()", content: "return [TypeName]Holder.INSTANCE;"

    role "ConcreteSingleton::Instance", disregard: true
  }

  cue "staticBlock", {
    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
	private [InstName]() {}

	static {
	    try {
	        instance = new [InstName]();
	    } catch(Exception e) {
	        throw new RuntimeException("Exception occurred while creating Singleton");
	    }
	}'''

    role "ConcreteSingleton::GetInstance()", content: "return instance;"
  }

  cue "lazyInit", {
    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
	private [InstName](){}'''

    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
    private [InstName](){}'''

    role "ConcreteSingleton::GetInstance()", content: '''\
	if (instance == null) {
	    instance = new [TypeName]();
	}
	
	return instance;'''
  }

  cue "threadSafe", {
    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
	private [InstName]() {}'''

    role "ConcreteSingleton::GetInstance()", definition: '''\
	public static synchronized [TypeName] getInstance() {
	    if (instance == null) {
	        instance = new [TypeName]();
	    }
	
	    return instance;
	}'''
  }

  cue "doubleCheckLock", {
    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
	private [InstName]()</parameter_list> <block>{}</block></constructor>'''

    role "ConcreteSingleton::GetInstance()", content: '''\
	if (instance == null) {
	    synchronized ([TypeName].class) {
	        if (instance == null) {
	            instance = new [TypeName]();
	        }
	    }
	}
	
	return instance;'''
  }

  cue "enumSingleton", {
    role "ConcreteSingleton", definition: '''\
	public enum [InstName] {
	    INSTANCE;
	}'''

    role "ConcreteSingleton::GetInstance()", disregard: true

    role "ConcreteSingleton::Instance", disregard: true
  }
}
\end{lstlisting}

\section{State}
\begin{lstlisting}[language=pgcl]
pattern "State" {
    cue "default", {
        role "Context::Request()", content: '''\
            [State].[Handle()];
        '''
    }
}
\end{lstlisting}

\section{Strategy}
\begin{lstlisting}[language=pgcl]
pattern "Strategy" {
    cue "default", {

    }
}
\end{lstlisting}

\section{Template Method}
\begin{lstlisting}[language=pgcl]
pattern "Template Method" {
    cue "default", {

    }
}
\end{lstlisting}

\section{Visitor}
\begin{lstlisting}[language=pgcl]
pattern "Visitor" {
    cue "default", {
        role "ConcreteElement::Accept(Visitor)", definition: '''\
        public void [Accept]([Visitor] v) {
            v.[VisitConcreteElement](this);
        }
        '''
    }
}
\end{lstlisting}