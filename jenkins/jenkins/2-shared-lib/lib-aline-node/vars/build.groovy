#!/usr/bin/env groovy

def call() {
    echo 'building the application'
    sh 'npx browserslist@latest --update-db'
    sh 'npm run build'
    // copyArtifacts filter: '**', fingerprintArtifacts: true, projectName: $JOB_NAME, selector: specific('$build_number')
}
