# nagp-services-middleware

## Introduction

The purpose of this project is to show the communication with grpc and push the messages to the respective queue

## Technologies
- Java
- Spring Boot
- RabbitMQ
- gRPC
### Installation

Step-by-step guide on how to install and configure your project:

1. Clone the repository: `git clone https://github.com/rohitsharma2522/nagp-services-middleware.git`
2. Navigate to the project directory: `cd nagp-services-middleware`
3. Run maven build, default goals are already defined in the pom.xml
4. Run spring boot application this will start sprint boot server, grpc server and will make connection with rabbitmq server
5. Navigate to rabbit mq dashboard and two queues will be generated
6. Import postman collection and run the place order API, this will push the data in both the queues and is consumed by rabbitmq listener
7. Now run update ORder API this will push the message only to queue2 using topicexchange
 