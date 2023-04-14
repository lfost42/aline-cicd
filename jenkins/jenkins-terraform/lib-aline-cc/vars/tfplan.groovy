#!/usr/bin/env groovy

def call() {
    echo "Running terraform init ..."
    sh '''cd aws/environments
    cp $ALINE_TFVARS develop/aline-eks-app/
    ./run develop aline-eks-app init'''

    echo "Running terraform plan..."
    sh'''
        cd aws/environments
        ./run develop aline-eks-app plan
    '''
}