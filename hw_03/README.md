# Запуск

### Gradle

Сервис написан на Spring Boot с использованием Gradle:

1) Собрать исполняемый jar командой:

> ./gradlew bootJar

### Docker

    pipeline {
        agent any
        tools {
            gradle '7.6'
    }

    stages {
        stage('Clone Project') {
            steps {
                git url: "https://github.com/EliseyDev/mipt-devops-course.git", branch: "hw_03"
            }
        }
        stage('Gradle Init') {
            steps {
                dir('hw_03') {
                  sh 'gradle init' 
                  sh 'gradle clean'
                /*  sh 'ls -a'*/
                }
            }
        }
        
        stage('Gradle Test') {
            steps {
                dir('hw_03') {
                  sh 'gradle test'
                }
            }
        }
        
        stage('Gradle Sonar') {
            steps {
                dir('hw_03') {
                  sh 'gradle sonarqube'
                }
            }
        }
        
        stage('Gradle Build') {
            steps {
                 dir('hw_03') {
                  sh 'gradle build'
                }
            }
        }
        
        stage('Deploy') {
            steps {
              sh 'docker compose up -d'
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
