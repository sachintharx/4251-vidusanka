
pipeline {
  agent any
  triggers{
    githubPush()
  }
  stages {
    stage('Docker Build'){
      steps {
        sh 'docker build -t vidusanka/hashar4251 .'
      }
    }
    stage('Docker Run'){
      steps{
        sh 'docker run -d -p 5000:3000 vidusanka/hashar4251'
      }
    }
    stage('Final'){
      steps{
        sh 'docker ps'
      }
    }
    stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }
}