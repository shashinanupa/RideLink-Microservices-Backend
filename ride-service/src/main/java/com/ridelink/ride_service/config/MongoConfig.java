package com.ridelink.ride_service.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    // 1. Mongo Client Creation (Local MongoDB Connection)
    @Bean
    public MongoClient mongoClient() {
        // Local MongoDB URL (Default Port: 27017)
        return MongoClients.create("mongodb+srv://ranidu:12345@cluster0.lcypvbo.mongodb.net/?appName=Cluster0");

        // Mongo Atlas Cloud එකක් use කරනවා නම් උඩ පේළිය Comment කරලා පල්ලෙහා පේළිය Use කරන්න:
        // return MongoClients.create("mongodb+srv://<username>:<password>@cluster0.xxxxx.mongodb.net/?retryWrites=true&w=majority");
    }

    // 2. Database Factory Setup (Unique DB name for Ride Service)
    @Bean
    public SimpleMongoClientDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), "ridelink_ride_db");
    }

    // 3. MongoTemplate Creation
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}