pipeline {
    agent any

    stages{
        stage('Compile'){
            steps{
                withMaven(maven: 'maven_home'){
                  sh 'mvn clean compile'
                }
            }
        }
        stage('Unit Testing'){
            steps{
                withMaven(maven: 'maven_home'){
                  sh 'mvn test'
                }
            }
        }
        stage('Deploy App'){
            steps{
                withMaven(maven: 'maven_home'){
                  sh 'mvn deploy'
                }
           }
        }
    }

}