---
title: Lab 04 -- Domain Modeling
course: "CS 2263"
assigned: "February 7, 2019"
due: "February 7, 2019"
...

[Settlers of Catan](http://www.ultracatan.com/game-rules.php) is a popular board game. Under the link above are the rules for the game.
\vskip1em
\noindent Guess, what, you missed a meeting of your team and they have decided to ditch the old iteration 1 idea and make a computer app version of this game instead. They have put you in charge of making a domain model (in the form of a UML class diagram) to understand the objects in the game and their relationships better. So, using the English description on the webpage above, make a UML class diagram of the underlying game structure.

\begin{enumerate}[label=\protect\circled{$\cdot$}]
\item We suggest you use the nouns/verbs technique to find classes (nouns) and methods (verbs).
\item You can assume the board has already been fixed at the beginner setup, the computer program will not need to put the pieces of the board together.
\item You don't need to try to understand and encode the rules in the diagram, only the different entities and how they relate.
\item Do include some actions the players will need to perform as methods -- they will be verbs in the description.
\item There are quite a few entities described, you can stop at ten classes. You also will need to include five methods; don't include obvious getter/setter type methods.
\item Make sure to include associations and use inheritance where it fits.
\item You need to have at least one inheritance relationship in your answer as there are several ones in the game structure. Remember, "(subclass) is-a (superclass)" (plug in potential sub and super) is a sentence that should make sense in subclass relationships.
\item See the design lecture notes on the UML class diagram features to use: classes, associations, multiplicity, inheritance, whole-part relationships, fields, and methods. You need not use any other UML widgets.
\end{enumerate}
