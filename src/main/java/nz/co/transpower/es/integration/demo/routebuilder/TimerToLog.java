package nz.co.transpower.es.integration.demo.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerToLog extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:myTimer?period=20000")
                .routeId("scheduled-route")
                .log("route triggered ${date:now:yyyy-MM-dd'T'hh:mm:ss}");
    }
}
