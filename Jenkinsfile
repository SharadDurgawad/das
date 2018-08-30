#!groovy

pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
	  image 'maven:3.5.0'
	}
      }
      steps {
		echo "Before MVN !!!"
        sh 'mvn -f saving-account/pom.xml clean install sonar:sonar -Dsonar.host.url=http://192.168.68.173:9000/ -Dsonar.login=admin -Dsonar.password=admin -X'
		echo "`pwd`"
      }
    }
	stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t sdurgawad/saving-account:latest .'
      }
    }
	stage ('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
	  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
	  sh 'docker push sdurgawad/saving-account:latest'
        }
      }
	}
  }
}

