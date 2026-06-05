package com.example.Routes

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllHeroes(heroRepository: HeroRepository){
    get("/jjk/heroes"){
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)
            val apiResponse = heroRepository.getAllHeroes(page)
            call.respond(message = apiResponse, status = HttpStatusCode.OK)
        } catch (
            e: NumberFormatException
        ) {
            call.respond(message = ApiResponse(message = "Only numbers allowed", success = true), status = HttpStatusCode.BadRequest) //ошибка 400
        } catch (e: IllegalArgumentException) {
            call.respond(message = ApiResponse(message = "Not found", success = false), status = HttpStatusCode.NotFound) //ошибка 404
        }
    }
}