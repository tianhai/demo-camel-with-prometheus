package nz.co.transpower.es.integration.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCamelWithPrometheusApplication {

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

}
