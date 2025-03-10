package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository : JpaRepository<Achievement, Long>
{
    fun findAllByIsActive(isActive: Boolean): List<Achievement>
}
