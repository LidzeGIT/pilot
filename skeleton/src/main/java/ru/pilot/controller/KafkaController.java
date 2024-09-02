package ru.pilot.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pilot.producer.KafkaProducerService;

/**
 * Контроллер для обработки запросов, связанных с отправкой сообщений в топик Kafka.
 */
@Tag(name = "KafkaController", description = "")
@RestController
@RequestMapping("api/v1/kafka")
public class KafkaController {

    /**
     * Сервис продюсера для отправки сообщений в топик Kafka.
     */
    private final KafkaProducerService kafkaProducerService;

    /**
     * Конструктор контроллера.
     *
     * @param kafkaProducerService Сервис продюсера
     */
    @Autowired
    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    /**
     * Отправка сообщения в топик Kafka.
     *
     * @param message Сообщение для отправки
     * @return Сообщение об успешной отправке
     */
    @GetMapping("/sendMessage/{message}")
    public String sendMessage(@PathVariable String message) {
        kafkaProducerService.sendMessage(message);
        return "Message sent to Kafka topic: " + message;
    }
}