---
author:
- Dr. Isaac Griffith
title: Docker and Containers
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Docker
* Docker-Compose
* Basic idea of DockerHub
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
\Huge Virtualization
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Advantages of Virtualization

* \small Minimize hardware costs
  - \footnotesize Multiple virtual servers on one physical hardware
* \small Easily move VMs to other data centers
  - \footnotesize Provides disaster recovery. Hardware maintenance
  - \footnotesize Follow the sun (active users) or follow the moon (cheap power)
* \small Consolidate idle workloads. Usage is bursty and asynchronous
  - \footnotesize Increase device utilization
* \small Conserve power
  - \footnotesize Free up unused physical resources
* \small Easier automation
  - \footnotesize Simplified provisioning/administration of hardware and software
* \small Scalability and Flexibility: Multiple operating systems



# Problems of Virtualization

::: columns
:::: column

* \small Each VM requires an operating system (OS)
  - \footnotesize Each OS requires a license
  - \footnotesize Each OS has its own compute and storage overhead
  - \footnotesize Needs maintenance, updates

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/vm_arch.eps}

::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Containers
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Solution: Containers

* \small Run many apps in the same virtual machine
  - \footnotesize These apps share the OS and its overhead
  - \footnotesize But these apps can't interfere with each another
  - \footnotesize Can't access each other's resources without explicit permission
  - \footnotesize Like apartments in a complex

# Containers

::: columns
:::: column

* \small Multiple containers run on one operating system on a virtual/physical machine
* \small All containers share the operating system
* \small Containers are isolated -> cannot interfere with each other
  - \footnotesize Own file system/data, own networking -> Portable

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/container_arch.eps}

::::
:::

# Containers

* \small Containers have all the good properties of VMs
  - \footnotesize Come complete with all files and data that you need to run
  - \footnotesize Multiple copies can be run on the same machine or different machine -> Scalable
  - \footnotesize Same image can run on a personal machine, in a data center or in a cloud
  - \footnotesize Operating system resources can be restricted or unrestricted as designed at container build time
  - \footnotesize Isolation: For example, "Show Process" (ps on Linux) command in a container will show only the processes in the container
  - \footnotesize Can be stopped. Saved and moved to another machine or for later run

# VM vs. Containers

\footnotesize

+-----------------------------------------+-----------------------------------+-------------------------------------------+
| \textcolor{Roarange}{\textbf{Criteria}} | \textcolor{Roarange}{\textbf{VM}} | \textcolor{Roarange}{\textbf{Containers}} |
+:========================================+:=================================:+:=========================================:+
| Image Size                              | 3X                                | X                                         |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Boot Time                               | \> 10s                            | ~ 1s                                      |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Computer Overhead                       | \> 10%                            | < 5%                                      |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Disk I/O Overhead                       | \> 50%                            | Negligible                                |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Isolation                               | Good                              | Fair                                      |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Security                                | Low-Medium                        | Medium-High                               |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| OS Flexibility                          | Excellent                         | Poor                                      |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Management                              | Excellent                         | Evolving                                  |
+-----------------------------------------+-----------------------------------+-------------------------------------------+
| Impact on Legacy Application            | Low-Medium                        | High                                      |
+-----------------------------------------+-----------------------------------+-------------------------------------------+

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Docker
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Microservices

::: columns
:::: column

* \small Breaks large applications down into smaller executable components
* \small Easy to maintain and test
* \small Loosely coupled and can be deployed independently
* \small Can be combined with serverless architecture (i.e., AWS Lambda)

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/microservice_arch.eps}

::::
:::

# Why Use Docker

::: columns
:::: column

* \small Develop applications that work on \textcolor{Roarange}{\textbf{any OS}}
* \small Easy to \textcolor{Roarange}{\textbf{share}} applications among teams
* \small Easy to \textcolor{Roarange}{\textbf{scale}} across multiple servers
* \small Large applications can be broken into \textcolor{Roarange}{\textbf{multiple containers}} - one for each microservice

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/docker.png}

::::
:::

* \small Great solution for \textcolor{Roarange}{\textbf{Cloud Computing}}
* \small Big community and \textcolor{Roarange}{\textbf{library}} of Docker images

# Serverless

::: columns
:::: column

* \small \textcolor{Roarange}{\textbf{Removes Dependency}} on infrastructure
* \small Allows developers to focus on application development
* \small Microservices can be decoupled with different cloud services
* \small Usually more \textcolor{Roarange}{\textbf{cost effective}}

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/aws_lambda.png}

::::
:::


# Docker

::: columns
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/docker_arc.png}

::::
:::: column

* \small Provides the isolation among containers
* \small Helps them share the OS
* \small Docker = Dock worker -> Manage containers
* \small Developed initially by Docker.com
* \small Downloadable for Linux, Windows, and Mac from docker.com
* \small Customizable with replacement modules from others

::::
:::

# Docker

* \small Docker Engine: Runtime
* \small Two Editions:
  - \footnotesize \textcolor{Roarange}{\textbf{Community Edition (CE):}} Free for experimentation
  - \footnotesize \textcolor{Roarange}{\textbf{Enterprise Edition (EE):}} For deployment with paid support
* \small Written in the \textcolor{Buttons}{\textit{\textbf{Go}}} programming language from Google
* \small Download the community edition and explore

# Docker Engine Components

::: columns
:::: {.column width=.6}

\vspace{-1em}

\begin{center}
\includegraphics[width=\textwidth]{images/docker/docker_engine.eps}
\end{center}

::::
:::: {.column width=.4}

* \small \textcolor{Roarange}{\textbf{daemon:}} API and other features
* \small \textcolor{Roarange}{\textbf{containerd:}} Execution logic. Responsible for container lifecycle. Start, stop, pause, unpause, delete containers
* \small \textcolor{Roarange}{\textbf{runc:}} A lightweight runtime CLI

::::
:::

# Image Registries

* \small Containers are built from images and can be saved as images
* \small Images are stored in registries
  - \footnotesize Local registry on the same host
  - \footnotesize Docker Hub Registry: Globally shared
  - \footnotesize Private registry on Docker.com
* \small Any component not found in the local registry is downloaded from specified location
* \small Official Docker Registry: Images vetted by Docker
* \small Unofficial Registry: Images not vetted (Use with care)
* \small Each image has several tags, e.g., v2, latest, ...
* \small Each image is identified by its 256-bit hash

# Layers

* \small Each image has many layers
* \small Image is built layer by layer
* \small Layers in an image can be inspected by Docker commands
* \small Each layer has its own 256-bit hash

::: columns
:::: column

* \small For example:
  - \footnotesize Ubuntu OS is installed, then
  - \footnotesize Python package is installed, then
  - \footnotesize a security patch to Python is installed
* \small Layers can be shared among many containers

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/docker/image_layers.eps}

::::
:::

# Building Container Images

* \small Create a \textcolor{Roarange}{\textbf{Dockerfile}} that describes the application, its dependencies and how to run it

\footnotesize

```docker
      FROM Alpine
      LABEL maintainer="xx@gmail.com"
      RUN apk add -update nodejs nodejs -npm
      COPY ./src
      WORKDIR /src
      RUN npm install
      EXPOSE 8080
      ENTRYPOINT ["node", "./app.js"]
```

* \small \textcolor{Roarange}{\textbf{Note:}} WORKDIR, EXPOSE, ENTRYPOINT result in tags. Others in Layers

# Docker commands

* \small `docker run`: Run the specified image
* \small `docker start`: start a stopped container
* \small `docker stop`: stop a container
* \small `docker ps`: shows the current process in a running container
* \small `docker image ls`: list running containers
* \small `docker rm`: delete a container
* \small `docker image rm`: delete an image
* \small `docker build`: creates a new image from docker file

# Open Container Initiative (OCI)

* \small A company called CoreOS defined alternative image format and container runtime API's
* \small Led to formation of OCI under Linux Foundation to govern container standards
  - \footnotesize OCI Image spec
  - \footnotesize OCI Runtime spec
* \small Everyone including Docker is now moving to or on OCI

# Docker Compose

::: columns
:::: column

\vspace{-1em}

\scriptsize
```yaml
version: 3

services:
  sysad-mysql:
    image: mysql:5.7
    environment:
      - "MYSQL_ROOT_PASSWORD=password"
    container_name: sysad-mysql
    restart: always
  sysad-apache2:
    image: sysad-crud
    ports:
      - "80:80"
    links:
      - "sysad-mysql"
    container_name: sysad-crud
    restart: always
    stdin_open: true
    tty: true
```

::::
:::: column
* \small Run multiple services in a single container
* \small Very useful for microservice applications
  - \footnotesize Service: Database
  - \footnotesize Service: Back-end server
  - \footnotesize Service: Front-end Web Client
* \small Specified as a \textcolor{Roarange}{\textbf{docker-compose.yml}} file
::::
:::

# Docker Swarm

* \small Orchestrates thousands of Containers
* \small \textcolor{Roarange}{\textbf{Swarm\textcolor{Roarange}{\textbf{: a group of nodes collaborating over a network
* \small Two modes for Docker hosts:
  - \footnotesize Single Engine Mode: Not participating in a swarm
  - \footnotesize Swarm Mode: Participating in a Swarm
* \small A Service may run on a swarm
* \small Each swarm has a few managers that dispatch tasks to workers
  - \footnotesize Managers are also works (i.e., execute tasks)

# Docker Swarm

* \small The managers select a leader, who really keeps track of the swarm
* \small Assigns tasks, re-assigns failed worker's tasks, ...
* \small Other managers just monitor passively and re-elect a leader if the leader fails
* \small Services can be scaled up or down as needed
* \small Several Docker commands:
  - \footnotesize `docker service`: Manage services
  - \footnotesize `docker swarm`: Manage swarms
  - \footnotesize `docker node`: Manage nodes

# Docker Overlay Networking

* \small Nodes in a swarm may not be in the same LAN
* \small VXLAN is used to provide virtual overlay networking

\centering
\includegraphics[width=.75\textwidth]{images/docker/networking.eps}

# Docker Security

* \small All built-in security mechanisms in Linux are used and more
* \small Cryptographic node IDs
* \small Mutual Authentication
* \small Automatic Certificate Authority configuration
* \small Automatic Certificate Renewal on expiration
* \small Encrypted Cluster Store
* \small Encrypted Network traffic
* \small Signed images in Docker Content Trust (DCT)
* \small Docker Security Scanning detects vulnerabilities
* \small Docker secrets are stored in encrypted cluster store, encrypted transmission over network, and stored in in-memory file system when in use

# Kubernetes

* \small Open Source Container Orchestration alternative
* \small Original source released by Google
* \small Cloud Native Computing Foundation (CNCF) project in Linux Foundation
* \small Pre-cursor to Swarms
* \small Facilities similar to Swarms
* \small A set of related containers is called a "Pod"
  - \footnotesize A Pod runs on a single host
* \small Swarm is called a "Cluster"

# For Next Time

::: columns
:::: column

* Review the Reading
* Review this Lecture
* Come to Class

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
