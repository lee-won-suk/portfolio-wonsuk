package com.wonsuk.portfolio.presentation.service

import com.wonsuk.portfolio.domain.entity.Introduction
import com.wonsuk.portfolio.domain.entity.Link
import com.wonsuk.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    lateinit var presentationService: PresentationService

    // 초기값을 늦추는 것 mock이 만들어진후 초기화하기 위해
    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions() {
        // given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }
        val activeIntroductions = introductions.filter { introduction -> introduction.isActive }
        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeIntroductions)
        //when
        val introductionDTO = presentationService.getIntroductions()
        //then
        assertThat(introductionDTO).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTO) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
        //짝수일때만 isActiove가 true이기 때문에 content도 다 짝수.
    }


    @Test
    fun testGetLinks() {
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }
        val activeLinks = links.filter { link -> link.isActive }

        //when
        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)

        val LinkDTO = presentationService.getLinks()

        //then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }

        assertThat(LinkDTO).hasSize(expectedSize)
        for (linkDTO in LinkDTO) {
            assertThat(linkDTO.content.toInt())
        }


    }
}
