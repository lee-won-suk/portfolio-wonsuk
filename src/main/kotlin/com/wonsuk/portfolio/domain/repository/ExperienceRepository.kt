package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Experience
import com.wonsuk.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository : JpaRepository<Experience, Long>{

    fun findAllByIsActive(isActive: Boolean): List<Experience>
}
