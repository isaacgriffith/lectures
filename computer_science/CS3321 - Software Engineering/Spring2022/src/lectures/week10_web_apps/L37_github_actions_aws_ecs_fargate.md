---
author:
- Dr. Isaac Griffith
title: Deploying with GitHub Actions, Docker, and AWS Fargate
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Create Your Docker Image

::: columns
:::: column

* Add a "Dockerfile" file to the root of your project.
* This file will control the creation of the container, in which you server will execute. An example is a follows (for java, those of you interested in Python, I suggest googling base image for python docker.):

::::
:::: column

```
# get base image
FROM openjdk:17-jdk-oraclelinux8

# Arguments
ARG PORT=7000

# set the maintainer
MAINTAINER "Isaac D. Griffith"

# create working directory
WORKDIR ./

# copy components
COPY ./build/distributions/server.zip ./server.zip

# Install dependencies
RUN microdnf install zip unzip -y

# install the components
RUN unzip server.zip

# expose the networking port (tells everyone what port will be used, but does not force anything)
EXPOSE $PORT

# create the user so root is not running the app (very good practice)
RUN useradd -m appuser
USER appuser

# Setup the entrypoint -- This is what is called when the container runs
ENTRYPOINT ./server/bin/server
```

::::
:::

# Create Your Docker Image

* Now that you have your Dockerfile created, it probably is a good idea to verify that it builds without any errors
* You can build using the following command (on linux, I am not sure what the windows alternative is)

  ```bash
  $ sudo docker build -t "image:tag" .
  ```

* Note that the "`image:tag`" is used to represent the name of the image and it tag.    
* You will be able to see the image created, if successful, by running the following command: `$ sudo docker image ls`    
* You can run your image by executing

  ```bash
  $ sudo docker container run "image:tag"
  ```

* If you need to map a port you can add the argument: `-p HOST:DOCKER`
  - For example: `sudo docker container run tic-tac-toe:1.0 -p 5555:7000`

# GitHub Actions

* Travis CI (Circle CI, GitHub Actions, Jenkins CI, etc.) provides the capability to execute our builds and other functions automatically upon push to the repository. This is extremely helpful, as it prevents us from having to constantly push the button. Furthermore, once we have the process down in such a way as we can script it we might as well automate it at the same time.

* All of the tools work basically in the same way. We provide a file in the root of our git repository, which defines a pipeline that will be executed to build and/or deploy our application. In the case of Travis CI we need to provide a ".travis.yml" file.    

* In this file you need to specify a few things    
* First you need to setup your environment, which includes the following (at a minimum):        
* the language you are using for the build (for multilingual builds, there is an approach for this as well but I will stick with single language builds for now).        
* the OS used for the build (and its distribution)        
* environment variables (often needed for various steps in the build)        
* any additional services (i.e., docker, mysql, etc.)
* Once the enviroment is setup you then execute the build script
* In addition to the build you can perform a set of actions prior to the script and after the script succeeds/fails
* There is also an install step in which various tools, needed by the build, may be installed
* Finally, when the install finishes, you can then execute the deploy steps
* An example is as follows:

```yaml
sudo: required
language: java
install: skip
os: linux
dist: focal
env:
  global:
  - AWS_URL=565338450378.dkr.ecr.us-east-2.amazonaws.com
  - LIVE_SERVICE=tictactoe
  - LIVE_CLUSTER_NAME=tictactoe-cluster
  - LIVE_APP_NAME=tictactoe
  - secure: s2ElIZ81uM7qCxQt9SktJISry5B8YfHXXC6CPoUUNSVXHR6LUJPPDNZHRk1DKhjMVzcogFycRFHNA9JrPUkcPoT9v2V9nY3C77o00DvJoC7VraGwpnLoS+9EZBBuR1AJrIwhW9hQpPTdpICyI5+I2wCSSLTf3xoxCHtYWgb/oAdP9FyGGLuB/jBmld11Yu2dgC/GkCLtyix3xjVmKi6D+0u8CRo+OsvHI57GOtKtvDA4ZEPJhWDOPz5E7ZJFe3qnUTt7ehhURkZ3QQtFHORuW9Dd88JOdK9AptmJtIZaXMmWZOQX2E5l50n1NeeJXrgG5EFEQ8SWMR4vMXrMqqO7Dp67xhJLTipPIIsWHMaLaEBOJHtoc2VKhjxFOgxKSwhG8YE7CmhztPaFJUgL75qqweOW8RB4uzuwvj+mOqMJ2mJiwzmiXnYuRme67DU5ZAmBduPz3fiAcJMJ/sLzbjxj/Eg6onAQobZ6cUFOn3QKygBjFDbCq7UouV5nrVZ/pwD7+KoPAYYHabqg0Kojmn+v5A/LHFEPe83wBXvlBj54DmZNXjQw09oHlaVqFRCKYTasE2ofyoztgba27BWz5H80AGJcSVI2Pav3Hn3jBitgUQzcnFl5TXHlC6u4LFq0Z52S8rSntxmDejF2FPlv+CdWmnDD4ur8DFBSyTPqmXOYUIM=
  - secure: 0XkDDnemo446Bug98RG+FuXObfadbsxlqhsPZzO8vGT+hoITbkq8NSylUXAksL9Dq1tnf8vQfzSF0g8BLntTlF91pgZxiSaAQ/8k3yNCEjeY2dd/kD8cDscpRQPzkPtAYfdaPn30/iQ+yQdajBhHS3VpwYeLgjiyF1C/ond57KQWp8jT9+e913UuuAybJxDOuSyu+qT10Pb3hyNFBDYE4CSz7GVKt/hvRSLDdZ0Ihg9c7FB+aOLHGR7CzowK7C/OhH0MhFnDEacjThkKSLSpz7se2Gq9MqgCW+TZAkcWDfxBmXcqIhht+7gjIVP55hT3LMVbBNHHVgHtbcUPx+a+oQUpktyxEKZeyRpogZ33eiAbEiVQCC4NbqO5U/WokPHCtA+3dHcX22gTwD39Qqe6a4QPPUVj+7rlstGWInD/ykcnWkULbB74EBNZ6vY4HWgMq/DA7hJYfEpNcKJIMfAQLr+JT6+Qmm6dz4Fl+QlT/bjXYXnzmNCtp6dOxGzKNZClYVg0SKU+k+j8jVk5KkDzP4G3CFcDttdRRNfarqvkujjKLejq0UzRNDk8yaptZnzT/0PaEYMqRpG8eW5A2Jc5ItkZgU1jRIIeLmHUJvxKlc0BGbLQ8e/j2A5k1dTZuEBw4+6cTY1OYJdeXJTN4YsoiRH2DEgWyufGaNlqbPYuwJg=
services:
- docker
before_install:
- pip install awscli
- export PATH=$PATH:$HOME/.local/bin
script:
- wget https://github.com/sormuras/bach/raw/master/install-jdk.sh
- chmod +x $TRAVIS_BUILD_DIR/install-jdk.sh
- export JAVA_HOME=$HOME/openjdk17
- "$TRAVIS_BUILD_DIR/install-jdk.sh -F 17 --target $JAVA_HOME"
- rm install-jdk.sh
- rm jdk.tar.gz
- chmod +x gradlew
- "./gradlew assemble"
- cd server
after_success:
  - docker --version
  - pip install --user awscli
  - export PATH=$PATH:$HOME/.local/bin
  - eval $(aws ecr get-login --no-include-email --region us-east-2)
  - docker build -t "$LIVE_APP_NAME:latest" .
  - docker tag "$LIVE_APP_NAME:latest" "$AWS_URL/$LIVE_APP_NAME:$TRAVIS_COMMIT"
  - docker tag "$LIVE_APP_NAME:latest" "$AWS_URL/$LIVE_APP_NAME:latest"
  - docker push "$AWS_URL/$LIVE_APP_NAME:$TRAVIS_COMMIT"
  - docker push "$AWS_URL/$LIVE_APP_NAME:latest"
  - chmod +x $TRAVIS_BUILD_DIR/server/ecs_deploy.sh
  - chmod +x $TRAVIS_BUILD_DIR/server/ecs.sh
  - $TRAVIS_BUILD_DIR/server/ecs.sh -c $LIVE_CLUSTER_NAME -n $LIVE_SERVICE -i "$AWS_URL/$LIVE_APP_NAME:latest" -r us-east-2 -t 240
```

* Note that two of the environment variables are marked secure, these were setup using the travis ci command line utility, you can also setup variables in the properties for a given repository.

# Connecting GitHub, GitHub Actions, and Docker

* When you start this process, you will need to create your Travis CI account, hopefully you utilized your existing GitHub credentials to make this happen.
* If so, then connecting your github account to Travis CI should be quite simple and straightforward.
* Though, it will require that you identify those repositories which will be monitored by travis. Once setup their is nothing left to do, but follow normal git operations and Travis will take care of everything else (assuming you have the files in the right place).
* To make Travis CI execute your docker builds, is simply a matter of adding in the docker service (see example above) and adding in the docker build and docker tag commands.
* If you want to push your image to DockerHub, you will need to add the DOCKER_USERNAME and DOCKER_PASSWORD environment variables to either the repository setting page on Travis-CI.com (ensuring that the values will not appear in the log) or using the travis-ci command line tool. For help on the latter, I would suggest googling "travis ci docker push"
* Once you have the environment variables setup, pushing to docker hub is as simple as adding the following to the "script" section (or another appropriate place):

```bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker tag tictactoe:latest grifisaa/ttt:latest
docker push grifisaa/ttt:1.0
```

# Connecting GitHub Actions, Docker, and AWS

* AWS has a large number of services that can easily overwhelm developers new to this world. But in reality we only need to work with about four major things:

  - ECR - Elastic Container Registry (similar to DockerHub)
  - ECS - Elastic Container Service
  - EC2 - Elastic Cloud Compute (only a portion)
  - Fargate

* With that in mind, you first need to create a new user on AWS. Once you have done that we will work to create an ECR repository, Set up some permissions, Setup our ECS Cluster, Setup Travis CI to push to ECR and deploy to the cluster and then we will setup the Fargate Service.

# Setting Up an IAM User

* Login to your AWS account as a root user. Then search for IAM
* Open up IAM, which should show you the IAM dashboard
* Select "Users" from the left menu, and then "Add User" from the top of the page
* On the Add user screen select a user name, it does not matter what it is just that it is memorable.
* Next, check "Programatic access" and "AWS Managment Console Access". leave everything else as default
* Next, we need to attach the ECS access policy.
  - Select "Attach existing policies directly" under the "Set permissions"
  - Search for "AmazonECS_FullAccess"
  - Select the checkbox next to the policy
* Next, we need to construct an ECR policy (as no existing one is provided)
  - Select "Create Policy" again
  - Under Services select "Elastic Container Registry"
  - Under Actions select "All Elastic Container Registry Actions (ecr:*)"
  - Under Resources select "specific" and "Add ARN". Here we will select the region, leave our account number and - select "Any" for the repository name
  - Click "Add"
  - Skip tags and select "Next: Review"
  - Provide a policy name, something like "ECR_FullAccess"
  - Select "Create Policy"
* Now attach the new policies to the IAM user
  - Be sure to refresh the policies using the refresh symbol
  - Then search for ECR_FullAccess and ECS_FullAccess selecting the checkbox next to each.
  - Once added, select "Next: Tags"
  - Then, select "Next: Review"
  - Review your work and create the user.
  - **Be sure to save all of the information displayed, as you will need it later for deploying your container**

# Create an ECR Registry

Now that we have permissions setup all we need to do is create the repository to which we will push our actual docker image.

* First we need to log in to the AWS console using the IAM user we just created.
* Once you have logged in as an IAM user, you need to open the "Elastic Container Registry"
* Once at the ECR dashboard, choose "Create Repository"
  - Here you need to provide a name for your repository, use whatever works for you.
  - Make the repository private
  - Leave everything else default
  - Next, select "Create Repository"
  - You should be brought back to a listing of repositories. **Copy the URI of the newly created repository for use later**

# Connecting GitHub Actions with ECR

* To make this work, we will need three pieces of information which will be added as environment variables in your repository settings on Travis CI
  - `AWS_URL`: The URI of you ECR Repository (without the name of the repository at the end)
  - `AWS_ACCESS_KEY_ID`: this can be found in the Users section under the IAM settings
  - `AWS_SECRET_ACCESS_KEY`: which can be shown in the same IAM settings (next to the ACCESS_KEY_ID)
  - `LIVE_APP_NAME`: name of the ECR Repository

* Once you have added that information, you can use it in the Travis-CI build to push to AWS ECR using the following commands

  ```bash
  docker build -t "$LIVE_APP_NAME:latest" .
  docker tag "$LIVE_APP_NAME:latest" "$AWS_URL/$LIVE_APP_NAME:$TRAVIS_COMMIT"
  docker tag "$LIVE_APP_NAME:latest" "$AWS_URL/$LIVE_APP_NAME:latest"
  docker push "$AWS_URL/$LIVE_APP_NAME:$TRAVIS_COMMIT"
  docker push "$AWS_URL/$LIVE_APP_NAME:latest"
  ```

* At this point, I would go ahead and test everything to make sure it is working.

# Create the Fargate Task

Now we simply need to setup the ECS cluster and connect it to our container in the repository.

* Return to the AWS console, and search for "ECS"
* Open up the ECS dashboard, and select "Clusters" from the left menu
* Select "Create Cluster"
* This will give you three choices, make sure "Networking Only" is selected. and then press "Next Step"
* Here you can configure the cluster
  - Give the cluster a good name, and note the name for later
  - The press the "Create" button
* Next, we need to create the ECS Task, which will deploy the container
  - In the ECS Dashboard, select "Task Definitions" from the left menu. Then select "Create New Task Definition"
  - Select the "Fargate" option and press "Next Step"
  - Enter a name for the task
  - Leave the "Task Role" and "Network Mode" set to the default values
  - Leave "Task Execution Role" set to its default
  - For task memory and task CPU select the minimum values (you can adjust them later if necessary)
  - Under Container definition select "Add Container"
    * Enter a container name
    * In the Image Box, enter the URI of your Image plus ":latest"
    * In Port Mappings add the default port number for you container (7000 for mine)
    * Leave everything else set to default values
    * Press the "Create" button
    * Return to the ECS Page, select "Task Definitions" and verify that the new task is set to "ACTIVE"

# Automated Deployment
