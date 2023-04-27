package com.recfish.security.services

import com.recfish.security.dao.Users
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface userRepository : JpaRepository<Users, Int> {
    fun findByEmail(email: String): Optional<Users>
}