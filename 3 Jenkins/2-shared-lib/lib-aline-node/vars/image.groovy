#!/usr/bin/env groovy

def call() {
    echo 'pushing image to registry'
    docker.withRegistry('', registryCredential) {
        def dockerImage = docker.build registry + ":jenkins${GIT_COMMIT}"
        dockerImage.push()
    }
}