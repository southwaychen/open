package com.open.pay.service.mq;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    String topic="test";
    public void sendMessage(String key,String data){
        kafkaTemplate.send(new ProducerRecord(topic,key,data));
    }
}
