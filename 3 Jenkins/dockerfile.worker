FROM jenkins/ssh-agent:jdk11
USER root
RUN set -eux && \
    apt-get update && \
    apt-get install -y docker.io docker-compose --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*
RUN docker --version
USER jenkins