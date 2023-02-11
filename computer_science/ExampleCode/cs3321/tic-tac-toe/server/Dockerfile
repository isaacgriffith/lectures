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

# expose the networking port
EXPOSE $PORT

# create the user so root is not running the app
RUN useradd -m appuser
USER appuser

# Setup the entrypoint
ENTRYPOINT ./server/bin/server