---
author:
- Isaac Griffith
title: OpenGL and 3D Graphics
institute: |
  CS 4458 and CS 5558

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
...

#

\vfill
\centering
\Huge OpenGL and 3D Graphics

# Outcomes

At the end of Today's Lecture you will be able to:

*

# Introduction

#

\vfill
\begin{center}
{\Huge First Program}
\end{center}

# Square.cpp

::: columns
:::: column
```c
glBegin(GL_POLYGON);
  glVertex3f(20.0, 20.0, 0.0);
  glVertex3f(80.0, 20.0, 0.0);
  glVertex3f(80.0, 80.0, 0.0);
  glVertex3f(20.0, 80.0, 0.0);
glEnd();
```
::::
:::: column

\graphic

::::
:::

# Coordinate Axes

How does `glVertex3f(x, y, z)` work?

\graphic

# What do we actually see?

* Given that `glVertex3f(...)` does provide a z-coordinate
* Thus vertices are specified in 3-space.
* OpenGL allows us to draw in 3-space

But,

* The generate picture is rendered in 2-Space on the screen

#

\vfill
\begin{center}
{\Huge Let's look at the code.}
\end{center}

#

\vfill
\begin{center}
{\Huge Orthographic Projection}
\end{center}

# Projection and Window Size

# `glOrtho` and the Viewing Box

* `glOrtho(l, r, b, t, n, f)` defines a viwing box and a set of boundaries on what can be displayed

::: columns
:::: column
**The Viewing Box:**

\includegraphics{}

::::
:::: column
**Where:**

* l = left boundary
* r = right boundary
* t = top boundary
* b = bottom boundary
* n = near boundary
* f = far boundary

::::
:::

# `glOrth` and the Viewing Box

* We normally set the view using `glOrtho` in our window resize callback

* **Note:** In OpenGL, near and far are flipped in sign

* The viewing box sits in 3D space (also called 3-space or World Space)

* World Space is where we create all our entries

# `glOrtho` Rendering Process

::: columns
:::: column
**`glOrtho` uses a two-step rendering process**

1. Shoot: Objects are projected perpendicularly onto the front face of the viewing box.
   - z = -near plane

2. Print: Viewing box front face is proportionally scaled to fit the rectangular OpenGL window.

::::
:::: column

\includegraphics{}

::::
:::

# `glOrtho` Rendering Process

* The size and location of rendering is dependent on the ratio of the original object's size to that of viewing box in the direction of the viewing face.



# Viewing Units

# Fixed World System

#

\vfill
\begin{center}
{\Huge Activity 2}
\end{center}

#

\vfill
\begin{center}
{\Huge OpenGL Window and Screen Coordinates}
\end{center}

# Slide 1

# Slide 2

# Slide 3

# Slide 4

# Slide 5

# Slide 6

# Slide 7

# Slide 8

#

\vfill
\begin{center}
{\Huge Activity 3}
\end{center}

#

\vfill
\begin{center}
{\Huge Clipping}
\end{center}

# Slide 1

# Slide 2

# Slide 3

# Slide 4

# Slide 5

# Slide 6

# Slide 7

# Slide 8

#

\vfill
\begin{center}
{\Huge Activity 4}
\end{center}

#

\vfill
\begin{center}
{\Huge Color, OpenGL State Maching, Interpolation}
\end{center}

# Color and Interpolation

* In OpenGL there are 3 Basic color functions:
  - `glColor3f(r, g, b)`
  - `glClearColor(r, g, b, a)`
  - `glClear(GL_COLOR_BUFFER_BIT)`

# Color and Interpolation

* In OpenGL there are 3 Basic color functions:
  - `glColor3f(r, g, b)` - Sets the current drawing/foreground color.
    * **r** - parameter which sets the intensity of the red channel of the color. Hard bounded to \[0, 1\]
    * **g** - parameter which sets the intensity of the green channel of the color. Hard bounded to \[0, 1\]
    * **b** - parameter which sets the intensity of the blue channel of the color. Hard bounded to \[0, 1\]     
  - `glClearColor(r, g, b, a)`
  - `glClear(GL_COLOR_BUFFER_BIT)`

# Color and Interpolation

* In OpenGL there are 3 Basic color functions:
  - `glColor3f(r, g, b)`
  - `glClearColor(r, g, b, a)` - Sets the background color.
     * **r,g,b** - same as for `glColor3f`
     * **a** - the intensity of the color's alpha (transparency) channel. Hard bounded to \[0, 1\]
  - `glClear(GL_COLOR_BUFFER_BIT)`

# Common Colors

+-------------------+--------------------+---------------------+
| RGB Triple        | Color Name         | Color               |
+:==================+:==================:+:===================:+
| 1.0, 0.0, 0.0     | Red                |                     |
+-------------------+--------------------+---------------------+
| 0.0, 1.0, 0.0     | Green              |                     |
+-------------------+--------------------+---------------------+
| 0.0, 0.0, 1.0     | Blue               |                     |
+-------------------+--------------------+---------------------+
| 1.0, 1.0, 0.0     | Yellow             |                     |
+-------------------+--------------------+---------------------+
| 1.0, 0.0, 1.0     | Magenta            |                     |
+-------------------+--------------------+---------------------+
| 0.0, 1.0, 1.0     | Cyan               |                     |
+-------------------+--------------------+---------------------+
| 1.0, 1.0, 1.0     | White              |                     |
+-------------------+--------------------+---------------------+
| 0.0, 0.0, 0.0     | Black              |                     |
+-------------------+--------------------+---------------------+

# Common Colors

* Reducing intensity equally for each color reduces the brightness of the produced color:

  - (1.0, 1.0, 0.0) - Bright Yellow

  - (0.5, 0.5, 0.0) - Less Bright Yellow

* Reducing the intensity of all channels equally for white produces a shade of gray

* Increasing the intensity of all channels equally for black produces a shade of gray

# Activity: Coding

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Chapter 2 sections 2.6 - 2.11
* Review Homework 1
* Get a program up and running on your system
* Come to Class!
