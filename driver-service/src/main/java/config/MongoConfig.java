package com.ridelink.driver_service.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.concurrent.TimeUnit;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "ridelink_driver_db";
    }

    @Override
    public MongoClient mongoClient() {
        // ඔයාගේ MongoDB Atlas / Local Connection String එක මෙතනට දාන්න
        String connectionString = "mongodb+srv://samodya:12345@cluster0.ynyye9u.mongodb.net/?appName=Cluster0";

        ConnectionString connString = new ConnectionString(connectionString);

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .applyToSocketSettings(builder ->
                        builder.connectTimeout(10, TimeUnit.SECONDS)
                                .readTimeout(10, TimeUnit.SECONDS))
                .applyToClusterSettings(builder ->
                        builder.serverSelectionTimeout(15, TimeUnit.SECONDS))
                .build();

        return MongoClients.create(settings);
    }
}