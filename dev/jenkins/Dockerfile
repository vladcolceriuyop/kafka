FROM jenkins/jenkins:lts

USER root
RUN apt-get update -qq \
    && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"

ARG DOCKER_VERSION=5:19.03.8~3-0~debian-stretch

RUN apt-get update  -qq \
    && apt-get install docker-ce=$DOCKER_VERSION -y
RUN usermod -aG docker jenkins