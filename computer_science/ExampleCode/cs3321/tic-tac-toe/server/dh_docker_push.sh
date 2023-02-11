#!/bin/bash

echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker tag tictactoe:latest grifisaa/ttt:latest
docker push grifisaa/ttt:1.0