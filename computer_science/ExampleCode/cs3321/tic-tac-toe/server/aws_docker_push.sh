#!/bin/bash

docker --version
pip install --user awscli
export PATH=$PATH:$HOME/.local/bin
eval $(aws ecr get-login --no-include-email --region us-east-2)
docker build -t "$LIVE_APP_NAME:latest" .
docker tag "$LIVE_APP_NAME:latest" "$AWS_URL/$LIVE_APP_NAME:$TRAVIS_COMMIT"
docker tag "$LIVE_APP_NAME:latest" "$AWS_URL/$LIVE_APP_NAME:latest"
docker push "$AWS_URL/$LIVE_APP_NAME:$TRAVIS_COMMIT"
docker push "$AWS_URL/$LIVE_APP_NAME:latest"
chmod +x $TRAVIS_BUILD_DIR/server/ecs_deploy.sh
chmod +x $TRAVIS_BUILD_DIR/server/ecs.sh
$TRAVIS_BUILD_DIR/server/ecs.sh -c $LIVE_CLUSTER_NAME -n $LIVE_SERVICE -i "$AWS_URL/$LIVE_APP_NAME:latest" -r us-east-2 -t 240