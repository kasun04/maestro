/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
 */


Use Cases - Fundamentals of WSO2 ESB : Listening inbound endpoints
==================================================================

This document contains the instructions to try out the sample 'Listening inbound endpoints'.
This contains the sample use case for HTTP Listening inbound endpoint.


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
    >> sh deploy.sh ch_03 uc_04 <ESB_HOME>
- Observe ESB logs/console output for the status of new artifacts that you have deployed.

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_03/uc_04

curl -X POST -H 'Content-Type: text/xml' -d @OrderProcReq.xml http://localhost:5151

Verification
============

Successful execution of the sample should give you the following response at the curl/client side.

< HTTP/1.1 200 OK
< Content-Type: text/xml; charset=UTF-8
< Date: Sun, 06 Nov 2016 19:02:12 GMT
< Transfer-Encoding: chunked
<
<?xml version='1.0' encoding='UTF-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ordproc="http://orders.samples">
    <soapenv:Body>
        <ordproc:procOrderReponse>
            <processedOrders>
                <order>
                    <id>A234R</id>
                </order>
                <order>
                    <id>B234D</id>
                </order>
                <order>
                    <id>4RFG</id>
                </order>
                <order>
                    <id>GR8Y</id>
                </order>
            </processedOrders>
        </ordproc:procOrderReponse>
    </soapenv:Body>



