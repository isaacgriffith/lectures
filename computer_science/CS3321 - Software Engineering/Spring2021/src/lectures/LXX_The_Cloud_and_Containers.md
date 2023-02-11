---
author:
- Isaac Griffith
title: The Cloud and Containers
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Topics Covered

# The cloud

* The cloud is made up of very large number of remote servers that are offered for rent by companies that own these servers.
  - Cloud-based servers are ‘virtual servers’, which means that they are implemented in software rather than hardware.  
* You can rent as many servers as you need, run your software on these servers and make them available to your customers.
  - Your customers can access these servers from their own computers or other networked devices such as a tablet or a TV.
  - Cloud servers can be started up and shut down as demand changes.
* You may rent a server and install your own software, or you may pay for access to software products that are available on the cloud.

# Scaleability, elasticity and resilience

<!-- diagram on slide 3 -->

# Scaleability, elasticity and resilience

* Scaleability reflects the ability of your software to cope with  increasing numbers of users.
  - As the load on your software increases, your software automatically adapts so that the system performance and response time is maintained.
* Elasticity is related to scaleability but also allows for scaling-down as well as scaling-up.
  - That is, you can monitor the demand on your application and add or remove servers dynamically as the number of users change.
* Resilience means that you can design your software architecture to tolerate server failures.
  - You can make several copies of your software concurrently available. If one of these fails, the others continue to provide a service.

# Benefits of using teh cloud for software development

* Cost
  - You avoid the initial capital costs of hardware procurement
* Startup time
  - You don’t have to wait for hardware to be delivered before you can start work. Using the cloud, you can have servers up and running in a few minutes.
* Server choice
  - If you find that the servers you are renting are not powerful enough, you can upgrade to more powerful systems. You can add servers for short-term requirements, such as load testing.
* Distributed development
  - If you have a distributed development team, working from different locations, all team members have the same development environment and can seamlessly share all information.

# Virtual cloud servers

* A virtual server runs on an underlying physical computer and is made up of an operating system plus a set of software packages that provide the server functionality required.
* A virtual server is a stand-alone system that can run on any hardware in the cloud.
  - This ‘run anywhere’ characteristic is possible because the virtual server has no external dependencies.  
* Virtual machines (VMs), running on physical server hardware, can be used to implement virtual servers.
  - A hypervisor provides hardware emulation that simulates the operation of the underlying hardware.
* If you use a virtual machine to implement virtual servers, you have exactly the same hardware platform as a physical server.

# Implementing a virtual server as a VM

<!-- diagram on slide 7 -->

# Container-based virtualization

* If you are running a cloud-based system with many instances of applications or services, these all use the same operating system, you can use a simpler virtualization technology called ‘containers’.
* Using containers accelerates the process of deploying virtual servers on the cloud.
  - Containers are usually megabytes in size whereas VMs are gigabytes.
  - Containers can be started and shut down in a few seconds rather than the few minutes required for a VM.
* Containers are an operating system virtualization technology that allows independent servers to share a single operating system.
  - They are particularly useful for providing isolated application services where each user sees their own version of an application.

# Isolated services

<!-- diagram on slide 9 -->

# Docker

* Containers were developed by Google around 2007 but containers became a mainstream technology around 2015.
* An open-source project called Docker provided a standard means of container management that is fast and easy to use.
* Docker is a container management system that allows users to define the software to be included in a container as a Docker image.
* It also includes a run-time system that can create and manage containers using these Docker images.

# Docker container system

<!-- diagram on slide 11 -->

# Elements of the Docker system

* Docker daemon
  - This is a process that runs on a host server and is used to setup, start, stop, and monitor containers, as well as building and managing local images.
* Docker client
  - This software is used by developers and system managers to define and control containers
* Dockerfiles
  - Dockerfiles define runnable applications (images) as a series of setup commands that specify the software to be included in a container. Each container must be defined by an associated Dockerfile.
* Image
  - A Dockerfile is interpreted to create a Docker image, which is a set of directories with the specified software and data installed in the right places. Images are set up to be runnable Docker applications.

# Elements of the Docker system

* Docker hub
  - This is a registry of images that has been created. These may be reused to setup containers or as a starting point for defining new images.
* Containers
  - Containers are executing images. An image is loaded into a container and the application defined bby the image starts execution. Containers may be moved from server to server without modification and replicated across many servers. You can make changes to a Docker container (e.g. by modifying files) but you then must commit these changes to create a new image and restart the container.

# Docker images

* Docker images are directories that can be archived, shared and run on different Docker hosts.  Everything that’s needed to run a software system - binaries, libraries, system tools, etc. is included in the directory.
* A Docker image is a base layer, usually taken from the Docker registry, with your own software and data added as a layer on top of this.
  - The layered model means that updating Docker applications is fast and efficient. Each update to the filesystem is a layer on top of the existing system.
  - To change an application, all you have to do is to ship the changes that you have made to its image, often just a small number of files.

# Benefits of containers

* They solve the problem of software dependencies. You don’t have to worry about the libraries and other software on the application server being different from those on your development server.
  - Instead of shipping your product as stand-alone software, you can ship a container that includes all of the support software that your product needs.
* They provide a mechanism for software portability across different clouds.  Docker containers can run on any system or cloud provider where the Docker daemon is available.
* They provide an efficient mechanism for implementing software services and so support the development of service-oriented architectures.
* They simplify the adoption of DevOps. This is an approach to software support where the same team are responsible for both developing and supporting operational software.

# Key points

* The cloud is made up of a large number of virtual servers that you can rent for your own use. You and your customers access these servers remotely over the internet and pay for the amount of server time used.
* Virtualization is a technology that allows multiple server instances to be run on the same physical computer. This means that you can create isolated instances of your software for deployment on the cloud.
* Virtual machines are physical server replicas on which you run your own operating system, technology stack and applications.
* Containers are a lightweight virtualization technology that allow rapid replication and deployment of virtual servers. All containers run the same operating system. Docker is currently the most widely used container technology.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
