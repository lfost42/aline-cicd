#!/usr/bin/env groovy

def call() {
    echo 'pushing image to registry'
    docker.withRegistry('', registryCredential) {
        def dockerImage = docker.build registry + ":AWS-${GIT_COMMIT}"
        sh "Tagged ${dockerImage}"
        dockerImage.push()
    }
}