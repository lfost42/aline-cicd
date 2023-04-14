#!/usr/bin/env groovy

def call() {
    echo "Running terratests ..."
    sh '''
        cd aws/environments/test/aline_eks_app_test
        go test
    '''
}