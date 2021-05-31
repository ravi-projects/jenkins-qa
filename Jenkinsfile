pipeline {
	agent any
	
	stages {
		stage('Compile Stage') {
		
			steps {
				script {
                    bat(/"${mvnHome}\bin\mvn" -Dintegration-tests.skip=true clean package/)
				}
			}
		}
	}
}	