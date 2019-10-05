package nz.co.transpower.es.integration.demo.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleApi extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("restlet").host("localhost").port(8181);

        rest("/say")
                .get("/hello").to("direct:hello");
        from("direct:hello").routeId("say/hello-backend")
                .transform().constant("Hello World");

        rest("/say")
                .get("/bye").to("direct:bye");
        from("direct:bye").routeId("say/bye-backend")
                .transform().constant("Bye World");

        rest("/say")
                .post("/bye").consumes("application/json").to("mock:update");
    }
}
