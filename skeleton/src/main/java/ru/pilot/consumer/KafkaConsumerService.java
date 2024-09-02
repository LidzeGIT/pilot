package ru.pilot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Сервис для обработки сообщений от Kafka консюмера.
 */
@Service
public class KafkaConsumerService {

    /**
     * Метод, который будет вызван при получении сообщения из топика "first_topic".
     *
     * @param message Полученное сообщение
     */
    @KafkaListener(topics = "first_topic", groupId = "your-group-id", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Received Message in group 'your-group-id': " + message);
        // Обработайте полученное сообщение по вашему усмотрению
    }
}