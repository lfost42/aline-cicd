#!/usr/bin/env groovy

def call() {
    sh 'git submodule deinit -f .'
    sh 'git submodule update --init --remote --merge'

    sh 'mvn package -DskipTests=true'

    // to copy artifacts when build succeeds to enable rollbacks
    // copyArtifacts filter: '**', fingerprintArtifacts: true, projectName: $JOB_NAME, selector: specific('$build_number')
}
