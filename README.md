# spring-boot-project-with-h2-db
Spring boot project with H2 memory database, performing create, delete, get and update operations. 
Handling spring boot way global exception handling and Swagger UI for Rest End points

# Access the H2 Database from Browser using below URL
http://localhost:2500/h2-console/login.jsp

# Access Swagger UI for testing Rest Url's
http://localhost:2500/swagger-ui.html

Underlaying server taken as Jetty in this project. If you want tomcat , comment the jetty dependency and remove tomcat exclusion tag from pom xml file.

# @ConfigurationProperties changes are added
Refer the changes in below files
EmployeeResource, ApplicationProperties and application yml file.

# EmployeeResourceIntTest class added for Mocking the Employee Resource Api's.

# if you want run specific test case method, use the below mvn command.
mvn test -Dtest=EmployeeResourceIntTest#getEmployee test

# if u want run all test cases with in the Test class, use the below mvn command.
mvn test -Dtest=EmployeeResourceIntTest test

# if u want run all the test classes, use the below mvn command.
mvn test or mvn clean install 

# skip all test cases using below command
mvn clean install -DskipTests=true
