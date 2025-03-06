package com.wonsuk.portfolio.domain.repository

import com.wonsuk.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long>
