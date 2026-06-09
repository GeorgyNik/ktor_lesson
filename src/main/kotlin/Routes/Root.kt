package com.example.Routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.root() {
    get("/"){
        call.respond(message = "Welcome to App", status = HttpStatusCode.OK)
    }
}