package com.shareloc.server.web.rest;

import com.shareloc.server.service.ShareLocServerKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/share-loc-server-kafka")
public class ShareLocServerKafkaResource {

    private final Logger log = LoggerFactory.getLogger(ShareLocServerKafkaResource.class);

    private ShareLocServerKafkaProducer kafkaProducer;

    public ShareLocServerKafkaResource(ShareLocServerKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
