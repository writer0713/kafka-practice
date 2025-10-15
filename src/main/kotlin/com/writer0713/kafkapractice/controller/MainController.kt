package com.writer0713.kafkapractice.controller

import com.writer0713.kafkapractice.dto.OrderDto
import com.writer0713.kafkapractice.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = ["/api/orders"])
@RestController
class MainController(
    private val orderService: OrderService
) {

    @PostMapping("")
    fun makeOrder(@RequestBody orderDto: OrderDto): OrderDto {
        val topic = "order.create_1"
        return orderService.sendMessage(topic, orderDto)
    }
}
