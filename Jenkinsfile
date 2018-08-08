pipeline {
    agent any
    stages {
        
        stage('Clone sources') {
            steps{
                git url: 'https://github.com/webskey/Websocket-Chat.git'
            }
        }
        
        stage('Build') { 
            steps {
                bat 'mvn package -Dmaven.test.skip=true' 
            }
        } 
        
        stage('Run') {
        	steps {
        		bat 'java -jar target/WebsocketChat-0.0.1-SNAPSHOT.war'
        	}
        }
        
        stage('Test') { 
            steps {
                bat 'mvn test' 
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/*.xml' 
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}