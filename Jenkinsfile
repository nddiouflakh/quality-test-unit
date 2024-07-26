pipeline {
    agent none
    stages {
        stage("build & SonarQube_server") {
            agent any
            tools {
                maven 'Maven' // Name of the Maven installation configured in Jenkins
                //jdk 'JDK 11'
            }
            steps {
                withSonarQubeEnv('SonarQube_server') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
    }
}

