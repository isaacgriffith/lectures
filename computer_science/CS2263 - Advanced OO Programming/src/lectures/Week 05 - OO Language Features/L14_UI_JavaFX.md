---
author:
- Dr. Isaac Griffith
title: UI Basics and JavaFX
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Two Questions

::: columns
:::: column

\centering
\Large What makes a \textcolor{Roarange}{\textbf{good}} UI?

\includegraphics[width=\textwidth]{images/ui/good_ui2.png}

::::
:::: column

\centering
\Large What UI toolkits have **YOU** used?

\vskip1em

\includegraphics[width=.85\textwidth]{images/ui/toolkit.png}

::::
:::

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the basics of UI
* Understand how to use JavaFX to implement a UI
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge UI/UX Basics
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Key Terms

* \small \textcolor{Roarange}{\textbf{User Experience (UX)}} - all aspects of a user's interaction with a software application
  - \footnotesize Actions
  - \footnotesize Responses
  - \footnotesize Perceptions
  - \footnotesize Feelings

\vskip.5em

* \small \textcolor{Roarange}{\textbf{User Interface (UI)}} - Set of inputs and outputs that the user interacts with to invoke an application's functions

\vskip.5em

* \small \textcolor{Roarange}{\textbf{User-Centered Design}} - Design technique that embodies the view that the UI appears to be the entire system

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Usability}} - Degree to which a system is easy to learn and use

# User-Centered Design

* \small \textcolor{Roarange}{\textbf{Three Principles}}
  - \footnotesize Focus early on users and their work
  - \footnotesize Evaluate designs to ensure usability
  - \footnotesize Use iterative development

\vskip1em

* \small \textcolor{Roarange}{\textbf{Goal:}} high usability
  - \footnotesize System should be easy to learn and use
  - \footnotesize These two may be in conflict

# UI Design Considerations

* \small \textcolor{Roarange}{\textbf{Human Interface Objects}} - Objects that users can manipulate or navigate with
  - \footnotesize These should reflect the function they perform
  - \footnotesize \textcolor{Buttons}{\textit{Tooltips}} should be provided to assist the user
  - \footnotesize Should provide visual/audio feedback when activated

\vskip1em

* \small \textcolor{Roarange}{\textbf{Consistency}}
  - \footnotesize Be consistent when using icons
  - \footnotesize Icons uses are familiar with should not be used for new things
  - \footnotesize Maintain consistency with the underlying platform
  - \footnotesize Maintain consistency within your application/suite of applications

# UI Design Considerations

* \small \textcolor{Roarange}{\textbf{Discoverability}} - it should be easy for users to find and figure our operations and features in a UI
  - \footnotesize Make the UI "intuitive"
  - \footnotesize \textcolor{Roarange}{\textbf{Active Discovery}} - designer includes clues for the user to avoid trial and error
    * \scriptsize \textcolor{Buttons}{\textit{Tooltips}}
    * \scriptsize Mouse pointer changes
    * \scriptsize Hover changes action colors
    * \scriptsize Popups to discover functions

\vskip1em

* \small \textcolor{Roarange}{\textbf{Closure}} - Let a user know they completed an operation
  - \footnotesize Visual or audible feedback
  - \footnotesize Undo should be provided so users can "back up" if needed

# UI Design Considerations

* \small \textcolor{Roarange}{\textbf{Readability}}
  - \footnotesize Text must be readable by type, size, and color
  - \footnotesize The best systems allow users to change these properties
    * \scriptsize Try to prevent combinations which are difficult to read

\vskip.1em

* \small \textcolor{Roarange}{\textbf{Navigation}}
  - \footnotesize Should be obvious and easily traversed
  - \footnotesize Navigation reversal should be provided
    * \scriptsize \textcolor{Buttons}{\textit{Breadcrumbs}} are a common technique which shows hierarchy of screens traversed

\vskip.1em

* \small \textcolor{Roarange}{\textbf{Usability and Efficiency}}
  - \footnotesize Design for easy to use systems
  - \footnotesize Allow power users to have speed via shortcut keys for most functions
  - \footnotesize Provided clear error messages that both explain the error and how to fix it
  - \footnotesize Follow the KISS principle

#

\centering
\vfill
\begin{minipage}{.4\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge UI and JavaFX
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# JavaFX Overview

* \small \textcolor{Roarange}{\textbf{JavaFX}}
  - \footnotesize Newer UI toolkit for Java to replace the aging Swing toolkit
  - \footnotesize Provides many features above and beyond Swing, and it looks better
  - \footnotesize Can be used on various OS's and devices including
    * \scriptsize Windows
    * \scriptsize Linux
    * \scriptsize Mac
    * \scriptsize iOS
    * \scriptsize Android
    * \scriptsize Raspberry Pi
  - \footnotesize Has a component library consistent with modern UI toolkits
    * \scriptsize This lecture is mainly about setting up JavaFX, rather than going into detail, I leave that to you

# Using JavaFX with Gradle

* \small To use with gradle, you need to use the JavaFX plugin

  \footnotesize
  ```groovy
  plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.10'
  }
  ```

\vskip1em

* \small Next, add the required modules

  \footnotesize
  ```groovy
  javafx {
      version = "17"
      modules = [ 'javafx.controls' ]
  }
  ```

\vskip1em

* \small The version should correspond to your JDK version

# Setting the Stage

::: columns
:::: column
* \small In order to use JavaFX you need a class which extends
  \vskip.5em
  `javafx.application.Application`

\vskip1em

* \small Additionally, you will need to implement the method `start(Stage)`
  - \footnotesize Where the Stage is our window and is provided by JavaFX

\vskip1em

* \small Finally, you should have a `main(String[])` method which calls
  \vskip.5em
  `Application.launch()`

::::
:::: column

\textcolor{Roarange}{\textbf{Example}}

\scriptsize
```java
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("First JavaFX Application");

    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
```
::::
:::

# A Simple Scene

::: columns
:::: column

* \small JavaFX uses an idea called a scene graph to create a hierarchy of the components that will be displayed

\vskip.5em

* \small These can be UI components, 2D/3D graphics, etc.

\vskip.5em

* \small We then construct a scene and add this to the stage

::::
:::: column

\scriptsize
\vspace{-1em}

  ```java
  public void start(Stage stage) throws Exception {
    stage.setTitle("First JavaFX Application");

    Label label = new Label("Hello World, JavaFX!");
    Scene scene = new Scene(label, 400, 200);
    stage.setScene(scene);

    stage.show();
  }
  ```
::::
:::

# Event Handling

* \footnotesize To handle simple events (such as button clicks or menu selections)
  - \scriptsize we add an appropriate event handler

* \footnotesize There two primary ways to handle events
  - \scriptsize Using an anonymous inner class

    \scriptsize
    ```java
    button.setOnAction(new EventHandler() {
      public void handle(ActionEvent actionEvent) {
        // do something
      }
    })
    ```

  - \scriptsize Using a Lambda Expression

    \scriptsize
    ```java
    button.setOnAction(actionEvent -> {
      // do something
    })
    ```

# Event Handling Example

\vspace{-1.5em}
\scriptsize

::: columns
:::: column
```java
import javafx.application.Applicaton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scenelayout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ButtonActions extends Application {

  public void start(Stage stage) throws Exception {
    stage.setTitle("Button Experiment");

    Label label = new Label("Not Clicked!");
    Button button = new Button("Click");

    button.setOnAction(value -> {
      label.setText("Clicked!");
    });
```

::::
:::: column

```java
    VBox vbox = new VBox(button, label);

    Scene scene = new Scene(vbox, 200, 100);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.lauch(args);
  }
}










```
::::
:::

# Other Controls

* \small Controls are the components that provide some kind of control functionality within the application.
* \small To be visible they must be attached to the scene graph of some `Scene` object
* \small Controls tend to be nested within layout components which manage control layout relative to one another

\small \textcolor{Roarange}{\textbf{Available Controls:}}

::: columns
:::: {.column width=.1}
::::
:::: {.column width=.20}
  - \scriptsize Accordion
  - \scriptsize Button
  - \scriptsize CheckBox
  - \scriptsize ChoiceBox
  - \scriptsize ColorPicker
  - \scriptsize ComboBox
  - \scriptsize Label
::::
:::: {.column width=.20}
  - \scriptsize ListView
  - \scriptsize Menu
  - \scriptsize MenuBar
  - \scriptsize PasswordField
  - \scriptsize ProgressBar
  - \scriptsize RadioButton
  - \scriptsize Slider
::::
:::: {.column width=.20}
  - \scriptsize Spinner
  - \scriptsize SplitMenuButton
  - \scriptsize SplitPane
  - \scriptsize TableView
  - \scriptsize TabPane
  - \scriptsize TextArea
  - \scriptsize TextField
::::
:::: {.column width=.20}
  - \scriptsize TitledPane
  - \scriptsize ToggleButton
  - \scriptsize ToolBar
  - \scriptsize TreeTableView
  - \scriptsize TreeView
::::
:::: {.column width=.1}
::::
:::

# Layouts

* \small These are components which contain other components.
* \small They manager the layout of the contained components
* \small Must be attached to a scene graph of a `Scene` object to be visible

\small \textcolor{Roarange}{\textbf{Available Layouts:}}

::: columns
:::: {.column width=.1}
::::
:::: {.column width=.25}
- \scriptsize Group
- \scriptsize Region
- \scriptsize Pane
- \scriptsize HBox
::::
:::: {.column width=.25}
- \scriptsize VBox
- \scriptsize FlowPane
- \scriptsize BorderPane
- \scriptsize StackPane
::::
:::: {.column width=.25}
- \scriptsize TilePane
- \scriptsize GridPane
- \scriptsize AnchorPane
- \scriptsize TextFlow
::::
:::: {.column width=.15}
::::
:::

* \small To achieve a specific layout it is often necessary to nest layouts
  - \footnotesize For example to get horizontal rows which are not laid out in a grid but different for each row, you can nest multiple HBox layouts inside a VBox.

# Advanced Capabilities

* \small As you learn more about JavaFX, you will encounter several concepts, including
  * \footnotesize Properties and property bindings
  * \footnotesize FXML - an xml data-binding capability
    - \scriptsize This uses the MVC pattern (we will discuss much later)
    - \scriptsize Binds XML and CSS to classes thus allowing the design to be separate from the code
  * \footnotesize There are tools for creating FXML, including plugins for all IDEs

# For Next Time

::: columns
:::: column
* Review JavaFX Tutorial
* Review this Lecture
* Come to class
* Read the Course Project Overview

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
