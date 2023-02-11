---
author:
- Dr. Isaac Griffith
title: GitHub Actions
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
* Understand the basic concepts of cloud computing
* Understand the basic services offered by AWS
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
\Huge The Cloud
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# In the Beginning

* 2006 - Amazon Web Services (AWS) began offering IT infrastructure services to businesses
* We now call this cloud computing
* In the cloud
  - No longer need to plan and procure servers
  - Now we can spin up hundreds or thousands of servers in minutes

\vskip1.5em

\Large \textcolor{Roarange}{\textbf{Cloud computing allows you to replace upfront capital infrastructure expenses with low variable costs that scale with business.}}

# Cloud Computing???

* \textcolor{Roarange}{\textbf{Cloud Computing}} - The on-demand delivery of
  - \small compute power
  - \small database storage
  - \small applications, and
  - \small other IT resources

  via a cloud services platform across the internet

\vskip.5em

* Provides a simple way to access servers, storage, databases and many other applications

# Advantages of Cloud Computing

* Trade capital expense for variable expense
* Benefit from massive economies of scale
* Stop guessing capacity
* Increase speed and agility
* Stop spending money running and maintaining data centers
* Go global in minutes

# Types of Cloud Computing

* Goal is to provide Devs and IT Departments with the ability to focus on what matters

\vskip.5em

* As Cloud Computing has grown, so has the number of models and deployment strategies, each providing
  - \small different levels of control
  - \small different levels of flexibility
  - \small different levels of management

\vskip.5em

* Three key Models have emerged over time:
  - \small Infrastructure as a Service (IaaS)
  - \small Platform as a Service (PaaS)
  - \small Software as a Service (SaaS)

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Computing Models
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Compute Models

* \footnotesize \textcolor{Roarange}{\textbf{IaaS}} -- Procure the infrastructure, as needed, rather than own it
  - \scriptsize Abstracts the basic building blocks of IT into a service which can be provisioned
  - \scriptsize These include: networking, computers (virtual and physical), and storage space
  - \scriptsize Provides high levels of flexibility and capability

\vskip.5em

* \footnotesize \textcolor{Roarange}{\textbf{PaaS}} -- Procure the platform, as needed, rather than own it
  - \scriptsize Abstracts the away the management of underlying infrastructure
  - \scriptsize Allows for focus to be placed on deployment and management of applications
  - \scriptsize No need to worry about resource procurement, capacity planning, software maintenance, patching, or other underlying aspects of running an application

\vskip.5em

* \footnotesize \textcolor{Roarange}{\textbf{SaaS}} -- Procure the software, as needed, rather than own it
  - \scriptsize Provides the completed product that is run and managed by the service provider
  - \scriptsize No need to consider how the service is maintained or underlying infrastructure managed
  - \scriptsize \textcolor{Buttons}{\textit{Example}}: Web-based Email (think GMail here at the University)

# Deployment Models

* \small \textcolor{Roarange}{\textbf{Cloud}}
  - \footnotesize Cloud-application fully deployed to the cloud and ran in the cloud
  - \footnotesize Built upon low-level infrastructure controlled by high-level services abstracting
    management, architecture, and scaling requirements

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Hybrid}}
  - \footnotesize Provides a means to connect existing on-premise IT infrastructure with cloud infrastructure

\vskip.5em

* \small \textcolor{Roarange}{\textbf{On-premises}}
  - \footnotesize Private cloud, using virtualization and resource management
  - \footnotesize Significantly limits the benefits of cloud computing, but provides dedicated resources
  - \footnotesize Similar to the legacy IT approach

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge AWS Cloud Platform
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# AWS Cloud Platform

* \small \textcolor{Roarange}{\textbf{AWS Management Console}}
  - \footnotesize The main Web UI from which you manage all components of your AWS infrastructure/account
  - \footnotesize Can also be done via the AWS Console Mobile App

\vskip.5em

* \small \textcolor{Roarange}{\textbf{AWS Command Line Interface}}
  - \footnotesize Command line tool that allows management of AWS services via the command line
  - \footnotesize Provides scripting capabilities (i.e., DevOps)

\vskip.5em

* \small \textcolor{Roarange}{\textbf{AWS SDK}}
  - \footnotesize Allows your Apps to manage AWS via an API tailored to platform and language

#

\centering
\vfill
\begin{minipage}{.4\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge AWS Compute
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# EC2

* Amazon EC2 - Elastic Compute Cloud
  - \small Basis for all of AWS compute capabilities
  - \small Allows for scalable and resizable compute capacity in the cloud
  - \small Uses a web service to obtain and configure capacity
  - \small Simple to obtain and boot new instances

# EC2 Instance Types

* \small \textcolor{Roarange}{\textbf{On-Demand Instances}}
  - \footnotesize Pay for compute capacity by the hour
  - \footnotesize Can increase/decrease based on demand while only paying the hourly rate

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Reserved Instances}}
  - \footnotesize Provide up to 75% discount on On-Demand
  - \footnotesize Provides flexibility to change families, OS types, and tenancies

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Spot Instances}}
  - \footnotesize Provide up to 90% discount on On-Demand
  - \footnotesize Allows you to take advantage of unused compute capacity

# ECR

* Amazon Elastic Container Registry (ECR)
  * \small Provides functionality similar to docker hub but on AWS
  * \small Stores, manages, and deploys docker container images
  * \small Integrates with ECS (next slide) and simplifies workflow

\vskip.5em

* ECR hosts your images and provides Identity and Access Management (IAM) resource-level
  control for the repo.

\vskip.5em

* \textcolor{Roarange}{\textbf{Note:}} you only pay for the amount of data you store and transfer

# ECS

* Amazon Elastic Container Service
  - \small Highly scalable, high-performance container orchestration service for Docker containers
  - \small Provides ease of use to run and scale containerized apps

\vskip.5em

* \textcolor{Roarange}{\textbf{Goal}} is to eliminate need to install/operate your own container orchestration service

# Lightsail

* Easiest way (on AWS) to launch and manage a virtual private server

\vskip.5em

* Plan includes the following
  - \small A VM
  - \small SSD based storage
  - \small Data transfer
  - \small DNS management
  - \small Static IP address
  - \small Low, predictable price

# AWS Batch

* Enabled developers, scientists, and engineers to
  - \small Easily and efficiently run hundreds of thousands of batch computing jobs
  - \small Think \textcolor{Roarange}{\textbf{High-Performance}} or \textcolor{Roarange}{\textbf{Super-computing}}
  - \small Dynamically provisions the optimal quantity and type of compute resources
    - \footnotesize CPU or memory-optimized instances
    - \footnotesize Based on the volume and specific resource requirements of the batch job

\vskip.5em

* No need to install/manage
  - \small Batch computing software
  - \small Server clusters

\vskip.5em

* Plans, schedules and executes your jobs across the AWS compute services

# Elastic Beanstalk

* Service for deploying and scaling web apps and services developed in
  - \small Java
  - \small .NET
  - \small PHP
  - \small Node.js
  - \small Python
  - \small Ruby
  - \small Go
  - \small Docker

\vskip.5em

* Uses common servers such as Apache, Nginx, Passenger and IIS

# Fargate

* A ECS compute engine that allows Container operations without requiring
  you to manage servers or clusters

\vskip.5em

* No need to to do any of the following
  - \small Provision VMs
  - \small Configure VMs
  - \small Scale VM Clusters

\vskip.5em

* Minimizes your decisions as it takes care of all this and
  - deciding when to scale your clusters
  - optimizing cluster packing

\vskip.5em

\textcolor{Roarange}{\textbf{No more managing infrastructure, just focus on building apps}}

# Fargate and ECS

* ECS has two modes: \textcolor{Roarange}{\textbf{Fargate Launch}} and \textcolor{Roarange}{\textbf{EC2 Launch}}

* \textcolor{Roarange}{\textbf{Fargate Launch}} - All you need to do is:
  - \small package your app in a container
  - \small specify the CPU and memory requirements
  - \small define networking policies
  - \small launch the app

* \textcolor{Roarange}{\textbf{EC2 Launch}} - provides a bit more control
  - \small server-level control
  - \small granular control over the infrastructure that runs your apps
  - \small ECS manages your cluster of servers, tracks CPU, memory and other resources
  - \small You are responsible for provisioning, patching, and scaling server clusters

# Lambda

* Run Code without provisioning or managing servers

\vskip.5em

* All you pay for is the compute time you consume, with no cost if your code isn't running

\vskip.5em

* You can run your code without any type of application or backend service
  - \small Effectively zero administration

\vskip.5em

* Just upload your code, and let Lambda take care of everything else
  - \small High Scalability
  - \small High Availability

# SAR

* AWS Serverless Application Repository
  - \small provides a means to quickly deploy code samples, components, and apps
  - \small can be used for web and mobile backends
  - \small can be used for data processing, logging, monitoring, IoT, etc.

\vskip.5em

* Uses the AWS Serverless Application Model (SAM) template to define AWS resources used

\vskip.5em

* You can also publish your own apps and share them across a team, an organization, or the
  community at large.

# Things To Do

1. Get yourself an AWS account

\vskip.5em

2. Start learning about these different technologies
   - \small I would start with AWS Fargate and Elastic Beanstalk

\vskip.5em

3. Start considering how you might connect github, dockerhub, and aws together

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
