package com.example.springboard.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class RestController {

    @GetMapping ("/api/")
    fun helloInternet () : String {
        return "Hello Internet"
    }

}