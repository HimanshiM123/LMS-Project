package com.bridgelabz.lmsproject.util;
import com.bridgelabz.lmsproject.Configuration.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Email email) {
        byte[] emailString = email.toString().getBytes();

        System.out.println(new Date());
        rabbitTemplate.convertAndSend(RabbitMqConfig.ROUTING_KEY, email);
        System.out.println("Is producer returned ::: "+rabbitTemplate.isReturnListener());
        System.out.println(email);
    }
}
