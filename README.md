Steps for Running Application

1. Import the project into IDE.

2. Change database configuration as per your local system.

3. Default property is to create table when the application stared
spring.jpa.hibernate.ddl-auto= create

you can change as per your needs.
Hibernate ddl auto (create, create-drop, validate, update)

4. Default Port is 8080

5. You can use postman to check the API:

URL : http://localhost:8080/gateway/pay

Request Payload:
{
"amount": "100",
"currency": "USD",
"type": "debitcard",
"card": {
"number": "4111111111111111",
"expirationMonth": "2",
"expirationYear": "2020",
"cvv": "111"
}
}



6. Card Not supported Response

{
    "date": "2020-10-01T11:23:44.544+00:00",
    "message": "Unsupported Payment Type",
    "status": "failure"
}



