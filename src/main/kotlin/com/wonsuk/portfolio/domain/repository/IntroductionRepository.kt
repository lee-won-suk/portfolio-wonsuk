package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Achievement
import com.wonsuk.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long>{
    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}
