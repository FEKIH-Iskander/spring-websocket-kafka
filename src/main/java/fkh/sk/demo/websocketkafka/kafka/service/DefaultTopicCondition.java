package fkh.sk.demo.websocketkafka.kafka.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DefaultTopicCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String defaultTopics = System.getenv("KAFKA_DEFAULT_TOPICS");
        return defaultTopics != null && !defaultTopics.isBlank();
    }
}
