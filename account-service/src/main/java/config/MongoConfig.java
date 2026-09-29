package com.ridelink.account_service.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://shashinaupa:1234567890@cluster0.66r9hkd.mongodb.net/?appName=Cluster0");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "ridelink_account_db");
    }
}