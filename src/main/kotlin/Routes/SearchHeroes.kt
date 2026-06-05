package com.example.Routes

import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.searchHeroes(heroRepository: HeroRepository) {
    get("/jjk/heroes/search"){
        val name = call.request.queryParameters["name"]
        val apiResponse = heroRepository.searchHeroes(name)
        call.respond(message = apiResponse, status = HttpStatusCode.OK)
    }
    //GET /jjk/heroes/search?name=X
}