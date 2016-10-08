/*
 * *
 *  * Copyright (C) Kasun Indrasiri - All Rights Reserved.
 */
package kasun.panorama;


import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.wso2.gw.emulator.dsl.Emulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.wso2.gw.emulator.http.server.contexts.HttpServerConfigBuilderContext.configure;
import static org.wso2.gw.emulator.http.server.contexts.HttpServerRequestBuilderContext.request;
import static org.wso2.gw.emulator.http.server.contexts.HttpServerResponseBuilderContext.response;

/**
 * Simple emulator server
 */
public class ServiceEmulator {

    public static final int PORT_SERVICE_ORCHESTRATION = 9191;
    public static final String URI_SERVICE_ORCHESTRATION = "/serviceorchestration";

    public static final String soapStockQuoteResponse = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                                                        "   <soapenv:Body>\n" +
                                                        "      <ns:getQuoteResponse xmlns:ns=\"http://services.samples\">\n" +
                                                        "         <ns:return xsi:type=\"ax21:GetQuoteResponse\" xmlns:ax21=\"http://services.samples/xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                                                        "            <ax21:change>4.289346010366909</ax21:change>\n" +
                                                        "            <ax21:earnings>-9.6188785014457</ax21:earnings>\n" +
                                                        "            <ax21:high>62.74694943391316</ax21:high>\n" +
                                                        "            <ax21:last>60.42803830258261</ax21:last>\n" +
                                                        "            <ax21:lastTradeTimestamp>Sun Feb 14 09:17:43 IST 2016</ax21:lastTradeTimestamp>\n" +
                                                        "            <ax21:low>62.478265478558995</ax21:low>\n" +
                                                        "            <ax21:marketCap>5803951.705881957</ax21:marketCap>\n" +
                                                        "            <ax21:name>WSO2 Company</ax21:name>\n" +
                                                        "            <ax21:open>-59.48571708937672</ax21:open>\n" +
                                                        "            <ax21:peRatio>-49.01618229924337</ax21:peRatio>\n" +
                                                        "            <ax21:percentageChange>-7.603373984588675</ax21:percentageChange>\n" +
                                                        "            <ax21:prevClose>-56.413718686743685</ax21:prevClose>\n" +
                                                        "            <ax21:symbol>WSO2</ax21:symbol>\n" +
                                                        "            <ax21:volume>5629</ax21:volume>\n" +
                                                        "         </ns:return>\n" +
                                                        "      </ns:getQuoteResponse>\n" +
                                                        "   </soapenv:Body>\n" +
                                                        "</soapenv:Envelope>";

    public static final String poxPayload = "<a>bbbb</a>\n";
    public static final String pizzaShopPayload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                                                  "    <soapenv:Body>\n" +
                                                  "        <pizzaMenu>\n" +
                                                  "            <category>meats</category>\n" +
                                                  "            <pizzas>\n" +
                                                  "                <pizza>\n" +
                                                  "                    <name>PRIMO MEATS</name>\n" +
                                                  "                    <description>Premium Crushed Tomato Sauce made of 100% California grown vine ripened tomatoes topped\n" +
                                                  "                        with premium salami, pepperoni, all-natural Italian sausage and seasoned pork.\n" +
                                                  "                    </description>\n" +
                                                  "                </pizza>\n" +
                                                  "                <pizza>\n" +
                                                  "                    <name>ITALIAN MEATBALL</name>\n" +
                                                  "                    <description>Classic marinara sauce, classic meatballs, fresh red onions and diced Roma\n" +
                                                  "                        tomatoes—flavored up with our Hut Favorite on the crust edge. Best on our famous Pan crust.\n" +
                                                  "                    </description>\n" +
                                                  "                </pizza>\n" +
                                                  "                <pizza>\n" +
                                                  "                    <name>PEPPERONI LOVER'S</name>\n" +
                                                  "                    <description>Classic marinara sauce piled high with cheese and over 50% more authentic, old-world\n" +
                                                  "                        pepperoni hand-placed on your pizza.\n" +
                                                  "                    </description>\n" +
                                                  "                </pizza>\n" +
                                                  "            </pizzas>\n" +
                                                  "        </pizzaMenu>\n" +
                                                  "    </soapenv:Body>\n" +
                                                  "</soapenv:Envelope>";


    public static final String stockquoteJsonPayload = "{\n" +
                                                       "  \"getQuoteResponse\": {\n" +
                                                       "    \"quote\": {\n" +
                                                       "      \"change\": \"4.289346010366909\",\n" +
                                                       "      \"earnings\": \"-9.6188785014457\",\n" +
                                                       "      \"high\": \"62.74694943391316\",\n" +
                                                       "      \"last\": \"60.42803830258261\",\n" +
                                                       "      \"lastTradeTimestamp\": \"Sun Feb 14 09:17:43 IST 2016\",\n" +
                                                       "      \"low\": \"62.478265478558995\",\n" +
                                                       "      \"marketCap\": \"5803951.705881957\",\n" +
                                                       "      \"name\": \"WSO2 Company\",\n" +
                                                       "      \"open\": \"-59.48571708937672\",\n" +
                                                       "      \"peRatio\": \"-49.01618229924337\",\n" +
                                                       "      \"percentageChange\": \"-7.603373984588675\",\n" +
                                                       "      \"prevClose\": \"-56.413718686743685\",\n" +
                                                       "      \"symbol\": \"WSO2\",\n" +
                                                       "      \"volume\": \"5629\"\n" +
                                                       "    }\n" +
                                                       "  }\n" +
                                                       "}";

    public static final String orderProcessingServicePayload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ordproc=\"http://orders.samples\">\n" +
                                                               "    <soapenv:Body>\n" +
                                                               "        <ordproc:procOrderReponse>\n" +
                                                               "            <processedOrders>\n" +
                                                               "                <order>\n" +
                                                               "                    <id>A234R</id>\n" +
                                                               "                </order>\n" +
                                                               "                <order>\n" +
                                                               "                    <id>B234D</id>\n" +
                                                               "                </order>\n" +
                                                               "                <order>\n" +
                                                               "                    <id>4RFG</id>\n" +
                                                               "                </order>\n" +
                                                               "                <order>\n" +
                                                               "                    <id>GR8Y</id>\n" +
                                                               "                </order>\n" +
                                                               "            </processedOrders>\n" +
                                                               "        </ordproc:procOrderReponse>\n" +
                                                               "    </soapenv:Body>\n" +
                                                               "</soapenv:Envelope>";

    public static void main(String args[]) {
        runServices();
    }


    public static void runServices() {

        System.out.println("Working Dir : " + System.getProperty("user.dir"));
        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(6060).context("/services"))

                /* SOAP Service : StockQuoteService*/
                .when(request()
                              .withPath("StockQuoteService")
                              .withMethod(HttpMethod.POST)
                              .withHeader("SOAPAction", "\"urn:getQuote\""))
                .then(response()
                              .withBody(soapStockQuoteResponse)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "text/xml "))

                /* Legacy PoX Service : BankInfoService */
                .when(request()
                              .withPath("BankInfoService")
                              .withMethod(HttpMethod.POST)
                              .withHeader("Content-Type", "application/xml; charset=UTF-8"))
                .then(response()
                              .withBody(poxPayload)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "application/xml"))

                /* SOAP Service : PizzaShopService */
                .when(request()
                              .withPath("PizzaShopService")
                              .withMethod(HttpMethod.POST))
                .then(response()
                              .withBody(pizzaShopPayload)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "text/xml"))
                /* SOAP Service : OrderProcessorService */
                .when(request()
                              .withPath("OrderProcessorService")
                              .withMethod(HttpMethod.POST))
                .then(response()
                              .withBody(orderProcessingServicePayload)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "text/xml"))


                .operation().start();

        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(7070).context("/services").withLogicDelay(11))

                /* REST Service with delay : StockQuoteRESTService*/
                .when(request()
                              .withPath("StockQuoteRESTService")
                              .withMethod(HttpMethod.POST))
                .then(response()
                              .withBody(stockquoteJsonPayload)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "application/json "))
                .operation().start();


        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(PORT_SERVICE_ORCHESTRATION).context(URI_SERVICE_ORCHESTRATION))

                /* GeoLocationToPostalCodeService */
                .when(request()
                              .withPath("GeoLocationToPostalCodeService")
                              .withMethod(HttpMethod.POST)
                              /*.withHeader("Content-Type", "application/json")*/)
                .then(response()
                              .withBody(createPayload("src/main/resources/ch_10/resources/sample_resources/message_formats/GeoLocationToPostalCode_res.json"))
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "application/json"))

                /* PostalcodeToATMLocatorService */
                .when(request()
                              .withPath("PostalcodeToATMLocatorService")
                              .withMethod(HttpMethod.POST)
                              /*.withHeader("SOAPAction", "urn:PostalcodeToATMLocatorService")*/)
                .then(response()
                              .withBody(createPayload("src/main/resources/ch_10/resources/sample_resources/message_formats/PostalcodeToATMLocatorService_res.xml"))
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "text/xml"))

                /* GeoLocationToAddressService */
                .when(request()
                              .withPath("GeoLocationToAddressService")
                              .withMethod(HttpMethod.POST)
                              .withHeader("Content-Type", "application/xml"))
                .then(response()
                              .withBody(createPayload("src/main/resources/ch_10/resources/sample_resources/message_formats/GeoLocationToAddress_res.xml"))
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "application/xml"))

                .operation().start();

    }


    public static void runServiceOrchetrationbackends() {





    }


    public static String createPayload(String fileName) {

        StringBuilder builder = new StringBuilder();
        BufferedReader br = null;

        try {
            String sCurrentLine = "";
            br = new BufferedReader(new FileReader(fileName));
            while ((sCurrentLine = br.readLine()) != null) {
                builder.append(sCurrentLine + "\n");
             }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return   builder.toString();
    }


    public static void timeoutVerifyBE() {
        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(9797).context("/Foo").withLogicDelay(1* 1000))

                .when(request()
                              .withPath("EchoService")
                              .withMethod(HttpMethod.POST))
                .then(response()
                              .withBody(soapStockQuoteResponse)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "text/xml"))
                .operation().start();


        /*Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(9494).context("/TBE").withLogicDelay(1* 1000))

                *//* SOAP Service : StockQuoteService*//*
                .when(request()
                              .withPath("StockQuoteService")
                              .withMethod(HttpMethod.POST))
                .then(response()
                              .withStatusCode(HttpResponseStatus.ACCEPTED)
                              .withHeader("Content-Type", "text/xml "))
                .operation().start();*/

    }


}
