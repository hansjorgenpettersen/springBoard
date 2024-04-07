package com.example.springboard.controller

import com.example.springboard.models.IpAddress
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.IOException

@RestController
class RestController {

    var homeIpAddress = IpAddress()

    @GetMapping ("/api/")
    fun helloInternet () : String {
        return "Hello Internet"
    }

    @GetMapping ("/api/getHomeIp")
    fun getHomeIp():IpAddress {
        return homeIpAddress
    }
    @GetMapping ("/api/setHomeIp")
    fun setHomeIp():IpAddress {

        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes)
            .request

        homeIpAddress.setIpAddress(request.remoteAddr)
        return homeIpAddress
    }

    //Get JPG IMAGE
    @GetMapping("/image")
    @Throws(IOException::class)
    open fun getFile(@RequestParam(value = "name") name: String): ResponseEntity<InputStreamResource?>? {
        //Get Image using name
        val image = ClassPathResource("/static/public/www/image/$name.jpg")
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
            .body<InputStreamResource>(InputStreamResource(image.inputStream))
    }

}