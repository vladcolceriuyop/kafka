pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
                sh '''
                    RANDOM=$(shuf -i 0-10 -n 1)
                    if [ $RANDOM -lt 2 ]; then
                        exit 1
                    fi
                '''
            }
        }
    }
    post{
        always{
            echo 'This will always run'
        }
        success{
            echo 'This will run only if successful'
        }
        failure{
            echo 'This will run only if failed'
        }
        unstable{
            echo 'This will run only if the run was marked as unstable'
        }
        changed{
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}