package fkh.sk.demo.websocketkafka.kafka.controller;

import fkh.sk.demo.websocketkafka.kafka.payload.request.ProducerMessageRequest;
import fkh.sk.demo.websocketkafka.kafka.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping()
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody ProducerMessageRequest producerMessageRequest) {
        producerService.sendMessage(producerMessageRequest.topic(), producerMessageRequest.message());
    }
}
