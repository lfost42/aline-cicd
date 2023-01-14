FROM node:16-alpine as builder
LABEL Name="Dockerfile.admin" version="1.5"

WORKDIR /node_app
COPY ["package*.json", "/node_app/"]

RUN ["npm", "install", "-g", "npm@7.24.0"]
RUN ["apk", "add", "--update", "python3", "make", "g++"]
RUN ["rm", "-rf", "/var/cache/apk/*"]
RUN ["npm", "install", "--legacy-peer-deps"]

COPY [".", "/node_app"]
RUN ["npm", "run", "build"]


FROM nginx:mainline-alpine-slim
LABEL Name="Dockerfile.admin" version="1.5"
COPY --from=builder ["/node_app/build", "/usr/share/nginx/html"]
EXPOSE 80