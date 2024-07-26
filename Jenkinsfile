pipeline {
    agent none
    stages {
        stage("build") {
            agent any
            tools {
                maven 'Maven' // Name of the Maven installation configured in Jenkins
            }
            steps {
                sh 'mvn clean package'
            }
        }
        stage("test") {
            agent any
            tools {
                maven 'Maven'
            }
            steps {
                sh 'Maven test'
            }
        }
        stage("SonarQube analysis") {
            agent any
            tools {
                maven 'Maven'
            }
            steps {
                withSonarQubeEnv('SonarQube_server') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}
