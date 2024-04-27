package org.lashoo.lyakheyv1.kafka;

import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.lashoo.lyakheyv1.CustomerController;
import org.lashoo.lyakheyv1.DTO.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;

@Service
public class CustomerKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(CustomerKafkaConsumer.class.getName());

    private String topicName = "testLocal";

    ObjectMapper obj = new ObjectMapper();

    @KafkaListener(topics = "testLocal", containerFactory = "kafkaListenerContainerFactory", groupId = "test_group")
    public void consumeKafkaMessage(KafkaConsumer<String, Object> consumer) {
        logger.info("consumer invoked from CustomerKafkaConsumer");
        consumer.subscribe(Collections.singleton(topicName));
        ConsumerRecord<String, Object> object = consumer.poll(Duration.ofMillis(3000)).iterator().next();
        ObjectMapper obj = new ObjectMapper();
//        Customer cs =obj.readValue(object.value(), Customer.class)
//        logger.info("MESSAGE IS " + consumerRecords);

        }



}
