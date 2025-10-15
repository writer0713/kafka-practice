package com.writer0713.kafkapractice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class KafkaPracticeApplication

fun main(args: Array<String>) {
    runApplication<KafkaPracticeApplication>(*args)
}
