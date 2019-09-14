package pl.zankowski.fixparser.auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FixParserAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FixParserAuthApplication.class, args);
    }

}
