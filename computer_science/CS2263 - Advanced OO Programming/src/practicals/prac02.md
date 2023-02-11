---
course: CSCI 2263
title: "HW 02 - "
assigned: ""
due: " @ 23:00h"
...

# Assignment {-}

JavaScript

You will tweak the client of the Lights Out game. Follow the instructions for the client part (Homework 2) on the README for the Lights Out starter kit.

Submit the assignment via Gradescope (Assignment 2 · Lights Out · Part 1 · JavaScript · Client). Submit only lights-out.js. There’s no autograder this time, because you’re free to do whathever you want to signal that the game is over. Again, having code that works isn’t enough. Follow the software engineering principles you’re learning in class, and match the style of the code you’re modifying. Pay attention to details like tabs vs. spaces and naming conventions.
Git

You’re working on two features for your group project: a shopping cart and a picture upload form. Because these features are independent of one another, you’re developing them in different branches. Unfortunately, you forgot to checkout the correct branch and added two commits to the picture branch that belonged to the cart branch. Worse, you already pushed everything to GitHub and your teammates may have already pulled the mistake. The following figure illustrates the repository before the mistake and after it:

Repositories before and after the mistake

Submit the answers to the following questions to Gradescope in a single PDF (Assignment 2 · Part 2 · Git).
Question 1

How do you fix the mistake without disrupting your teammates that are working on the cart and picture branches with you? Use Git commands to manipulate the graph—don’t edit the files in the working directory directly. When you’re done, changes related to the shopping cart shouldn’t be visible in the working directory when the picture branch is checked out.

Part 1: Draw diagrams similar to the ones above showing the repository after each operation (for example, checkout, commit, create branch, delete branch, reset, rebase, merge, revert, cherry-pick, and so forth). Omit unreachable commits, but include branches and HEAD. If you’re working with paper and pencil, don’t redraw the repository over and over—just take pictures of the intermediary steps and edit in place.

Part 2: The repository at https://github.com/jhu-oose/assignment-2 is in the AFTER state (see the graph). Execute the strategy you devised in Part 1 and show us each step. If you use a GUI, provide a series of screenshots; if you use the CLI, provide a transcript of your terminal session.
Question 2

You finished working on the picture branch, but before you present it for review to your teammates and group advisor in a pull request, you want to rewrite the history to make it look like the mistake never happened (the rest of the history remains intact). How do you do it? Start by creating temporary safety branches and delete them in the end.

Again, go through Parts 1 and 2, drawing a strategy on paper and executing it on the repository that resulted from Question 1.
Question 3

You forgot to follow the instruction that said you should start by creating a temporary safety branch, and you ran the wrong command while executing your strategy to fix the repository. Now the code for the shopping cart ended up in an unreachable commit—not even the working directory includes it. But you realize the problem right away; how do you recover?

# Submission {-}
