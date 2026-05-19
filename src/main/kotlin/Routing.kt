package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {               //функция, которая создает блок для описания маршрута
        get("/") {          //этот маршрут сработает только на get-запросы. "/" означает, что работает только для корневого адреса
            call.respondText("Hello, World!")  //call содержит всю информацию о запросе и об ответе
        }
    }
}