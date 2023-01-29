#!/usr/bin/env groovy
def call() {
    echo 'Updating lf-aline-ecs'
    def yaml = libraryResource 'docker-compose.yaml'
    writeFile file: "docker-compose.yaml", text: yaml
    def param = libraryResource 'parameters.sh'
    writeFile file 'parameters.sh', text: sh

    sh '''docker context use lf_ecs
    ./parameters.sh
    docker compose up
    docker context use default'''
}
