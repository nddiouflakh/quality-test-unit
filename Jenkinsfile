pipeline {
    agent none
    stages {
        stage("build & SonarQube_server") {
            agent any
            tools {
                maven 'Maven 3.8.1' // Name of the Maven installation configured in Jenkins
            }
            steps {
                withSonarQubeEnv('SonarQube_server') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}

