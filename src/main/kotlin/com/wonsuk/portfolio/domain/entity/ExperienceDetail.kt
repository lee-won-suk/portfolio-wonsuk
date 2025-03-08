package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(
    content: String,
    isActive: Boolean
) : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null

    var content: String = content

    var isActive: Boolean = isActive

    fun update(content: String, isActive: Boolean) {
        this.content = content
        this.isActive = isActive
    }
}
