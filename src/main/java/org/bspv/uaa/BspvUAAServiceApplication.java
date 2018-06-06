package org.bspv.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableDiscoveryClient
@EnableWebSecurity
@SpringBootApplication
public class BspvUAAServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BspvUAAServiceApplication.class, args);
    }

}
