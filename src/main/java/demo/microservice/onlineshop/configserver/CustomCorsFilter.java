package demo.microservice.onlineshop.configserver;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomCorsFilter extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            // Add CORS headers for the specific route
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "*");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "*");
            return chain.filter(exchange);
        };
    }
}
