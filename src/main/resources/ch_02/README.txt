
Running Use Case 2.1
====================


Starting Backend Services
=========================

- Download maestro-1.0-SNAPSHOT.jar from : https://github.com/kasun04/maestro/raw/master/maestro-1.0.0.jar
- Run java -jar maestro-1.0-SNAPSHOT.jar to start the backend services.
- Observe the following logs in a successfully started services.

        kasun@macbookpro:~/development/source/git/kasun04/maestro$ java -jar maestro-1.0.0.jar
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0x735f8565] REGISTERED
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0xe5ec0c96] REGISTERED
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0xa93c3cd2] REGISTERED
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0xe5ec0c96] BIND(/127.0.0.1:6060)
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0xa93c3cd2] BIND(/127.0.0.1:7070)
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0x735f8565] BIND(/127.0.0.1:9191)
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0xe5ec0c96, /127.0.0.1:6060] ACTIVE
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0xa93c3cd2, /127.0.0.1:7070] ACTIVE
         INFO [io.netty.handler.logging.LoggingHandler] [id: 0x735f8565, /127.0.0.1:9191] ACTIVE


Deploying sample configuration
==============================

- Download or clone source code : https://github.com/kasun04/maestro
- Go to maestro/src/main/resources/ch_02 and deploy sample configuration of the chapter 2. : sh deploy.sh ch_02 <ESB_HOME>

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_02

curl -X POST -H 'Content-Type: application/json' -d @getQuoteMobileClientRequest.json http://localhost:8280/StockQuoteInfo


