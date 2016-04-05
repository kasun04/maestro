
Running Use Case
================


Starting Backend Services
=========================

- Run java -jar maestro-1.0-SNAPSHOT.jar to start the backend services.

Checking the backend

curl -v -X POST -H 'Content-Type: application/json' -d @be_req.json http://localhost:7070/services/StockQuoteRESTService




Deploying sample configuration
==============================

- Download or clone source code : https://github.com/kasun04/maestro


Running the client
==================

curl -v -X POST -H 'Content-Type: application/xml' -d @esb_req.xml http://localhost:8280/stockquotepox




