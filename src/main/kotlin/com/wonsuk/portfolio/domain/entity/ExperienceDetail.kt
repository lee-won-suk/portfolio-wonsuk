package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null


}
