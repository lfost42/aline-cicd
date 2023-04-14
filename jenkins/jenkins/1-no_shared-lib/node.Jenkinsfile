def gv
pipeline {
    agent any
    environment {
        registry = "lyndasm/aline-member"
        registryCredential = 'docker-login'
        tag = sh(returnStdout: true, script: "git rev-parse --short=10 HEAD").trim()
    }

    stages {
        stage('init') {
            steps {
                script {
                    echo 'loading groovy script'
                    gv = load "pipeline.groovy"
                }
            }
        }
        stage('sonarqube') {
            steps {
                script {
                    gv.sonarQube()
                }
            }
        }
        stage('quality gate') {
            steps {
                script {
                    gv.qualityGate()
                }
            }
        }
        stage('setup') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.setup()
                }
            }
        }
        stage('build app') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.build()
                }
            }
        }
        stage('push image') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.pushImage()
                }
            }
        }

    }
}