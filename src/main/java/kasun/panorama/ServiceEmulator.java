/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
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
                        .withBody(createPayload("src/main/resources/ch_02/uc_01/getQuote_res.xml"))
                        .withStatusCode(HttpResponseStatus.OK)
                        .withHeader("Content-Type", "text/xml "))

                /* Legacy PoX Service : BankInfoService */
                .when(request()
                        .withPath("BankInfoService")
                        .withMethod(HttpMethod.POST)
                        .withHeader("Content-Type", "application/xml"))
                .then(response()
                        .withBody(createPayload("src/main/resources/ch_03/uc_01/BankInfoService_res.xml"))
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
                        .withBody(createPayload("src/main/resources/ch_03/uc_04/OrderProcRes.xml"))
                        .withStatusCode(HttpResponseStatus.OK)
                        .withHeader("Content-Type", "text/xml"))

                .operation().start();


        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(6061).context("/services")
                        .withLogicDelay(60 * 1000)
                        .randomConnectionClose(true))
                /* Slow OrderProcessing Service : LegacyOrderProcessorService */
                .when(request()
                        .withPath("LegacyOrderProcessorService")
                        .withMethod(HttpMethod.POST))
                .then(response()
                        .withBody(createPayload("src/main/resources/ch_03/uc_04/OrderProcRes.xml"))
                        .withStatusCode(HttpResponseStatus.OK)
                        .withHeader("Content-Type", "application/xml"))
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
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return builder.toString();
    }


    public static void timeoutVerifyBE() {
        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(9797).context("/Foo").withLogicDelay(1 * 1000))

                .when(request()
                        .withPath("EchoService")
                        .withMethod(HttpMethod.POST))
                .then(response()
                        .withBody(createPayload("src/main/resources/ch_02/uc_01/getQuote_res.xml"))
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
