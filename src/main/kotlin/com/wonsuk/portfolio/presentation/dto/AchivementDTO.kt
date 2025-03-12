package com.wonsuk.portfolio.presentation.dto

import org.springframework.context.annotation.Description

data class AchivementDTO(
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String?,

)
