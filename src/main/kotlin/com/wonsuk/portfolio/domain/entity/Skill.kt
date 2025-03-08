package com.wonsuk.portfolio.domain.entity

import com.wonsuk.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean,
) : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null

    var name : String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type : SkillType = SkillType.valueOf(type)

    var isActive : Boolean = isActive




}
