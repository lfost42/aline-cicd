def setup() {
    echo "setting up application"
}

def build() {
    echo "building the application"
    sh 'python example.py'
}

def buildImage() {
    echo "building docker image"
    withCredentials([UsernamePassword(credentialsId: 'docker-UNPW', passwordVariable: 'PASS', UsernameVariable: 'USER')]) {
        sh 'docker build -t lyndasm/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push lyndasm/demo-app:jma-2.0'
    }
}

def deploy() {
    echo "deploying the application"
}

return this