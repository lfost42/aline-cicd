#!/usr/bin/env groovy

def call() {
    echo 'pushing image to registry'
    sh 'docker context use default'
    // docker.withRegistry ("https://${REGISTRY}", "ecr:${W1_AWS_REGION}:${AWS_ID}") {
    //     sh "aws ecr describe-repositories --region ${W1_AWS_REGION} --repository-names ${APP_NAME} || aws ecr create-repository --region ${W1_AWS_REGION} --repository-name ${APP_NAME}"
    //     app = docker.build "${REPO}"
    //     app.push(GIT_COMMIT)
    //     app.push('latest')
    // }
}