package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long>
