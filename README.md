# Student service
## Description
Console application for managing students. There are 2 possible user roles: admin and referent. Admin can view, add and delete referents, while referent can view, update and delete students as well as enroll new students and advance existing ones.

## Test data
Database has test data to work with. Credentials for users are:

username: [role][1-10]

password: #Intel1#

### How to run
Configure database connection in `application.properties` file then run console app with maven command `mvn spring-boot:run`.

### Technologies
- Java 19
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Passay library v1.6.6](https://www.passay.org/) for password validation
- [Postgresql database](https://www.postgresql.org/)

### Author
* Nemanja Jevtić [GitHub](https://github.com/njevtic22)
