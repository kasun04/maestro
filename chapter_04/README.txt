

StockQuoteProvider
===================

curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @getQuote.xml http://127.0.0.1:8280/services/StockQuoteProvider -v




OrderManagerProxy
=================

curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @placeOrder.xml http://127.0.0.1:8280/services/OrderManagerProxy -v


ReqReply_To_OneWay
==================

curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @placeOrder.xml http://127.0.0.1:8280/services/ReqReply_To_OneWay -v



OneWay_To_ReqRes
================

curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @placeOrder.xml http://127.0.0.1:8280/services/OneWay_To_ReqRes -v


4.3
===

curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @getQuote.xml http://127.0.0.1:8280/services/MessageFilterProxy_4.3 -v

4.4
===

curl -X POST -H 'Content-Type: application/json' \
             -d @getQuote.json http://127.0.0.1:8280/StockQuoteAPI -v


4.5
curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @checkStockQuote.xml http://127.0.0.1:8280/services/MessageTransformer_PF_Proxy_4.5 -v


4.6
curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @getFullQuote.xml http://127.0.0.1:8280/services/XSLTTransformProxy_4.6 -v


4.7




4.9

curl -X POST -H 'Content-Type: text/xml' \
             -H 'SOAPAction: urn:mediate' \
             -d @placeOrder.xml http://127.0.0.1:8280/services/MessageEnrichProxy_4.9 -v






