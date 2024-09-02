package ru.pilot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Сервис для отправки сообщений в топик Kafka.
 */
@Service
public class KafkaProducerService {

    /**
     * Шаблон KafkaTemplate для отправки сообщений.
     */
    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Конструктор сервиса продюсера.
     *
     * @param kafkaTemplate Шаблон KafkaTemplate
     */
    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Отправка сообщения в топик "first_topic".
     *
     * @param message Сообщение для отправки
     */
    public void sendMessage(String message) {
        kafkaTemplate.send("first_topic", message);
    }
}