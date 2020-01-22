#!/bin/zsh

KAFKA_PS=$(docker ps -a | awk '{ print $2 }' | grep kafka)
if [[ -z $KAFKA_PS ]]; then
  mvn docker:start
fi

return 0