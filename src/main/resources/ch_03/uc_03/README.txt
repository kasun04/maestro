/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
 */


Use Cases - Fundamentals of WSO2 ESB : Using Inbound Endpoints
===============================================================

This document contains the instructions to try out the sample 'Using Inbound Endpoints'.
This sample is based on JMS Polling inbound endpoints.

Pre-req
=======

- WSO2 ESB installation : https://github.com/kasun04/maestro/blob/master/src/main/resources/SETUP.txt
- Download or clone source code from : https://github.com/kasun04/maestro
- Download and install Apache Active MQ
- Check activemq admin console at http://0.0.0.0:8161/ with default un:admin, password:admin
- Copy required client libraries to :
        >> cp activemq-broker-5.13.2.jar activemq-client-5.13.2.jar geronimo-jms_1.1_spec-1.1.1.jar geronimo-j2ee-management_1.1_spec-1.0.1.jar hawtbuf-1.11.jar ../../wso2esb-5.0.0/repository/components/lib
- Restart ESB.



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
    >> sh deploy.sh ch_03 uc_03 <ESB_HOME>
- Observe ESB logs/console output for the status of new artifacts that you have deployed.

Running the client
==================

- In the activemq console go queue and in 'ordersQueue', add a new message with the message content in 'OrderProcReq.xml'.
- You can use 'Send To' opetaion of the 'ordersQueue' in activemq admin console.


Verification
============

Successful execution of the sample should give you the following observations.

- In the ESB console output you should see the following output.


[2016-11-06 10:10:30,392]  INFO - LogMediator To: , MessageID: ID:Kas-HS.local-56809-1478453666966-4:1:1:1:11, Direction: request, Msg Flw = === Got message ===, Envelope: <?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ordproc="http://services.samples"><soapenv:Body>
        <ordproc:procOrder>
            <orders>
                <order>
                    <id>A234R</id>
                    <name>iPhone 6S</name>
                    <description>Apple Inc. 2016, unlocked</description>
                    <unitPrice>USD 700</unitPrice>
                    <quantity>1</quantity>
                </order>
                <order>
                    <id>B234D</id>
                    <name>GoPro Hero4</name>
                    <description>2016, black </description>
                    <unitPrice>USD 500</unitPrice>
                    <quantity>1</quantity>
                </order>
                <order>
                    <id>4RFG</id>
                    <name>Nikon D5500</name>
                    <description/>
                    <unitPrice>USD 500</unitPrice>
                    <quantity>1</quantity>
                </order>
                <order>
                    <id>GR8Y</id>
                    <name>iPhone case</name>
                    <description>Waterproof iPhone 6s</description>
                    <unitPrice>USD 15</unitPrice>
                    <quantity>1</quantity>
                </order>
            </orders>
        </ordproc:procOrder>
    </soapenv:Body></soapenv:Envelope>


[2016-11-06 10:10:30,393]  INFO - LogMediator To: http://www.w3.org/2005/08/addressing/anonymous, WSAction: , SOAPAction: , MessageID: urn:uuid:2cc5a884-184b-4739-ab29-4bc3a80a880e, Direction: request, Msg Flw = === Got message ===, Envelope: <?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ordproc="http://orders.samples"><soapenv:Body>
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
    </soapenv:Body></soapenv:Envelope>


- Also in the ActiveMQ console you should be able to see the 'Messages Enqueued' and 'Messages Dequeued' counts.






