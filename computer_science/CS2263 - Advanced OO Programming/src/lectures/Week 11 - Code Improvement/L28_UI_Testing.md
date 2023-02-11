---
author:
- Isaac Griffith
title: GUI Testing
institute: |
  CS 2263

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

# TestFX

# Gradle

* You will need to configure Gradle to include TestFX

```groovy
dependencies {
  ...
  testImplementation 'org.testfx:testfx-junit:4.0+'
}
```

# A Basic GUI - Hello World

* First we will create a simple app to test

::: columns
:::: column

```java
// Import dependencies
public class Main extends Application {
  private final HelloWord helloWorld = new HelloWorld();
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(helloWorld.getScene());
    primaryStage.show();
  }
}
```

::::
:::: column

* This creates the Stag and loads the HelloWorld scene
  * Since this is boilerplate, we won't be testing it
  * Rather, we will test the application code

::::
:::

# The Application Code

::: columns
:::: column

```java
// Import dependencies
public class HelloWorld {
   private final SCENE_WIDTH = 500;
   private final SCENE_HEIGHT = 500;
   private final Scene scene;
   private final StackPane rootNode = new StackPane();
   private final Button button = new Button("Hello World");
   public HelloWorld() {
     rootNode.getChildren().add(button);
     scene = new Scene(rootNode, SCENE_WIDTH, SCENE_HEIGHT);
   }
   public Scene getScene() {
     return scene;
   }
}
```

::::
:::: column

* This code simply appends a button to the stage
* The button has the text "Hello World"
  * This is what we will be testing

::::
:::

#

\titleslide{.4\textwidth}{GUI Testing Basics}
