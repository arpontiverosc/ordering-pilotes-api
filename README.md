
# Java Engineer technical test for TUI "Ordering pilotes"

a Spring based application develop using hexagonal architecture that allows us to manage the orders of the "pilotes" through some API. Pilotes of the great Miquel Montoro are a Majorcan recipe that consisting of a meatball stew.

The following operations are implemented:
- Create a pilotes order, choosing between 5, 10 or 15 pilotes.
- Update a pilotes order. During the 5 minutes following the creation of the order it will be allowed to update the order data; after that time it will not be possible to modify any data of the order because Miquel will be occupied cooking thepilotes.
- Search orders by customer data. Allow partial searches: e.g., all orders of customers whose name contains an “a” in their name.

All types of data used must be validated. 

The search operation must be secured, you must check that the user is allowed to use the search. All other operations are public and should not be secured.




## Authors

- [@arpontiveros](https://github.com/arpontiverosc)


## Deployment

To deploy this project run

## Documentation

[Swagger](http://localhost:8080/swagger-ui/index.html)

[Postman](https://github.com/arpontiverosc/tui-ordering-pilotes-api/tree/main/postman)

