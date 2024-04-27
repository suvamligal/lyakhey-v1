package org.lashoo.lyakheyv1.kafka;

import org.lashoo.lyakheyv1.DTO.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topicName, Customer msg) {
        kafkaTemplate.send(topicName, msg);
    }

    public void sendStringMessage(String topicName, String msg) {
        kafkaTemplate.send(topicName, msg);
    }


}
