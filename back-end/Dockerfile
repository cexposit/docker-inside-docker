# Base image
from debian:buster-slim
#FROM openjdk:17-oracle
#FROM openjdk:11-jre-slim 
#FROM openjdk:17-alpine
#FROM docker:dind

LABEL maintainer="info@kaizten.com"

ENV DEBIAN_FRONTEND=noninteractive

#VOLUME /tmp

RUN mkdir -p /usr/share/man/man1 /usr/share/man/man2

# Install Docker
#RUN apk update
#RUN apk add docker 
#RUN apk add --update docker openrc
#RUN rc-update add docker boot
#RUN apk add rsyslog

RUN apt-get update && \
apt-get install -y --no-install-recommends \
        openjdk-11-jre

RUN java --version        

RUN apt-get update && \
apt-get -y install apt-transport-https \
     ca-certificates \
     curl \
     gnupg2 \
     software-properties-common && \
curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg > /tmp/dkey; apt-key add /tmp/dkey && \
add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
   $(lsb_release -cs) \
   stable" && \
apt-get update && \
apt-get -y install docker-ce

# Copy JAR
COPY target/kaizten-task-0.0.1-SNAPSHOT.jar app.jar

# Execution
#ENTRYPOINT ["entrypoint.sh"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]