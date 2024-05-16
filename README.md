![example workflow](https://github.com/ykhadilkar/spring-mongo-rest/actions/workflows/maven.yml/badge.svg)

# Simple Spring Boot + MongoDB APIs
## Local Run
- Run Mongo DB in docker container and expose 27027 on localhost
- Start the app by running `./mvnw spring-boot:run`
- Access the app - localhost:8080/people
- Add sample data `curl -k -X POST -H 'Content-Type: application/json' localhost:8080/people -d '{"firstName": "Joe", "lastName": "Doe", "email":"jdoe@gmail.com"}'`

## Deploy on K8s
- Build the image `./mvnw spring-boot:build-image`
- Tag the image `docker tag docker.io/library/accessing-mongodb-data-rest-complete:0.0.1-SNAPSHOT ykhadilkar/spring-mongo`
- Push the image `docker push ykhadilkar/spring-mongo`
- Create secret using `k create secret generic spring-mongo-secret --from-file=./k8s/application.properties`
- Create deployment `k apply -f k8s/deployment.yaml`
- Expose using service `k apply -f k8s/service.yaml`
- Access the app at Service IP
