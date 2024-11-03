package fkh.sk.demo.websocketkafka.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;

@AllArgsConstructor
@Getter
public class KafkaProfile {
    private final String id;
    private final String[] topics;

    @KafkaListener(id = "#{__listener.id}", topics = "#{__listener.topics}", groupId = "dev-grp")
    public void listen(String in) {
        System.out.println("===>" + in);
    }
}
