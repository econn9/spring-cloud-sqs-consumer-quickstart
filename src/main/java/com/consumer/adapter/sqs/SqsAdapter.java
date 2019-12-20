package com.consumer.adapter.sqs;
    
import com.consumer.model.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SqsAdapter {

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @SqsListener("insert-queue-name-here")
    public void onEvent(EventDto message) {
        if (StringUtils.isEmpty(message)) {
            System.out.println("Empty or null message received from queue");
        }
        
        System.out.println("EVENT RECEIVED:\n");
        System.out.println(message);

        // handle event

    }



}
