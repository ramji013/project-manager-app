pipeline {
    agent any

    stages{
        stage('Compile'){
            steps{
                  sh 'mvn clean compile'
            }
        }
        stage('Unit Testing'){
            steps{
                  sh 'mvn test'
            }
        }
        stage('Deploy App'){
            steps{
                  sh 'mvn deploy'
            }
        }
    }

}