pipeline {
  agent any

   stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    
    stage('Make Container') {
      steps {
      sh "docker images"
      sh "docker build -t balajiabgs/employee-time-tracker:${env.BUILD_ID} ."
      sh "docker tag balajiabgs/employee-time-tracker:${env.BUILD_ID} 51.136.161.68:5000/employee-time-tracker:${env.BUILD_ID}"
      sh "docker images"
      }
    }
     stage('Publishing'){
       steps{
        sh "docker login -u admin -p admin123 51.136.161.68:5000"
        sh "docker push 51.136.161.68:5000/employee-time-tracker:${env.BUILD_ID}"
       }
     }
     stage('cleanup'){
      steps{
        sh "docker rmi -f 51.136.161.68:5000/employee-time-tracker:${env.BUILD_ID}"
        sh "docker rmi -f balajiabgs/employee-time-tracker:${env.BUILD_ID}"
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
