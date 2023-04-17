# WebsiteStatusCheck-Angular-Spring
Fetch new data every minute to check Website Status using Angular and Spring Boot

Client (Angular)
================
- Download/Clone Client folder
- Open folder in Visual Studio Code and cd to Client folder
- Install node and npm
- npm install -g @angular/cli
- ng serve -o
- Browser opens on http://localhost:4200

Server (Java/Spring Boot)
=========================
- Download/Clone Server folder
- Install JDK, Maven and set environemt variables
- Navigate to project directory
- mvn install / mvn clean install
- mvn spring-boot:run
- Tomcat starts on http://localhost:8080
- Check output on browser for below endpoints
http://localhost:8080/v1/amazon-status
http://localhost:8080/v1/google-status
http://localhost:8080/v1/all-status
