package com.example.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.calllogging.CallLogging

fun Application.configureMonitoring() {
    install(CallLogging)
}
//логируются методы http запросов, также обрабатываются url запросы, статусы ответа сервера, время обработки запроса