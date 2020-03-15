pipeline {
  agent any

   stages {
    stage('Build') {
      steps {
        sh 'mvn package'
      }
    }
    
    stage('Make Container') {
      steps {
      sh "docker images"
      sh "docker build -t balajiabgs/employee-time-tracker:${env.BUILD_ID} ."
      sh "docker tag balajiabgs/employee-time-tracker:${env.BUILD_ID} 10.0.2.15:8083/employee-time-tracker:latest"
      sh "docker images"
      }
    }
    
  }

  post {
    always {
      archive 'target/**/*.jar'
      junit 'target/**/*.xml'
      cucumber '**/*.json'
    }
    success {
      withCredentials([usernamePassword(credentialsId: 'nexus', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "docker login -u ${USERNAME} -p ${PASSWORD} 10.0.2.15:8083"
        sh "docker push 10.0.2.15:8083/employee-time-tracker:latest"
      }
    }
  }
}
