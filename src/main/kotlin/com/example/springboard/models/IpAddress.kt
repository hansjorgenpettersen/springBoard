package com.example.springboard.models

import java.time.LocalDateTime

class IpAddress {

    var ip = "Not Set"
    var lastUpdated = "Not Set"

    fun setIpAddress(ip:String) {
        if(this.ip != ip ) {
            this.ip = ip;
            this.lastUpdated = LocalDateTime.now().toString()
        }
    }
}