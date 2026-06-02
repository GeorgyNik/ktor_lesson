package com.example.plugins

import io.ktor.http.HttpHeaders
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import kotlin.time.Duration.Companion.days

fun Application.configureDefaultHeaders() {

    install(DefaultHeaders) {
        val oneYearInSeconds = 365.days.inWholeSeconds
        header(name = HttpHeaders.CacheControl, value = "public max age = $oneYearInSeconds, immutable") // will send this header with each response
    }
}