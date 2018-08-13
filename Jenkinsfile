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
		echo "Before MVN"
        sh ' mvn -f saving-account/pom.xml clean install'
		echo "`pwd`"
      }
    }
	stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t sdurgawad/demomaven:latest .'
      }
    }
	stage ('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
	  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
	  sh 'docker push sdurgawad/demomaven:latest'
        }
      }
	}
  }
}

