#!/usr/bin/env groovy

def call() {
    echo 'pushing image to registry'
    // sh 'docker context use default'
    // docker.withRegistry ("https://"${REGISTRY}, "ecr:${W1_AWS_REGION}:${AWS_ID}") {
    //     def dockerImage = docker.build "${REPO}:AWS"
    //     sh "aws ecr describe-repositories --repository-names ${APP_NAME} || aws ecr create-repository --repository-name ${APP_NAME}"
    //     dockerImage.push()
    // }
}