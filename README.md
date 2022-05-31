# spring-boot-microservice
spring boot microservice application with spring cloud

Department Service:
1. curl -v http://localhost:9001/department
2. curl -X POST localhost:9001/department/ -H 'Content-type:application/json' -d '{"departmentName": "IT", "departmentAddress": "25th cross street", "departmentCode": "IT-005"}'

Ribbon Client: This will use the department service internally.
1. curl -v localhost:9000/department
2. curl -v http://localhost:9000/department/port
3. curl -X POST localhost:9000/department/ -H 'Content-type:application/json' -d '{"departmentName": "ITI", "departmentAddress": "26th cross street", "departmentCode": "IT-006"}'

User Service:
1. curl -X POST localhost:9101/user/ -H 'Content-type:application/json' -d '{"firstName": "Malyadri", "lastName": "Patiban", "email": "malya@gmail.com", "departmentId": "1"}'
2. curl -v http://localhost:9101/user/1

Note: After using spring boot 2.3.7, its working all features.

Eureka server:
    Using 9000 is the port instead of using default 8761

Config Server:
    Default port is 8888 but we are using 9080 port for testing it.

Gateway Service:
1. curl -v localhost:9090/department -> this request will go to department service
2. curl -v localhost:9090/user -> this request will go to user service

ZUUL Proxy:
1. curl -v http://localhost:9090/department-service/department -> http://department-service/department
2. curl -v http://localhost:9090/department-service/department/port -> http://department-service/department/port
3. Here department-service path will be removed and forword the request to department service.
4. For user service, we customized the path with user-api. define under path tag of the service
5. curl -v http://localhost:9190/user-api/user/1
6. To get all routing info use the url, http://localhost:9190/actuator/routes


Sleuth & Zipkin:
1. download and run zipkin:
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
    java -jar zipkin.jar
2. add sleuth & zipkin dependencies

Admin Server:
    http://localhost:9494/applications
    This will register all application and you can track all application status and health in single place.

user will fetch department from user service based on userId.
Internally it will use rest template and invoke the url: http://localhost:9001/departments/%d
