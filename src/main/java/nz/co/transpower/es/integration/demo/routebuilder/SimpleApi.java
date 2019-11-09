package nz.co.transpower.es.integration.demo.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleApi extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("restlet").host("localhost").port(8181);

        //@formatter:off
        rest("/say")
                .get("/good")
                .route().routeId("good-route")
                .choice()
                    .when(header("to-fail"))
                        .throwException(new Exception("failure test"))
                    .endChoice()
                    .otherwise()
                        .transform()
                        .constant("Hello World")
                    .endChoice()
                .end()
        ;
        //@formatter:on


        rest("/say")
                .get("/bad")
                .consumes("application/json")
                .route().routeId("bad-route")
                .throwException(new Exception("exception test"));
    }
}
