package com.writer0713.kafkapractice.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.writer0713.kafkapractice.dto.OrderDto
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    fun sendMessage(topic: String, orderDto: OrderDto): OrderDto {
        val message = objectMapper.writeValueAsString(orderDto)
        kafkaTemplate.send(topic, message)

        return orderDto
    }
}
