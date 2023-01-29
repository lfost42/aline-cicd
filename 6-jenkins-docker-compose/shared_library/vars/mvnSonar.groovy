#!/usr/bin/env groovy

def call() {
    echo "Executing pipeline for branch $BRANCH_NAME"
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
        sh "${mvn}/bin/mvn clean verify sonar:sonar"
    }
}
