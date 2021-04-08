# Spring Webflux - Criando seu Gerenciador de Heróis - Digital Innovation One

## Stack utilizada

  * Java 11
  * Spring Webflux
  * Spring Data
  * Dynamodb
  * Junit
  * Sl4j
  * Reactor
  
  

### Slides de palestra: https://speakerdeck.com/kamilahsantos/live-coding-dio-api-de-herois-com-spring-webflux

### Palestra garavda: https://www.youtube.com/watch?v=1VllPZYn6RI&t=3257s







### Executar dynamo: 

Na pasta em que o jar está baixado: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
 
Para listar as tabelas criadas:  aws dynamodb list-tables --endpoint-url http://localhost:8000

### Swagger: 

Url: http://localhost:8080/swagger-ui-heroes-reactive-api.html
