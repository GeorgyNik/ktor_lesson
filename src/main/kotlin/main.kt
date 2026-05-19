package com.example

import io.ktor.server.engine.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args) //io.ktor.server.netty - пакет, содержащий реализацию ktor для сервера
                                                // EngineMain - класс, который запускает и настраивет сервер на базе netty
                                                //main(args) - передаем параметры, с которым работает сервис и блокируем завершение работы сервиса
}
