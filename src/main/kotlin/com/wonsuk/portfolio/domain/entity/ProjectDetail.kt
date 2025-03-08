package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectDetail(
    content: String,
    url: String?,
    isActive: Boolean
) : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_detail_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null

    var content: String = content
    var url: String? = url
    var isActive: Boolean = isActive

}
