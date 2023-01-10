FROM ubuntu:20.04

ENV DEBIAN_FRONTEND noninteractive
USER root
RUN apt-get -y update \
&& apt-get -y upgrade
RUN apt-get -y install software-properties-common git sudo nano vim wget curl zip unzip build-essential libtool autoconf uuid-dev pkg-config libsodium-dev lynx-common tcl inetutils-ping net-tools ssh openssh-server openssh-client openssl letsencrypt apt-transport-https telnet locales gdebi lsb-release
RUN apt-get clean

EXPOSE 8080