/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
 */


Use Cases - Getting started with WSO2 ESB
=========================================

This document contains the instructions to try out the 'Getting started with WSO2 ESB' sample.


Pre-req
=======

- WSO2 ESB installation : https://github.com/kasun04/maestro/blob/master/src/main/resources/SETUP.txt
- Download or clone source code from : https://github.com/kasun04/maestro



Starting Backend Services
=========================

- Find maestro/maestro-1.0.0.jar and run  'java -jar maestro-1.0.0.jar' to start the backend services.
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

- Go to maestro/src/main/resources deploy sample configuration for use cases of the chapter 2. :
    >> sh deploy.sh ch_02 uc_01 <ESB_HOME>
- Observe ESB logs/console output for the status of new artifacts that you have deployed.

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_02/uc_01

curl -X POST -H 'Content-Type: application/json' -d @getQuoteMobileClientRequest.json http://localhost:8280/StockQuoteInfo


