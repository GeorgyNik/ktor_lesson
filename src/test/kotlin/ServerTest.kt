package com.example

import com.example.models.ApiResponse
import com.example.models.Hero
import com.example.repository.HeroRepositoryImpl
import com.example.repository.NEXT_PAGE_KEY
import com.example.repository.PREV_PAGE_KEY
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import kotlin.String
import kotlin.test.*

class ServerTest {

    /*@Test
    fun `test root endpoint`() = testApplication {
        // loads default configuration
        //configure()
        application{module()}
        // verify server root returns 200
        //assertEquals(HttpStatusCode.OK, client.get("/").status)
    }*/

    @Test
    fun `access root endpoint`() = testApplication {
        application { module() }
        client.get(urlString = "/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Welcome to App", bodyAsText())
        }
    }


    private val heroRepository = HeroRepositoryImpl()

    @Test
    fun `access all heroes endpoint, query all pages, assert correct information`() = testApplication {
        application { module() }
        val heroesByPage = listOf(
            heroRepository.page1,
            heroRepository.page2,
            heroRepository.page3,
            heroRepository.page4,
            heroRepository.page5
        )

        (1..5).forEach { page ->
            client.get(urlString = "/jjk/heroes/page=?$page").apply {
                assertEquals(HttpStatusCode.OK, status)
                val pageInfo = calculatePage(page)
                val actual = Json.decodeFromString<ApiResponse>(bodyAsText())
                val expected = ApiResponse(
                    success = true,
                    message = "OK",
                    prevPage = pageInfo[PREV_PAGE_KEY],
                    nextPage = pageInfo[NEXT_PAGE_KEY],
                    heroes = heroesByPage[page-1],
                    lastUpdater = actual.lastUpdater
                )
                assertEquals(expected, actual)
            }
        }
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page

        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }

        if (page == 5) {
            nextPage = null
        }

        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }

        if (page == 1) {
            prevPage = null
        }

        return mapOf(
            PREV_PAGE_KEY to prevPage,
            NEXT_PAGE_KEY to nextPage
        )

    }

}
