package com.wonsuk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(
    project: Project,
    skill: Skill
) : BaseEnitity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id") // id를 안쓰는 이유는 achive2개뭍이는게 별로라서
    var id: Long? = null

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    var project: Project = project

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill

}
