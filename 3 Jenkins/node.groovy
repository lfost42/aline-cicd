def sonarQube() {
    echo "Executing pipeline for branch $BRANCH_NAME"
    echo "Running tests ..."
}

def qualityGate() {
    echo 'quality gate check'
}

def setup() {
    echo 'setting up application'
    sh 'sudo npm install --legacy-peer-deps'
    sh 'sudo npm install -g @craco/craco'
    sh 'npx browserslist@latest --update-db'
}

def build() {
    echo 'building the application'
    sh 'npm run build'
}

def pushImage() {
    echo 'pushing image to registry'
    docker.withRegistry('', registryCredential) {
        def dockerImage = docker.build registry + ":jenkins${GIT_COMMIT}"
        dockerImage.push()
    }
}

return this