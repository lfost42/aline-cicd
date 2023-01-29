#!/usr/bin/env groovy
def call() {
    echo 'Updating lf-aline-ecs'
    def yaml = libraryResource 'k8s/${config.imageName}.yaml'
    writeFile file: "values.yaml", text: yaml

    sh '''docker context use lf_ecs
    ./parameters.sh
    docker compose up
    docker context use default'''
}
