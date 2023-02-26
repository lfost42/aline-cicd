#!/usr/bin/env groovy

def call() {
    echo "Running tflint..."
    sh '''
        cd aws
        ./lint
    '''
}