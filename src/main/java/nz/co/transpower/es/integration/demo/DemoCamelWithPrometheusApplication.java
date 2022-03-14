package nz.co.transpower.es.integration.demo;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.apache.camel.StartupListener;
import org.apache.camel.model.ModelCamelContext;
import org.apache.camel.spi.RouteController;
import org.apache.camel.spi.SupervisingRouteController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCamelWithPrometheusApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoCamelWithPrometheusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoCamelWithPrometheusApplication.class, args);
	}

//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(
//			ServerHttpSecurity http) {
//		return http.authorizeExchange()
//				.pathMatchers("/actuator/**").permitAll()
//				.anyExchange().authenticated()
//				.and().build();
//	}


	@Autowired
	private CamelContext camelContext;

	@PostConstruct
	public void after() throws Exception {
		camelContext.addStartupListener(new StartupListener() {
			@Override
			public void onCamelContextStarted(CamelContext context, boolean alreadyStarted) throws Exception {
				ModelCamelContext catalog = context.adapt(ModelCamelContext.class);
				RouteController controller = context.getRouteController();
				LOGGER.info("my controller: " + controller.getClass().getName());
				//SupervisingRouteController supervising = controller.supervising();
				LOGGER.info("my onCamelContextStarted hit with alreadyStarted: " + alreadyStarted);
			}

			@Override
			public void onCamelContextFullyStarted(CamelContext context, boolean alreadyStarted) throws Exception {
				LOGGER.info("my onCamelContextFullyStarted hit with alreadyStarted: " + alreadyStarted);
			}
		});
	}
}
