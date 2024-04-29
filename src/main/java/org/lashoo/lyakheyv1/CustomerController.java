package org.lashoo.lyakheyv1;

import org.lashoo.lyakheyv1.DTO.Customer;
import org.lashoo.lyakheyv1.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class.getName());

    private static final String topicName = "testLocal";

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/index")
    public String welcome(){
        return "Hello World";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        kafkaProducer.sendStringMessage(topicName, message);
        return "Message sent: " + message;
    }

    @PostMapping("/addCustomer")
    public void postMessageOnKafka(@RequestBody Customer customer){
            Customer customerOne = Customer.builder()
                    .id(1)
                    .name(customer.name())
                    .email(customer.email())
                    .username(customer.username())
                    .password(customer.password())
                    .address(customer.address())
                    .build();
            kafkaProducer.sendMessage(topicName, customerOne);


    }

    @GetMapping("/customer")
    public Customer postMessageOnKafka(){
        return Customer.builder()
                .id(1)
                .name("Suvam")
                .email("suvam@gmail.com")
                .username("texas09")
                .password("DmWt1524")
                .build();
    }
}
