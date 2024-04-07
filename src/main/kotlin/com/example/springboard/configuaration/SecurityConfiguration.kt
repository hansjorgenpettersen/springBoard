package com.example.springboard.configuaration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Configuration
class SecurityConfiguration {
    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity -> web.ignoring().requestMatchers("/public/**") }
    }

    @Bean
    fun userDetailsService(): InMemoryUserDetailsManager? {
        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username("apiUser")
            .password("thisisapasswordfortheapiuser")
            .roles("admin")
            .build()
        return InMemoryUserDetailsManager(user)
    }
}