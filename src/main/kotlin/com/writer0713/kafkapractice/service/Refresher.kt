package com.writer0713.kafkapractice.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class Refresher {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    @Async
    fun refresh() {
        Thread.sleep(2000L)
        log.info { "Done processing order.." }
    }
}
