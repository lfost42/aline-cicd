#!/usr/bin/env groovy

def call() {
    timeout(time:5, unit: 'MINUTES') {
        input "Admin Confirm Terraform Apply"
        sh '''
            echo "Running Terraform apply..."
            cd aws/environments
            ./run develop aline-eks-app apply
        '''
        }
    }
}