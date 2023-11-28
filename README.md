
# Java Engineer technical test for TUI "Ordering pilotes"

Spring based application developed following a hexagonal architecture, Java 17 and Spring boot 3.0.0. It allows us to manage the orders of the "pilotes" through some API. Pilotes of the great Miquel Montoro are a Majorcan recipe that consisting of a meatball stew.

The following operations are implemented:
- Create a pilotes order, choosing between 5, 10 or 15 pilotes.
- Update a pilotes order. During the 5 minutes following the creation of the order it will be allowed to update the order data; after that time it will not be possible to modify any data of the order because Miquel will be occupied cooking thepilotes.
- Search orders by customer data. Allow partial searches: e.g., all orders of customers whose name contains an “a” in their name.

All types of data used are validated. 
The search operation is secured and checks if the user is allowed to use the search. All other operations are public and are not be secured.
The API follows REST standard.
Use an in-memory database H2.
E2E Test and unit tests. More than 80% Test coverage.
Include Dockerfile and docker-compose.yaml.
API documentation (Swagger and Open Api Yaml)

## Application user

    User: arpontiverosc,
    Password: 123456,
    user id: 1011

## Available customers id to create orders

    1012
    1013
    1014
    1015


## Authors

- [@arpontiveros]


## Deployment

To deploy this project. From "/tui-ordering-pilotes-api/tree/main/ordering-pilotes-container"

Find Dockerfile. Run:

    docker build -t ordering-pilotes .

To build a docker image.

Find docker-compose.yaml. Run:

    docker-compose up

To start up container.

## Database

[Database](http://localhost:8080/h2-console/login.jsp)

    jdbc:h2:mem:orderingPilotes

## Testing

[E2ETests] tui-ordering-pilotes-api/tree/main/ordering-pilotes-container/src/test/java/com/tui/ordering/pilotes

[UnitTests] /tui-ordering-pilotes-api/tree/main/ordering-pilotes-use-case/src/test/java/com/tui/ordering/pilotes

[Coverage report] tui-ordering-pilotes-api/blob/main/htmlReport/index.html


## Documentation

[Swagger](http://localhost:8080/swagger-ui/index.html)

[Open Api Yaml] /tui-ordering-pilotes-api/blob/main/postman/openapi.yaml

[Postman] /tui-ordering-pilotes-api/tree/main/postman







