#!/usr/bin/env groovy
def ecs() {
    echo 'Updating lf-aline-ecs'
    def yaml = libraryResource 'docker-compose.yaml'
    writeFile file: "docker-compose.yaml", text: yaml

    def parameters = libraryResource 'parameters.sh'
    writeFile file: 'parameters.sh', text: parameters

    sh '''docker context use lf_ecs
    ./parameters.sh
    docker compose up
    docker context use default'''
}

def eks() {
    echo 'Updating lf-aline-eks'
}

def dockercompose() {
    echo 'Deploy local docker compose'
}

def kubernetes() {
    echo 'Deploy local kubernetes'
}
