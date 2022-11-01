# Запуск

### Gradle
Сервис написан на Spring Boot с использованием Gradle:
1) Собрать исполняемый jar командой:
> ./gradlew bootJar

### Docker
> sudo docker build -t enovikow .

> sudo docker run -p 8080:8080 enovikow