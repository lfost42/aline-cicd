def sonarQube() {
    echo "Executing pipeline for branch $BRANCH_NAME"
    echo "Running tests ..."
}

def qualityGate() {
    echo 'quality gate check'
}

def setup() {
    echo 'setting up application'
    sh 'git submodule deinit -f .'
    sh 'git submodule update --init --remote --merge'
}

def build() {
    echo 'building the application'
    sh 'mvn package -DskipTests=true'
}

def pushImage() {
    echo 'pushing image to registry'
    docker.withRegistry('', registryCredential) {
        def dockerImage = docker.build registry + ":jenkins${GIT_COMMIT}"
        dockerImage.push()
    }
}

return this