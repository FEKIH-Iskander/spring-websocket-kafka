package fkh.sk.demo.websocketkafka;

import fkh.sk.demo.websocketkafka.kafka.entity.KafkaProfile;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	KafkaProfile kafkaProfile(String id, String[] topics) {
		return new KafkaProfile(id, topics);
	}

	@Bean
	public ApplicationRunner runner(ApplicationContext context) {
		return args -> {
//			context.getBean(KafkaProfile.class, "public", new String[] { "common" });
//			context.getBean(KafkaProfile.class, "grp", new String[] { "grp1", "grp2" });
		};
	}

}
