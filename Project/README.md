# SMUX OOP G1T2

## Dependencies

* MySQL Server
* Java JDK 14

## Setting Up MySQL Server

1. Load `deploy.sql` found in sql folder.

## Packaging Project

1. Open terminal and navigate to the root directory of the project (mvnw should be in the current directory)
2. Enter `./mvnw clean` into the terminal to remove existing compiled classes
3. Enter `./mvnw package` into the terminal to package the project.
4. Enter `cd target` into the terminal to navigate to the target folder. In the folder, it consists of the following:
    * classes folder (contains all classes and thymeleaf templates)
    * maven-status folder (txt files that reports all created files and input files)
    * surefire-reports folder (contains report on step 3 of packaging)
    * maven-archiver folder (contains pom.properties which is used by maven to package)
    * jar file (this jar file is the packaged project)

## Running the Project

1. Open terminal and navigate to the directory that contains the jar file.
2. Enter `mkdir config` into the terminal to create a config folder
3. Create a properties file inside the config (i.e. external.properties)
4. This properties file should have the following content:
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/smuxoop?serverTimezone=Singapore
spring.datasource.username=oop
spring.datasource.password=asd123

mail.smtp.host=smtp.gmail.com
mail.smtp.user=g1t2smuxoop@gmail.com
mail.smtp.password=g1t2SMUXoop
mail.smtp.port=587

server.port=8080
ip.address=127.0.0.1

system.config.emailDomains=gmail.com, yahoo.com, smu.edu.sg
cron.retrieve.today=0 0 * * * ?
cron.retrieve.week=0 0 0 * * ?

api.key=<api-key>
```
    
Instructions for properties file
* values for `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password` should match the credentials of MySQL server and the schema to be used for the deployment.
* Value for `system.config.emailDomains` must be valid email domains and separated by comma. `system.config.emailDomains` defines the allowed email users of the system.
* Values for `cron.retrieve.today` and `cron.retrieve.week` should be valid cron expressions. `cron.retrieve.today` and `cron.retrieve.week` defines the interval of pulling data from the API for hourly and daily pulls respectively.
* Value for `api.key` corresponds to the Web Service Access Key that can be configured.
* Value for `mail.smtp.host`, `mail.smtp.password`, `mail.smtp.port`, `mail.smtp.host` corresponds to the mail credentials
* Value for `ip.address` corresponds to the IP Address of the server

5. Enter the following code to run the application locally. Ensure that the jar file and external.properties match the file that was created.

```bash
java -jar springmvc-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.properties,config/external.properties
```
