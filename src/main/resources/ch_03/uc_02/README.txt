
Running Use Case
================


Starting Backend Services
=========================

- Run java -jar maestro-1.0-SNAPSHOT.jar to start the backend services.

Checking the backend

curl -v -X POST -H 'Content-Type: text/xml' -H 'SOAPAction: "urn:getPizza"' -d @be_req.xml http://localhost:6060/services/PizzaShopService




Deploying sample configuration
==============================

- Download or clone source code : https://github.com/kasun04/maestro


Running the client
==================

curl "http://localhost:8280/pizzashop/pizza"



