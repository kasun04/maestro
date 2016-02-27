package kasun.panorama;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.wso2.gw.emulator.dsl.Emulator;

import static org.wso2.gw.emulator.http.server.contexts.HttpServerConfigBuilderContext.configure;
import static org.wso2.gw.emulator.http.server.contexts.HttpServerRequestBuilderContext.request;
import static org.wso2.gw.emulator.http.server.contexts.HttpServerResponseBuilderContext.response;

public class RESTServiceEmulator {
    public static void main(String[] args) {

        String payload = "{\n" +
                         "  \"employees\": [\n" +
                         "    {\n" +
                         "      \"firstName\": \"John\",\n" +
                         "      \"lastName\": \"Doe\"\n" +
                         "    },\n" +
                         "    {\n" +
                         "      \"firstName\": \"Anna\",\n" +
                         "      \"lastName\": \"Smith\"\n" +
                         "    },\n" +
                         "    {\n" +
                         "      \"firstName\": \"Peter\",\n" +
                         "      \"lastName\": \"Jones\"\n" +
                         "    }\n" +
                         "  ]\n" +
                         "}";

        Emulator.getHttpEmulator()
                .server()
                .given(configure().host("127.0.0.1").port(7070).context("/api"))
                .when(request()
                              .withPath("employee")
                              .withMethod(HttpMethod.POST))
                .then(response()
                              .withBody(payload)
                              .withStatusCode(HttpResponseStatus.OK)
                              .withHeader("Content-Type", "application/json"))
                .operation().start();

    }
}
