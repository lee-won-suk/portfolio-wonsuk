package com.wonsuk.portfolio.presentation.repository

import com.wonsuk.portfolio.domain.entity.*
import com.wonsuk.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val skillRepository: SkillRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperiences(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroductions(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveSkills(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

    fun getActiveLinks(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveProjects(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }


}
