
Running Use Case 3.1
====================


Starting Backend Services
=========================

- Run java -jar maestro-1.0-SNAPSHOT.jar to start the backend services.
- Observe the following logs in a successfully started services.

     StockQuoteService - SOAP service started on port : 6060
     INFO [io.netty.handler.logging.LoggingHandler] [id: 0xd608d362] REGISTERED
     INFO [io.netty.handler.logging.LoggingHandler] [id: 0xd608d362] BIND(/127.0.0.1:6060)
     INFO [io.netty.handler.logging.LoggingHandler] [id: 0xd608d362, /127.0.0.1:6060] ACTIVE

Checking the backend

curl -X POST -H 'Content-Type: application/xml' -d @getBankInfoReq.xml -v http://localhost:6060/services/BankInfoService

Deploying sample configuration
==============================

- Download or clone source code : https://github.com/kasun04/maestro
- Go to maestro/src/main/resources/ch_04 and deploy sample configuration of the chapter 4. : sh deploy.sh ch_04 <ESB_HOME>


Client libs
===========

andes-client-3.1.1.jar
geronimo-jms_1.1_spec-1.1.0.wso2v1.jar
org.wso2.securevault-1.0.0-wso2v2.jar

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_02

curl -v -X POST -H 'Content-Type: text/xml' -d @getSimpleQuote.xml http://127.0.0.1:8280/services/OrderAcceptor


