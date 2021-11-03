# TechChallengeApp >> ToDo

### Quick Start
This application is divided into 3 parts
* **FE Components**: */ui* folder contains the source code for frontend part
* **BE Components**:  */src* folder contains the backend or microservice that deals with managing data
  * To run this component standalone.
    * Go to */src* folder set appropriate value of AWS secret, key and region values by running folowing command
    * ```
      aws configure
      ```
      and follow the instructions on screen.
    * Once appropriate AWS environment is setup, run following command to build and run SpringBoot microservice.
    * ```
      mvn clean test package
      java -jar -Dspring.profiles.active=<profile-name> <appropriatte jar name>
* **Infra Components**: */infra* folder contains cloud formation templates that will create required infrastructure to 
  * To build required infrastructure on AWS run following commands
  * ```
    aws cloudformation deploy --stack-name tasktracker-ecs-infra --template-file infra/onetime-ecs-infra.yaml #It will create basic components for ECS like ECS-Cluster and ECR repository where docker image for MS (If we decided to deploy FE as docker image on http server same would be uploaded here) will be uploaded and deployed. 
    aws cloudformation deploy --stack-name tasktracker-network-infra --template-file infra/onetime-network-infra.yaml #It will creaet basic n/w components like VPC, Subnets, IGW, Routetable etc.
    aws cloudformation deploy --capabilities CAPABILITY_NAMED_IAM --stack-name tasktracker-roles-infra --template-file infra/onetime-role-infra.yaml #It will create Roles required for EC2 machine to use ECS as service.
    aws cloudformation deploy --stack-name tasktracker-compute-infra --template-file infra/onetime-compute-infra.yaml #It will create basic compute components like ASG, TG, ALB, Listeners etc that will be used for ECS cluster/Task and service.
    ```
### Approaches Considered 

Following approaches were considered for building this application
* FE to be hosted in Angular/ReactJS deployed in public S3 bucket. Backend consist of API Gateway, Lambda functions and DynamoDB as a persistence layer (Deployment of Lambda functions via SAM cli)
  * Most reliant and cost-effective option if load is inconsistent/unpredictable
  * Downside is
      * Lack of skill-set available (One-person team)<br/><br/>
* FE to be hosted in Angular/ReactJS deployed in public S3 bucket. Backend consist of ALB, ECS and RDS as persistence layer. <br/><br/>   
* FE to be hosted in Angular/ReactJS deployed in public S3 bucket. Backend consist of ALB, ECS and RDS as persistence layer.
  * If load is consistent and predictable this option worth considering as 
    * Existing skill-set available within the team.
    * Cost can be optimized by implementing correct start up and shut down mechanism.
  