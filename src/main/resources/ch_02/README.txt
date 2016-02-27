

Prerequisites
=============

- Install JDK
- Setup JAVA_HOME


Installing and starting WSO2 ESB 5.0
====================================

- Download WSO2 ESB  : wso2esb-4.9.0.zip from http://wso2.com/products/enterprise-service-bus/
- Unzip wso2esb-4.9.0.zip. (The path to this folder will be referred to as <ESB_HOME> throughout the documentation).
- Start server by running the start script 'wso2server.sh' inside $ESB_HOME/bin : wso2esb-4.9.0/bin$ sh wso2server.sh
- Once the server is successfully started, it should print the following log messages in the console.

    ...
    [2016-02-27 23:26:59,038]  INFO - JMXServerManager JMX Service URL  : service:jmx:rmi://localhost:11111/jndi/rmi://localhost:9999/jmxrmi
    [2016-02-27 23:26:59,039]  INFO - StartupFinalizerServiceComponent Server           :  WSO2 Enterprise Service Bus-4.9.0
    [2016-02-27 23:26:59,040]  INFO - StartupFinalizerServiceComponent WSO2 Carbon started in 28 sec
    [2016-02-27 23:26:59,226]  INFO - CarbonUIServiceComponent Mgt Console URL  : https://192.168.1.2:9443/carbon/


- You have just installed and started WSO2 ESB successfully!


Starting Backend Services
=========================

- Download maestro-1.0-SNAPSHOT.jar from :
- Run java -jar maestro-1.0-SNAPSHOT.jar to start the backend services.
- Observe the following logs in a successfully started services.

     StockQuoteService - SOAP service started on port : 6060
     INFO [io.netty.handler.logging.LoggingHandler] [id: 0xd608d362] REGISTERED
     INFO [io.netty.handler.logging.LoggingHandler] [id: 0xd608d362] BIND(/127.0.0.1:6060)
     INFO [io.netty.handler.logging.LoggingHandler] [id: 0xd608d362, /127.0.0.1:6060] ACTIVE


Deploying sample configuration
==============================

- Download or clone source code : https://github.com/kasun04/maestro
- Go to maestro/src/main/resources/ch_02 and deploy sample configuration of the chapter 2. : sh deploy.sh ch_02 <ESB_HOME>

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_02

curl -X POST -H 'Content-Type: application/json' -d @getQuoteMobileClientRequest.json http://localhost:8280/StockQuoteInfo


