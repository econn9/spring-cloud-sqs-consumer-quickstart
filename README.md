# spring-cloud-sqs-consumer-quickstart

This project is meant to be cloned and used as a scaffolding or quick start project for those interested in boiler plate microservice code for reading events off of an SQS queue in Java.   

---

## Setup

#### You will need:
- AWS Credentials (secret key ID and key)
- Java 8
- A running SQS queue instance 

## Steps
- replace the queue name value in the @SqsListener annotation
- set the values you expect to serialize in the EventDto pojo
- set the region in the application-local.yml
- set AWS credentials in the application-local.yml

## Running the project
`./gradlew clean bootRun -Dspring.profiles.active=local`


