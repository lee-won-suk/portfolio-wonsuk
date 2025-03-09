package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate,
    host: String,
    isActive: Boolean
) : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null

    var title: String = title

    var description: String = description

    var achievedDate: LocalDate = achievedDate

    var host: String = host

    var isActive: Boolean = isActive

}
