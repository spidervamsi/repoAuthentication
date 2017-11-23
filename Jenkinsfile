pipeline {
	agent any
	stages {
   	stage('test'){
			steps {
			    echo 'hey im test'
			    sh 'mvn test'
			    sh 'mvn clean package'
			}
		}

              }
   	post {
   	  	always {
		 
                  echo 'hey I am here'
			}
		}

}
