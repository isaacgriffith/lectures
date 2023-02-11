---
author:
- Dr. Isaac Griffith
title: GitHub Actions, Docker, DockerHub, ECR
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# The Gist

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/github_actions/flow.png}

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Use GitHub Actions to
  * Automate the Build
  * Automate Creating your Docker Image
  * Automate Deploying your Docker Image to:
    * DockerHub
    * AWS ECR
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
\begin{minipage}{.775\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge GitHub Actions $\to$ DockerHub
\end{center}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# GHA $\to$ DockerHub

* **Initial Steps**
  1. Add your Docker ID as a secret to GitHub
     * Navigate to your GitHub repository and click **Settings > Secrets > New Secret**
     * Create a new secret with the name `DOCKER_HUB_USERNAME` and your Docker ID as the value

  \vskip.5em

  2. Create a new Personal Access Token (PAT) on Docker Hub
     * Navigate to Docker Hub Settings and click **New Access Token**
     * Give the token a name
     * Copy the token text

# GHA $\to$ DockerHub

* **Initial Steps Continued**

  3. Add your Docker PAT as a secret to GitHub
     * Navigate to your GitHub repository and click **Settings > Secrets > New Secret**
     * Create a new secret with the name `DOCKER_HUB_ACCESS_TOKEN` and your new PAT as the value

# GHA $\to$ DockerHub

* \scriptsize\ **Setup the GitHub Actions Workflow**
  * \tiny Create a new workflow file: "`.github/workflows/push_dockerhub.yml`"

\vspace{-1em}

::: columns
:::: {.column width=.4}

\tiny

```yaml
name: Push to Docker Hub
on:
  push:
    branches:
      - 'main'

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v2

      - name: Setup JDK 17
        uses: actions/setup-java@v2
        with:
          java-version: '17'
          distribution: 'adopt'

      - name: Validate Gradle Wrapper
        uses: gradle/wrapper-validation-action@
e6e38bacfdf1a337459f332974bb2327a31aaf4b
```

::::
:::: {.column width=.6}

\tiny

```yaml
      - name: Gradle Build
        run: ./gradlew package

      - name: Login to Docker Hub
        uses: docker/login-action@v1
        with:
          username: ${{ secrets.DOCKER_HUB_USERNAME }}
          password: ${{ secrets.DOCKER_HUB_ACCESS_TOKEN }}

      - name: Set Up Docker Buildx
        uses: docker/setup-buildx-action@v1

      - name: Docker Build and Push
        uses: docker/build-push-action@v2
        with:
          context: .
          file: ./Dockerfile
          push: true
          tags: ${{ secrets.DOCKER_HUB_USERNAME }}/project:latest




```

::::
:::

# GHA $\to$ DockerHub

* Push your changes

\vskip.5em

* Using the GitHub Actions web interface
  * Test your workflow
  * Tweak the workflow until it completely works

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge GitHub Actions $\to$ AWS ECR
\end{center}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# GHA $\to$ AWS ECR

* **Creating an ECR**
  1. Login in to the AWS Management App

  \vskip.5em

  2. Navigate to the Elastic Container Registry

  \vskip.5em

  3. Create a new Repository
     * Choose visibility as Private and give the repo a **Name**
     * Click create repository

# GHA $\to$ AWS ECR

* **Creating an ECR**

  4. Navigate to the AWS IAM Feature, then click **Add Role**
     * Provide a new User Name: **Github-Action-AWS-CLI-Allow-ECR** and check **Programmatic Access** which will allow the creation of a key pair.
     * Click Next: Permissions and on the next screen choose "Attach existing policies directly".
     * In find policies search for "**AmazonEC2ContainerRegistryFullAccess" and check it
     * Click on **Next: Tags** skip and click on **Next: Review** and confirm **Create User**

  \vskip.5em

  5. Once create, you need to save the Credentials File and Copy the "**Access Key ID**" and "**Secret Access Key**"

# GHA $\to$ AWS ECR

* **Connecting GHA with AWS ECR**
  1. Open your repository secret settings on GitHub (Click **Settings > Secrets**)

  \vskip.5em

  2. Create the following secrets with the given values
     * Add **REPO_NAME** with the value of your ECR repo name
     * Add **AWS_ACCESS_KEY_ID** with the value of the AWS Access Key ID copied previously
     * Add **AWS_SECRET_ACCESS_KEY** with the value of the AWS Secret Access Key copied previously
     * **Note:** You can use the saved credentials file for these values


# GHA $\to$ AWS ECR

* \scriptsize\ **Setup the GitHub Actions Workflow**
  * \tiny Create a new workflow file: "`.github/workflows/push_ecr.yml`"

\vspace{-2em}

::: columns
:::: {.column width=.4}
\tiny

```yaml
name: Push to AWS ECR
on:
  push:
    branches:
      - 'main'

jobs:
  deploy:
    name: Deploy to AWS ECR
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v2
      - name: Setup JDK 17
        uses: actions/setup-java@v2
        with:
          java-version: '17'
          distribution: 'adopt'
      - name: Validate Gradle Wrapper
        uses: gradle/wrapper-validation-action@
      e6e38bacfdf1a337459f332974bb2327a31aaf4b
      - name: Gradle Build
        run: ./gradlew package
```

::::
:::: {.column width=.6}

\tiny

```yaml
- name: Configure AWS Credentials
  uses: aws-actions/configure-aws-credentials@v1
  with:
    aws-access-key-id:
      ${{ secrets.AWS_ACCESS_KEY_ID }}
    aws-secret-access-eky:
      ${{ secrets.AWS_SECRET_ACCESS_KEY }}
    aws-region: us-west-2
- name: Login to Amazon ECR
  id: login-ecr
  uses: aws-actions/amazon-ecr-login@v1
- name: Build, tag, and push the image to Amazon ECR
  id: build-image
  env:
    ECR_REGISTRY: ${{ steps.login-ecr.outputs.registry }}
    ECR_REPOSITORY: ${{ secrets.REPO_NAME }}
    IMAGE_TAG: 1.0
  run: |
    # Build a docker container and push it to ECR
    docker build -t $ECR_REGISTRY/$ECR_REPOSITORY:$IMAGE_TAG .
    echo "Pushing image to ECR..."
    docker push $ECR_REGISTRY/$ECR_REPOSITORY:$IMAGE_TAG
    echo "::set-output name=image::$ECR_REGISTRY/$ECR_REPOSITORY:$IMAGE_TAG"
```

::::
:::

# GHA $\to$ DockerHub

* Push your changes

\vskip.5em

* Using the GitHub Actions web interface
  * Test your workflow
  * Tweak the workflow until it completely works

\vskip.5em

* Finally, setup a AWS Fargate Node and connect it to the ECR repository.

# For Next Time

::: columns
:::: column

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
