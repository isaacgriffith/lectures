---
title: Lab 01 -- 3G's
course: "CS 2263"
assigned: "January 17, 2019"
due: "January 17, 2019"
...

You’re working on two features for your group project: a shopping cart and a picture upload form. Because these features are independent of one another, you’re developing them in different branches. Unfortunately, you forgot to checkout the correct branch and added two commits to the picture branch that belonged to the cart branch. Worse, you already pushed everything to GitHub and your teammates may have already pulled the mistake. The following figure illustrates the repository before the mistake and after it:

\begin{center}
\includegraphics[width=.75\textwidth]{images/lab01/before_after.png}
\end{center}

\begin{enumerate}[label=\protect\circled{\arabic*}]
\item How do you fix the mistake without disrupting your teammates that are working on the cart and picture branches with you? Use Git commands to manipulate the graph--don’t edit the files in the working directory directly. When you’re done, changes related to the shopping cart shouldn't be visible in the working directory when the picture branch is checked out.

\vskip1em

\textbf{Part 1:} Draw diagrams similar to the ones above showing the repository after each operation (for example, checkout, commit, create branch, delete branch, reset, rebase, merge, revert, cherry-pick, and so forth). Omit unreachable commits, but include branches and HEAD. If you're working with paper and pencil, don’t redraw the repository over and over—just take pictures of the intermediary steps and edit in place.

\vskip1em

\textbf{Part 2:} The repository at https://github.com/grifisaa/lab01 is in the AFTER state (see the graph). Execute the strategy you devised in Part 1 and show your instructor your results.

\item You finished working on the picture branch, but before you present it for review to your teammates in a pull request, you want to rewrite the history to make it look like the mistake never happened (the rest of the history remains intact). How do you do it? Start by creating temporary safety branches and delete them in the end.
\vskip1em
Again, go through Parts 1 and 2, drawing a strategy on paper and executing it on the repository that resulted from Question 1.

\item You forgot to follow the instruction that said you should start by creating a temporary safety branch, and you ran the wrong command while executing your strategy to fix the repository. Now the code for the shopping cart ended up in an unreachable commit--not even the working directory includes it. But you realize the problem right away; how do you recover?
\end{enumerate}
