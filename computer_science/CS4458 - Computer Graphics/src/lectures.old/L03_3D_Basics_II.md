---
author:
- Isaac Griffith
title: First Program II
institute: |
  CS 4458 and CS 5558

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
...

#

\vfill
\centering
\Huge 3D Basics II

# Outcomes

At the end of Today's Lecture you will be able to:

*

# Introduction

#

\vfill
\begin{center}
{\Huge OpenGL Gemoetric Primitives}
\end{center}

# OpenGL Primitives

* Primitives are used to form the most basic to the most complex objects in OpenGL

* So far we've seen the Polygon (`GL_POLYGON`) but there are several more:

  - `GL_POINTS` - draws a point at each vertex

  - `GL_LINES` - draws a disconnected set of straight line segments between vertices, taken two at a time.

  - `GL_LINE_STRIP` - draws the connected sequence of segments defined by:
    * $v_0v_1, v_1v_2, v_2v_3,\ldots,v_{n-2}v_{n-1}$
    * This is called a **polygonal line** or **polyline**

  - `GL_LINE_LOOP` - same as `GL_LINE_STRIP`, but includes additional segment $v_{n-1}v_0$

# OpenGL Primitives

* Primitives are used to form the most basic to the most complex objects in OpenGL

* So far we've seen the Polygon (`GL_POLYGON`) but there are several more:

  - `GL_TRIANGLES` -

  - `GL_TRIANGLE_STRIP` -

  - `GL_TRIANGLE_FAN` -

* **NOTE:** `GL_POLYGON` has been dropped from the core profile starting in OpenGL 4.0

# OpenGL Primitives

::: columns
:::: column
**Drawing Orientation**

* The order of vertices determines a polygon's orientation
* Orientation can be either CW or CCW (as seen by the user)
* Orientation is used by OpenGL to determine which face, front or back, the viewer sees

::::
:::: column
**Polygon Modes**

* `glPolygonMode(face, mode)` - sets the drawing mode

  - **face:** one of `GL_FRONT`, `GL_BACK`, or `GL_FRONT_AND_BACK`
  - **mode:** one of `GL_FILL`, `GL_LINE`, or `GL_POINT`

* Whether a polygon is front or back depends on its orientation

::::
:::

# OpenGL Primitives

* Point size for `GL_POINTS` can be set by calling `glPointSize(size)`
  - default value: 1.0

* Line width for `GL_LINE*` primitives and `GL_LINE` drawing mode is set by calling `glLineWidth(width)`
  - default value: 1.0

# Primitive Objects

::: columns
:::: column
**General Definition of Primitive Object**

```c
    glBegin(primitive_type);
      glVertex3f(*, *, *); // v0
      glVertex3f(*, *, *); // v1
      ...
      glVertex3f(*, *, *); // vn-1
    glEnd()

# Slide 6

# Slide 7

# Slide 8

#

\vfill
\begin{center}
{\Huge Activity 1}
\end{center}

#

\vfill
\begin{center}
{\Huge Approximating Curved Objects}
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
{\Huge Activity 2}
\end{center}

#

\vfill
\begin{center}
{\Huge 3D, The Depth Buffer, Perspective Projection}
\end{center}

# Slide 1

# Slide 2

# The Depth Buffer

# Slide 4

# Slide 5

# A Helix and Perspective Projection

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
{\Huge Approximating Curved Objects}
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
{\Huge An OpenGL Program End-to-End}
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

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time
