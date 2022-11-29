# Запуск

### Gradle

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
                  sh 'ls -a'
                  sh 'gradle build'
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                  dir('hw_03') {
                    /* sh 'docker build -t hw_03 .' */
                    script{
                    docker.build("hw-01-spring-boot")
                  }
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

