#!/usr/bin/env groovy

def call() {
    echo "Executing pipeline for branch $BRANCH_NAME"
    // def scannerHome = tool 'SonarScanner';
    //     withSonarQubeEnv() {
    //     sh "${tool("SonarScanner")}/bin/sonar-scanner \
    //     -Dsonar.projectKey=test-node-js \
    //     -Dsonar.typescript.node=./node/node \
    //     -Dsonar.sources=. \
    //     -Dsonar.css.node=."
    // }
}
