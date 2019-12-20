package com.consumer.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.consumer.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SqsConfig {

    @Autowired
    private AppConfig appConfig;

    @Autowired(required = false)
    private AWSCredentialsProvider awsCredentialsProvider;

    @Bean
    public QueueMessagingTemplate getQueueMessagingTemplate() {
        return new QueueMessagingTemplate(sqsClient());
    }

    @Primary
    @Bean
    public AmazonSQSAsync sqsClient() {
        AmazonSQSAsyncClientBuilder builder = AmazonSQSAsyncClientBuilder.standard();

        if (this.awsCredentialsProvider != null) {
            builder.withCredentials(this.awsCredentialsProvider);
        }

        if (appConfig.getSqsRegion() != null) {
            builder.withRegion(appConfig.getSqsRegion());
        } else {
            builder.withRegion(Regions.DEFAULT_REGION);
        }

        return builder.build();
    }


}
