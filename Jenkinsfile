pipline{
  agent none
  stages{
    stage("build & SonarQube_server"){
      agent any
      steps{
        withSonarQubeEnv("SonarQube Scanner"){
          sh 'mvn clen package sonar:sonar'
        }
      }
    }
  }
}
