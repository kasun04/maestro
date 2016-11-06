/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
 */


Use Cases - Fundamentals of WSO2 ESB
====================================

This document contains the instructions to try out the samples of 'Fundamentals of WSO2 ESB'.


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

- Go to maestro/src/main/resources deploy sample configuration for use cases of the chapter 3. :
    >> sh deploy.sh ch_03 uc_01 <ESB_HOME>
    Note: You need to deploy the local entry first to deploy the proxy service. You can simply do this by running the deploy script two times
    (i.e. First time the proxy service deployment fails but local entry gets deployed. Second time proxy gets deployed as local entry is already there. .
- Observe ESB logs/console output for the status of new artifacts that you have deployed.

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_03/uc_01

curl -v -X POST -H 'Content-Type: text/xml' -H 'SOAPAction: http://www.example.org/BankInfoProxyService/getBankInformation' -d @BankInfoProxyService_req.xml http://127.0.0.1:8280/services/BankInfoProxyService

Verification
============

Successful execution of the sample should give you the following response at the curl/client side.  

< HTTP/1.1 200 OK
< Content-Type: text/xml; charset=UTF-8
< Date: Sun, 06 Nov 2016 16:50:39 GMT
< Transfer-Encoding: chunked
<
<?xml version='1.0' encoding='UTF-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"><soapenv:Body><getBankInfoResponse>
    <bank>Bank of America Financial Center</bank>
    <address>384 San Antonio Rd, Mountain View, CA 94040, United States</address>
    <phone>+1 650-559-8925</phone>
    <departments>Bank of America ATM, Bank of America Mortgage</departments>
* Connection #0 to host 127.0.0.1 left intact
</getBankInfoResponse></soapenv:Body></soapenv:Envelope>
