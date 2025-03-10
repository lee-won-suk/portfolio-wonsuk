package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectRepository : JpaRepository<Project, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Project>

/*    override fun findById(id: Long): Optional<Project>*/
}
