# Custom Star Wars Api

### Docker
To build image:
 > docker build -f Dockerfile -t star-wars-app .

To run image:
> docker run -p 8080:8080 <IMAGE ID>

### Swagger
To use api in Swagger go to:
 > http://your_address/swagger-ui.html

### Tests
To run:
 > gradle clean test

### Metrics
Go to:
 > http://your_address/actuator/