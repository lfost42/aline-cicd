def setup() {
    echo 'setting up application'
}

def build() {
    echo 'building the application'
    
}

def buildImage() {
    echo 'building docker image'
    dockerImage = docker.build registry + ":$GIT_COMMIT_HASH"
    echo 'image built'
    }

def pushImage() {
    echo 'pushing image to registry'
    withCredentials([UsernamePassword(credentialsId: registryCredential, PasswordVariable: 'PASS', UsernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push " + dockerImage
    }
}

return this