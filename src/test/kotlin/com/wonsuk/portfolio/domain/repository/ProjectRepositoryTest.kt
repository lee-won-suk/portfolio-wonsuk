package com.wonsuk.portfolio.domain.repository



import com.wonsuk.portfolio.domain.constant.SkillType
import com.wonsuk.portfolio.domain.entity.*
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import kotlin.test.Test

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectRepositoryTest(
    @Autowired
    val projectRepository: ProjectRepository,
    @Autowired
    val skillRepository: SkillRepository,

) {

    val DATA_SIZE = 10

    private fun createProject(n: Int): Project {
        val project = Project(
            name = "${n}",
            description = "테스트 설명 ${n}",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )

        val details = mutableListOf<ProjectDetail>()
        for (i in 1..n) {
            val projectDetail =
                ProjectDetail(
                    content = "테스트${i}",
                    isActive = true,
                    url = null
                )
            details.add(projectDetail)
        }
        project.addDetails(details)

        val skills = skillRepository.findAll()
        val skillsUsedInProject = skills.subList(0, n)
        for (skill in skillsUsedInProject) {
            project.skills.add(ProjectSkill(project = project, skill = skill))
        }
        return project
    }


    @BeforeAll
    fun beforeAll() {
        println("--- skill 데이터 초기화 ")
        val skills = mutableListOf<Skill>()
        for (i in 1..DATA_SIZE) {
            val skillType = SkillType.values()
            val skill = Skill(
                name = "테스트 ${i}",
                type = skillType[i % skillType.size].name,// enum을 인덱스 안넘어가게 가져오는 방법
                isActive = true
            )
            skills.add(skill)
        }
        skillRepository.saveAll(skills)
        println("--- skill 데이터 초기화  종료")

        println("--- 데이터 초기화 시작")
        val projects = mutableListOf<Project>()
        for (i in 1..DATA_SIZE) {
            projects.add(createProject(i))
        }
        projectRepository.saveAll(projects)
        println("--- 데이터 초기화 종료")
    }

    @Test
    fun testFindAll() {
        println("--- findAll 시작")
        val projects = projectRepository.findAll()
        assertThat(projects).hasSize(DATA_SIZE)
        println("projects.size: ${projects.size}")

        for (project in projects) {
            assertThat(project.details).hasSize(project.name.toInt())
            println("project.details.size: ${project.details.size}")

            assertThat(project.skills).hasSize(project.skills.size)
            println("project.skills.size: ${project.details.size}")

        }
        println("--- findAll 종료")
    }



    @Test
    fun testFindAllByIsActive() {
        println("--- findAllByIsActive 시작")
        val projects = projectRepository.findAllByIsActive(true)
        assertThat(projects).hasSize(DATA_SIZE)
        println("projects.size: ${projects.size}")

        for (project in projects) {
            assertThat(project.details).hasSize(project.name.toInt())
            println("project.details.size: ${project.details.size}")

            assertThat(project.skills).hasSize(project.skills.size)
            println("project.skills.size: ${project.details.size}")
        }
        println("--- findAllByIsActive 종료")
    }
}

