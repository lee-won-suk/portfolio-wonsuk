package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>
