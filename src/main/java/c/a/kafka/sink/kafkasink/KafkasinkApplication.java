package c.a.kafka.sink.kafkasink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;

@EnableKafka
@SpringBootApplication
public class KafkasinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkasinkApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



}
