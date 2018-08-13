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
        sh ' mvn -f saving-acount/pom.xml clean install'
		echo "`pwd`"
      }
    }
	stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t sdurgawad/demomaven:latest .'
      }
    }
  }
}

