package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>
