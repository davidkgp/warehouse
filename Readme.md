# Warehouse Software


## Local Run
1. with maven 
* Run docker-compose up -d mydb- starts the database
* mvn spring-boot:run

2. Docker
* mvn clean install
* docker-compose up --build -d

## API URLS
After starting the application , access the http://localhost:8099/warehouse/swagger-ui/#/web-mvc-links-handler to see the urls available
## Improvement
1. Improve the test coverage
2. Able to handle partial stocks for products
3. Use queue instead of spring events as persistence is an issue.
4. The entire application is single thread, the event could be asynchronous
5. Sale should be eventually consistent
