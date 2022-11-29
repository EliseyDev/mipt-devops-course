# Запуск

Сервис написан на Spring Boot с использованием Gradle:

### Запуск в minikube

```
minikube delete 
minikube start
kubectl config use-context minikube
```

```
kubectl create -f deployment.yaml
./gradlew clean build
docker build -t hw_04 .
kubectl expose deployment kube-boot --type=LoadBalancer --port=8080
minikube service kube-boot --url
```