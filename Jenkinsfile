#!groovy

pipeline {
  agent any 
  environment {
        IMAGE = "sdurgawad/saving-account"
        REGISTRY = "https://registry.hub.docker.com"
  }
  stages {
    stage('prep') {
      steps {
        script {
          env.GIT_HASH = sh(
              script: "git show --oneline | head -1 | cut -d' ' -f1",
              returnStdout: true
          ).trim()
        }
      }
    }
    stage('Maven Install') {
      agent {
        docker {
	  image 'maven:3.5.0'
	}
      }
      steps {
		echo "Before MVN !!!"
        sh 'mvn -f saving-account/pom.xml clean install'
      }
    }
    stage('Docker Build') {
      agent any
      steps {
       script {
         image = docker.build("${IMAGE}")
         println "Newly generated image, " + image.id
       }
        //sh 'docker build -t sdurgawad/saving-account:latest .'
      }
    }
    
    stage('Docker Push') {
            steps {
                script {
                    // https://hub.docker.com/r/tutum/hello-world/
                    def container = image.run('-p 8181')
                    def contport = container.port(8181)
                    println image.id + " container is running at host port, " + contport
                    // def resp = sh 'curl -w "%{http_code}" -o /dev/null -s http://\"${contport}\"/api/customers'
		    // println "Return code of curl, " + resp
                    if ( "000" == "000" ) {
                        println "saving-account is alive and kicking!"
                        docker.withRegistry("${env.REGISTRY}", 'dockerHub') {
                            image.push("${GIT_HASH}")
                            if ( "${env.BRANCH_NAME}" == "master" ) {
                                image.push("LATEST")
                            }
                        }
                        currentBuild.result = "SUCCESS"
                    } else {
                        println "Docker Build Failed."
                        currentBuild.result = "FAILURE"
                    }
                }
            }
    }

    /*
    stage ('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
	  sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
	  sh 'docker push sdurgawad/saving-account:latest'
        }
      }
    }
    */
  }
  post {
    always {
      cleanWs()
    }
  }
}

