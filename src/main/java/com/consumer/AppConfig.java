package com.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${aws.sqs.region:}")
    private String sqsRegion;

    public String getSqsRegion() {
        return sqsRegion;
    }
}