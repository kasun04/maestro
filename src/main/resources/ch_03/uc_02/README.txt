/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
 */


Use Cases - Fundamentals of WSO2 ESB : Using APIs/HTTP services
===============================================================

This document contains the instructions to try out the sample 'Using APIs/HTTP services'.


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
    >> sh deploy.sh ch_03 uc_02 <ESB_HOME>
- Observe ESB logs/console output for the status of new artifacts that you have deployed.

Running the client
==================

Execute following inside /maestro/src/main/resources/ch_03/uc_02


curl -v -X GET 'http://127.0.0.1:8280/pizzashop/pizza'

Verification
============

Successful execution of the sample should give you the following response at the curl/client side.

< HTTP/1.1 200 OK
< Content-Type: application/json; charset=UTF-8
< Date: Sun, 06 Nov 2016 17:26:50 GMT
< Transfer-Encoding: chunked
<
* Connection #0 to host 127.0.0.1 left intact
{"pizzaMenu":{"category":"meats","pizzas":{"pizza":[{"name":"PRIMO MEATS","description":"Premium Crushed Tomato Sauce made of 100% California grown vine ripened tomatoes topped\n                        with premium salami, pepperoni, all-natural Italian sausage and seasoned pork.\n                    "},{"name":"ITALIAN MEATBALL","description":"Classic marinara sauce, classic meatballs, fresh red onions and diced Roma\n                        tomatoes—flavored up with our Hut Favorite on the crust edge. Best on our famous Pan crust.\n                    "},{"name":"PEPPERONI LOVER'S","description":"Classic marinara sauce piled high with cheese and over 50% more authentic, old-world\n                        pepperoni hand-placed on your pizza.\n                    "}]}}}
