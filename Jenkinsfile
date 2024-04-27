pipeline {
    agent any
    
     environment {
     PATH = "${env.PATH};C:\\Windows\\System32;C:\\Program Files\\apache-maven-3.9.6\\bin"
 }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pranjalwagh/mockExam.git'
            }
        }
        stage('Build') {
            steps {
                bat "mvn clean compile"
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
