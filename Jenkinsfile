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
      sh "sudo docker images"
      sh "sudo docker build -t balajiabgs/employee-time-tracker:${env.BUILD_ID} ."
      sh "sudo docker tag balajiabgs/employee-time-tracker:${env.BUILD_ID} 10.0.2.15:8083/employee-time-tracker:latest"
      sh "sudo docker images"
      }
    }
     stage('Publishing'){
       steps{
        sh "sudo docker login -u admin -p admin123 10.0.2.15:8083"
        sh "sudo docker push 10.0.2.15:8083/employee-time-tracker:latest"
       }
     }
    
  }

  post {
    always {
      archive 'target/**/*.jar'
      junit 'target/**/*.xml'
    }
    
  }
}
