pipeline {
    agent none
    stages {
        stage("build & SonarQube_server") {
            agent any
            steps {
                withSonarQubeEnv('SonarQube Scanner') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}
