#!/usr/bin/env groovy
def ecs() {
    echo 'updating lf-aline-dc'
    docker.withRegistry ("https://${REGISTRY}", "ecr:${AWS_REGION}:${AWS_ID}") {
        def yaml = libraryResource 'docker-compose.yaml'
        writeFile file: "docker-compose.yaml", text: yaml

        sh '''
        for name in "APP_VPC" "APP_LB" "LOAD_BALANCER" "DB_USERNAME" "DB_HOST" "DB_PORT" "DB_NAME" "ACCOUNT_PORT" "BANK_PORT" "CARD_PORT" "GATEWAY_PORT" "TRANSACTION_PORT" "UNDERWRITER_PORT" "USER_PORT"
        do
            value=$(aws ssm get-parameters --names $name --region ${AWS_REGION} --query Parameters[0].Value --output text)
            echo "$name=$value" >> .env_ecs
        done

        docker context create ecs lf_ecs --from-env
        docker context use lf_ecs

        docker compose -p "lf-aline-dc" --env-file .env_ecs up

        docker context use default
        docker context delete lf_ecs
        '''
    }
}

def eks() {
    echo 'updating lf-aline-eks'
    withKubeConfig([credentialsId: 'lf-kubeconfig']) {
        def yaml = libraryResource "${TYPE}-${SUBNET}-deployment.yaml"
        writeFile file: "deployment.yaml", text: yaml
        sh '''envsubst < deployment.yaml | kubectl apply -f -'''
    }
}

def dockercompose() {
    echo 'Deploy local docker compose'
}

def kubernetes() {
    echo 'Deploy local kubernetes'
}
