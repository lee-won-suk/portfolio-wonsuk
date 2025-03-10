package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Achievement
import com.wonsuk.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Link>

}

