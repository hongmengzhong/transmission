package com.example.transmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;

@SpringBootApplication(exclude = SolrAutoConfiguration.class)
public class TransmissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransmissionApplication.class, args);
    }

}
