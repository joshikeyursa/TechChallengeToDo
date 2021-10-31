**Architecture Comparison**

For Architecture of this application following options were considered.

* API Gateway + Lambda functions in Python + DynamoDB
* Application Load Balancer + ECS backed by SpringBoot Microservices + RDS

Following are the advantages and disadvantages of each approach.
* API Gateway + Lambda functions in Python + DynamoDB
  * Greater elasticity
  * Real Pay as you go
  * Power of NoSQL
  * Unfortunately, transaction management not easy.
  

* ALB + ECS + RDS
  * Transaction Management
  * Rule-based routing to support multiple versions of API
  * Unfortunately, pay even when not in use. Though it can be tear down when no one using.


**Steps to configure Database on local machine** 