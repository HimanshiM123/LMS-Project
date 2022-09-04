package com.bridgelabz.lmsproject.util;

import com.bridgelabz.lmsproject.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageListenerImpl implements MessageListener {
    @Autowired
    private MailService mailService;
    @Override
    public void onMessage(Email email) throws NoSuchFieldException, SecurityException, ClassNotFoundException {
        System.out.println(email);
        System.out.println("to : "+email.to);
        System.out.println("from : "+email.from);
        System.out.println("body:"+email.body);
        System.out.println("subject:"+email.subject);
        //SENDING MESSAGE FROM JMS GETTING FROM RABBITMQ ONE BY ONE
        mailService.send(email.to, email.subject, email.body);
        System.out.println("  ");



        System.out.println("Message Received:" + email.toString());

        System.out.println(new Date());
    }
}
