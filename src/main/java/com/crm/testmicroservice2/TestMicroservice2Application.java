package com.crm.testmicroservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TestMicroservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestMicroservice2Application.class, args);
    }

}
