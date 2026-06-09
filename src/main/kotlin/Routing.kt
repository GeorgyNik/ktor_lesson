package com.example

import com.example.Routes.getAllHeroes
import com.example.Routes.root
import com.example.Routes.searchHeroes
import com.example.repository.HeroRepository
import io.ktor.server.application.*
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val heroRepository: HeroRepository by inject()
    routing {               //функция, которая создает блок для описания маршрута
        //get("/") {          //этот маршрут сработает только на get-запросы. "/" означает, что работает только для корневого адреса
        //    call.respondText("Hello, World!")  //call содержит всю информацию о запросе и об ответе
        //}
        root()


        getAllHeroes(heroRepository)
        searchHeroes(heroRepository)

        static("/images") {
            resources("images")
        }
    }
}