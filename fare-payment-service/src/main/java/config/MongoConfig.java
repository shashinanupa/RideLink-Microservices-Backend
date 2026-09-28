package com.ridelink.fare_payment_service.config;

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
        return "ridelink_payment_db";
    }

    @Override
    public MongoClient mongoClient() {
        // ඔයාගේ MongoDB Atlas Username, Password සහ Cluster URL එක මෙතැනට යොදන්න:
        String connectionString = "mongodb+srv://saumya:12345@cluster0.vd5nxps.mongodb.net/?appName=Cluster0";

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