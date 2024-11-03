package fkh.sk.demo.websocketkafka.kafka.controller;

import fkh.sk.demo.websocketkafka.kafka.payload.request.ConsumerProfileRequest;
import fkh.sk.demo.websocketkafka.kafka.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping()
public class ConsumerController {

    private final ConsumerService consumerService;

    @PostMapping("/start")
    public String startConsuming(@RequestBody ConsumerProfileRequest consumerProfileRequest) {
        // Implement logic to start consuming messages from Kafka
        consumerService.startConsuming(consumerProfileRequest.id(), consumerProfileRequest.topics());
        return "Consumer started successfully for topics " + consumerProfileRequest.topics();
    }

    @PostMapping("/stop")
    public String stopConsuming(@RequestBody ConsumerProfileRequest consumerProfileRequest) {
        // Implement logic to stop consuming messages from Kafka
         consumerService.stopConsuming(consumerProfileRequest.id());
        return "Consumer stopped successfully for topic " + consumerProfileRequest.topics();
    }
}
