
Running Use Case 3.1
====================


Starting Backend Services
=========================

- Run java -jar maestro-1.0-SNAPSHOT.jar to start the backend services.

Checking the backend

curl -v -X POST -H 'Content-Type: text/xml' -H 'SOAPAction: "urn:getPizza"' -d @be_req.xml http://localhost:6060/services/PizzaShopService


MB
===


Copy required client libraries

cp activemq-broker-5.13.2.jar activemq-client-5.13.2.jar geronimo-jms_1.1_spec-1.1.1.jar geronimo-j2ee-management_1.1_spec-1.0.1.jar hawtbuf-1.11.jar /Users/kasun/development/deployment/maestro/wso2esb-4.9.0/repository/components/lib


Deploying sample configuration
==============================

- Download or clone source code : https://github.com/kasun04/maestro


Running the client
==================

curl "http://localhost:8280/pizzashop/pizza"



