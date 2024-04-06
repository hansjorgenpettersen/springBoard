package com.example.springboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBoardApplication

fun main(args: Array<String>) {
    runApplication<SpringBoardApplication>(*args)
}
