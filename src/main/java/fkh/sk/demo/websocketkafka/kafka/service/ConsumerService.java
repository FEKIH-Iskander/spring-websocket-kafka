package fkh.sk.demo.websocketkafka.kafka.service;

import fkh.sk.demo.websocketkafka.kafka.entity.KafkaProfile;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConsumerService {

    private final ApplicationContext context;

    @Conditional(DefaultTopicCondition.class)
    @KafkaListener(topics = "${app.consumer.kafka-default-topics}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenToDefaultTopics(ConsumerRecord<String, String> record) {
        System.out.println("----------------->Received message: " + record.value());
    }

    public void startConsuming(String id, String[] topics) {
        context.getBean(KafkaProfile.class, id, topics);
    }

    public void stopConsuming(String id) {
    }

}
