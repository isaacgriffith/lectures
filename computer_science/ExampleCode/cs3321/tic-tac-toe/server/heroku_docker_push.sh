#!/bin/bash

docker login --username=_ --password=$(heroku auth:token) registry.heroku.com
docker tag tictactoe registry.heroku.com/grifisaa-tictactoe/web
docker push registry.heroku.com/grifisaa-tictactoe/web

heroku container:release web