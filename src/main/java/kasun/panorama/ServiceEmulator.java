/*
 * *
 *  * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *  *
 *  * WSO2 Inc. licenses this file to you under the Apache License,
 *  * Version 2.0 (the "License"); you may not use this file except
 *  * in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing,
 *  * software distributed under the License is distributed on an
 *  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  * KIND, either express or implied.  See the License for the
 *  * specific language governing permissions and limitations
 *  * under the License.
 *
 */
package kasun.panorama;


import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.wso2.gw.emulator.dsl.Emulator;

import static org.wso2.gw.emulator.http.server.contexts.HttpServerConfigBuilderContext.configure;
import static org.wso2.gw.emulator.http.server.contexts.HttpServerRequestBuilderContext.request;
import static org.wso2.gw.emulator.http.server.contexts.HttpServerResponseBuilderContext.response;

/**
 * Simple emulator server
 */
public class ServiceEmulator {

    public static void main(String args[]) {
        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
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

        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(6060).context("/services"))
                .when(request()
                              .withPath("StockQuoteService")
                              .withMethod(HttpMethod.POST)
                              .withHeader("SOAPAction", "\"urn:getQuote\""))
                .then(response()
                              .withBody(payload)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "text/xml"))
                .operation().start();


        System.out.println("StockQuoteService - SOAP service started on port : 6060");

    }
}
