# RestAssuredTestNGFramework
REST Assured API test automation framework using Java + Maven + TestNG.

Technologies/Tools used in building the framework
=================================================
- Rest Assured
- TestNG
- Java
- Allure Reports
- Hamcrest
- Jackson API
- Lombok
- IntelliJ
- DataFaker


Framework implements
=========================================
- Reusable Rest Assured specifications
- Reusable Rest Assured API requests
- Separation of API layer from test layer
- POJOs for Serialization and Deserialization
- Lombok for reducing Boilerplate code
- Builder pattern for Setter methods in POJOs
- Robust reporting and logging using Allure
- Automated access token renewal
- Maven command line execution

#   RUN PROJECT GUIDE

  =========================================
- Maven command: 
`mvn clean test`
- View report: `allure serve target/allure-results`