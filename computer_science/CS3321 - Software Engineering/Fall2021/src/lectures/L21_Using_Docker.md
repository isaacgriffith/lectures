---
author:
- Isaac Griffith
title: Using Docker
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

Using Docker CLI

# Install Docker Engine

::: columns
:::: column

**Install Docker Engine**

* Docker Engine is available on a variety of **Linux platforms**, **macOS**, and **Windows 10** (through Docker Desktop)

::::
:::: column

Docker Engine Image

::::
:::

# Pull an Image

\begin{center}
There a re many publicly available images that we can use to work with Docker.

The example below pulls a hell-world image using the **docker pull** command
\end{center}

```bash
[ ~ ]docker pull hello-world
Using default tag: latest
latest: Pulling from library/hello-world
0e03bdcc26d7: Pull complete
Digest: sha256:31b9c7d48790f0d8c50ab433d9c3b7e17666d6993084c002c2ff1ca09b96391d
Status: Downloaded newer image for hello-world:latest
docker.io/library/hello-world:latest

[ ~ ]docker images
REPOSITORY TAG IMAGE ID CREATED SIZE
hello-world latest bf756fb1ae65 12 months ago 13.3kB
```

# Create a Container

\begin{center}
To create a container from an image we can use the **docker create** command
\end{center}

```bash
[ ~ ]docker create hello-world

2ffd5f2c5a7562fbf1d7b89a14c11a52e5843dd7938f380a8cd53f3952da99de
```

# Run a Container

\begin{center}

To run a container we can use the **docker container start** command to start a container.

The **-i** runs the container interactively and allows us to see the output

\end{center}

```bash
[ ~ ] docker container start -i 2ffd5f2c5a7562fbf1d7…

Hello from Docker!

This message shows that your installation appears to be working correctly.
```

# Run an Image

\begin{center}

There is a shortcut for building a container from an image and running it with the **docker run** command. This will create a new container for an image and run it:

\end{center}

```bash
[ ~ ] docker run hello-world

Hello from Docker!

This message shows that your installation appears to be working correctly.
```

# List Images

\begin{center}
To see what images are already installed on your machine you can use the **docker image ls** command. We can see our hello-world image below:
\end{center}

```bash
[ ~ ]docker image ls
REPOSITORY   TAG      IMAGE         ID  CREATED      SIZE
ubuntu       latest   f63181f19b2f  13  hours ago    72.9MB
hello-world  latest   bf756fb1ae65  12  months ago   13.3kB
```

# List Containers

\begin{center}
To list the containers that we have built, we can use the **docker container ls** command.

The **-a** flag allows us to see both stopped and running containers. There are two containers below, one that was built with the **docker create** command and the other that was built with **docker run**:
\end{center}

```bash
[ ~ ]docker container ls –a
CONTAINER ID    IMAGE         COMMAND    CREATED          STATUS                       PORTS   NAMES
5017fd2b94c2    hello-world   "/hello"   7 minutes ago    Exited (0) 7 minutes ago             stoic_nobel
5f0cea57eacf    ubuntu        "bash"     10 minutes ago   Exited (127) 8 minutes ago           condescending_neumann
2ffd5f2c5a75    hello-world   "/hello"   14 minutes ago   Exited (0) 13 minutes ago            hungry_mclaren
```

# Running interactively

\begin{center}
Running containers interactively allows you to run commands inside the container if it supports it. We can use the openjdk image that we used before:
\end{center}

```bash
[ ~ ]docker run -it openjdk
Unable to find image 'openjdk:latest' locally
latest: Pulling from library/openjdk
a73adebe9317: Pull complete
8b73bcd34cfe: Pull complete
1227243b28c4: Pull complete
Digest: sha256:7ada0d840136690ac1099ce3172fb02787bbed83462597e0e2c9472a0a63dea5
Status: Downloaded newer image for openjdk:latest
Jan 21, 2021 4:48:58 PM java.util.prefs.FileSystemPreferences$1 run
INFO: Created user preferences directory.
| Welcome to JShell -- Version 15.0.2
| For an introduction type: /help intro

jshell> System.out.println(”hello world");
Hello world
```

\begin{center}
This allows us to execute java commands line by line in a Java shell
\end{center}

# List Running Processes

\begin{center}
To see what containers are currently running, we can use the **docker ps** command.

This is useful when you are running containers in the background
\end{center}

```bash
[ ~ ]docker ps
CONTAINER ID    IMAGE     COMMAND    CREATED          STATUS          PORTS    NAMES
55e4a7c3ddcc    openjdk   "jshell"   11 seconds ago   Up 10 seconds            affectionate_kowalevski
```

# Interactive Shell

```bash
[ ~ ] docker run -it ubuntu bash
Unable to find image 'ubuntu:latest' locally
latest: Pulling from library/ubuntu
83ee3a23efb7: Pull complete
db98fc6f11f0: Pull complete
f611acd52c6c: Pull complete
Digest:
sha256:703218c0465075f4425e58fac086e09e1de5c340b12976ab9eb8ad26615c3715
Status: Downloaded newer image for ubuntu:latest
root@5f0cea57eacf:/#
```

#

Dockerize an Application

# Revisiting LightsOut

::: columns
:::: column

Let's dockerize the code in the repository for the LightsOut microservice.

::::
:::: columns

Screenshot of GitHub repo

::::
:::

# Adding a Dockerfile

::: columns
:::: column

To create a custom docker image. We need to create a **Dockerfile**.
The dockerfile specifies how our image should be built

::::
:::: column

Docker file code

::::
:::

# Dockerfile Syntax

::: columns
:::: column

* **From** - the base image to use
* **Run** - runs commands when building the docker image
* **Workdir** - Specifies the directory that commands are run from
* **User** - Switches users
* **Copy** - Copies files
* **CMD** - Runs commands when running the container

::::
:::: column

The text of the docker file

::::
:::

# Dockerfile Explained

::: columns
:::: column

1. Use the OpenJDK image to have a pre-configured java environment
2. Add a new user "**ojdk**" that we will be using for executing scripts
3. Create a directory that will contain our files and give permission to our user
4. Change the working directory to the directory we created
5. Copy the java and junit files
6. Switch to user ojdk
7. Compile all of our code
8. Copy files to the working directory and give perimissions to ojdk
9. Run all tests

::::
:::: column

The text of the Dockerfile

::::
:::

# Build a Docker Image

\begin{center}
To build a docker image using a Dockerfile we can use the **docker image build** command and provide it the directory where the Dockerfile exists. The **--tag** option allows us to name and tag the docker image.
\end{center}

Image of execution

# Run Our Custom Image

\begin{center}
We can use the **docker run** command to run our image and we can see that our server is up and running:
\end{center}

Image of execution

# Run Interactively

\begin{center}
We can use **docker run -it** to run our image interactively and open a bash shell in our working directory:
\end{center}

Image of execution

# Docker Compose File

::: columns
:::: column

Docker Compose files can be used to run multiple services at once and is great once you have many microservices as part of your application.

For our project we create a single service server that

- is built using a custom Dockerfile
- tagged with the name `lightsout`
- restarts unless it is stopped

::::
:::: column

::::
:::

# Run Docker Compose

\begin{center}
To run our docker compose file, we use the **docker-compose up** command. This builds and runs all images and containers.
\end{center}

Image of Execution

# Stop Containers

\begin{center}
The lightsout container will keep restarting unless its stopped. To stop all services, we can use the **docker-compose down** command:
\end{center}

Image of execution

# Clean Up

\begin{center}
To remove all unused docker resources, we can use the **docker system prun** command with the **--all** flag:
\end{center}

Image of execution
