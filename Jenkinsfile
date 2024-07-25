pipeline {
    agent none
    stages {
        stage("build & SonarQube_server") {
            agent any
            steps {
                withSonarQubeEnv('SonarQube_server') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}
