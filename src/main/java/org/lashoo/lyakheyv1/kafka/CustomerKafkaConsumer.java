package org.lashoo.lyakheyv1.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.lashoo.lyakheyv1.DTO.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;

@Component
public class CustomerKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CustomerKafkaConsumer.class.getName());

    @Value("${kafka.consumer.topic.name}")
    private String topicName;

    ObjectMapper obj = new ObjectMapper();

    @KafkaListener(topics = "#{'${kafka.consumer.topic.name}'}", containerFactory = "kafkaListenerContainerFactory", groupId = "test_group")
    public void consumeKafkaMessage(ConsumerRecord<String, Object> consumerRecord) throws JsonProcessingException {
        logger.info("Kafka Topic name is " + topicName);
//        logger.info("consumer invoked from CustomerKafkaConsumer");
//        consumer.subscribe(Collections.singleton(topicName));
        ObjectMapper objectMapper = new ObjectMapper();

//while(true){
////    ConsumerRecords<String, Object> object = consumer.poll(Duration.ofMillis(3000));
//    for(ConsumerRecord<String, Object> record : object){

        System.out.println("ABCDEF" + consumerRecord.value().toString());
        Customer target = objectMapper.readValue(consumerRecord.value().toString(), Customer.class);

        System.out.println("message is" + target);

//    }
}
//
//        logger.info("MESSAGE IS " + consumerRecords);

//    }



}
