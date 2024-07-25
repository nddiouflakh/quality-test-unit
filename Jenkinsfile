pipline{
  agent none
  stages{
    stage("build & SonarQube Scanner"){
      agent any
      steps{
        withSonarQubeEnv("SonarQube Scanner"){
          sh 'mvn clen package sonar:sonar'
        }
      }
    }
  }
}
