package com.codeforgeyt.artemisdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codeforgeyt.artemisdemo.Message;

@Service
public class ReceiverService {

    Logger log = LoggerFactory.getLogger(ReceiverService.class);

//    @JmsListener(destination = "${jms.queue2}", containerFactory = "topicConnectionFactory")
    @JmsListener(destination = "${jms.queue2}")
    public void receiveMessage(String message){
        log.info("Received message: " + message);
        // post message to a rest post message consumer
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl= "http://localhost:8080/messages";
        HttpEntity<Message> request = new HttpEntity<>(new Message(message));
//        HttpEntity<Message> request = new HttpEntity<>(new Message("bar"));
        Message msg = restTemplate.postForObject(fooResourceUrl, request, Message.class);
        // restTemplate send back the object if the post is successful
        log.info("Result of post command: " + msg.getMsg());
        // add here error handling
//        assertThat(foo, notNullValue());
//        assertThat(foo.getName(), is("bar"));
    }
    
}
