## Spring-boot, MySql, Hibernate

### CRUD User Rest Api Example

##### How to Hot-Reload server after any code change
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```
- Under IntelliJ IDE > go to Settings > Advance Settings > select (Allow auto-make to start even if application is currently running)
- Under IntelliJ IDE > go to Settings > Build, Execution, Deployment > Select (Build project automatically)

##### MySql connection setting in application.yaml file
- create an *application.yaml* under main > resources > *application.yaml
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/user?useSSL=false
    username: root
    password: MySql@123

#JPA setttings
  jpa.hibernate.ddl_auto: create
```
The value of url is = jdbc:mysql://localhost:3306/user?useSSL=false.
You can see *user* within url, that is the database name.



