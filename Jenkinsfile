pipeline {
    agent any

    tools {
           maven 'Maven_3.5.2'
    }

    stages{
        stage('Compile'){
            steps{
                  bat 'mvn clean compile'
            }
        }
        stage('Unit Testing'){
            steps{
                  bat 'mvn test'
            }
        }
        stage('Deploy App'){
            steps{
                  bat 'mvn deploy'
           }
        }
    }

}