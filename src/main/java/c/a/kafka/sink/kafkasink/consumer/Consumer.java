package c.a.kafka.sink.kafkasink.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Consumer {
    @Value("${topic.name.consumer}")
    private String topicName;//application.yml

    @Autowired
    private RestTemplate restTemplate;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload){
        System.out.println("***************Received*********************");
        System.out.println("************************************");
        System.out.printf("Topic: %s\n", topicName);
        System.out.printf("key: %s\n", payload.key());
        System.out.printf("Headers: %s\n", payload.headers());
        System.out.printf("partition: %s\n", payload.partition());
        System.out.printf("Message: %s\n", payload.value());
        System.out.println("************************************");
        String message = payload.value();
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/thirdparty", message, String.class);

        System.out.println("THIRD PARTY RESPONSE "+ response.getBody());
    }
}
