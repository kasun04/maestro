
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
- Go to maestro/src/main/resources/ch_02 and deploy sample configuration of the chapter 2. : sh deploy.sh ch_02 <ESB_HOME>


Running the client
==================

Execute following inside /maestro/src/main/resources/ch_02

curl -v -X POST -H 'Content-Type: text/xml' -H 'SOAPAction: http://www.example.org/BankInfoProxyService/getBankInformation' -d @getBankInfoReq.xml http://127.0.0.1:8280/services/BankInfoProxyService


