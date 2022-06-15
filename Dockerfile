FROM gradle:7.4.2-jdk18
MAINTAINER Hemil Turakhia
COPY . /usr/restassuredapiframework/app
WORKDIR /usr/restassuredapiframework/app
ENTRYPOINT gradle cucumber