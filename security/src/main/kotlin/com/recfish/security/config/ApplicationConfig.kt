package com.recfish.security.config

import com.recfish.security.dao.Users

import com.recfish.security.services.userRepository
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.*


@Configuration
@RequiredArgsConstructor
class ApplicationConfig(private val userRepository: userRepository) {
    @Bean
    fun userDetailsService(): UserDetailsService? {
        return UserDetailsService { username: String ->
            userRepository.findByEmail(username) ?: throw UsernameNotFoundException("User not found")
        }
    }
}