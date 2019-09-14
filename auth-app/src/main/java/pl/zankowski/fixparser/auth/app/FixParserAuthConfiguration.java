package pl.zankowski.fixparser.auth.app;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.zankowski.fixparser.common.security.JwtConfigurationProperties;

@EnableConfigurationProperties(JwtConfigurationProperties.class)
@Configuration
public class FixParserAuthConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
