package org.lashoo.lyakheyv1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class LyakheyV1Application {

	public static void main(String[] args) {
		SpringApplication.run(LyakheyV1Application.class, args);
	}

}
