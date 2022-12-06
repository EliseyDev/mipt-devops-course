# Запуск

Сервис написан на Spring Boot с использованием Gradle:

### Jenkins pipeline
pipeline {
agent any
tools {
gradle '7.6'
dockerTool 'docker'
}

    stages {
        stage('Clone Project') {
            steps {
                git url: "https://github.com/EliseyDev/mipt-devops-course.git", branch: "hw_05"
                 dir('hw_05') {
                  sh 'gradle init' 
                  sh 'gradle clean'
                }
            }
        }

        stage('Sonar Check') {
            steps {
                dir('hw_05') {
                  sh 'gradle sonarqube'
                }
            }
        }
        
        stage('Build') {
            steps {
                 dir('hw_05') {
                  sh 'gradle build'
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                  dir('hw_05') {
                    script{
                    docker.build("hw-05-spring-boot")
                  }
                }
            }
        }
            
        stage('Deploy Dev') {
            steps {
                  dir('hw_05') {
                    sh 'docker run --name hw_05_dev -d -p "8081:8080" hw-05-spring-boot';

                  }
            }
        }
                    
        stage('Run Tests') {
            steps {
                dir('hw_05') {
                  sh 'gradle test'
                }
            }
        }
        
         stage('Deploy Prod') {
            steps {
                  dir('hw_05') {
                      sh 'docker run --name hw_05_prod -d -p "8082:8080" hw-05-spring-boot';
                }
            }
        
        }
        
    }
    post {
        always {
            archiveArtifacts artifacts: "*.json", fingerprint: true, allowEmptyArchive: true
            deleteDir()
        }
    }

    }
