package com.example

import com.example.data.Problem
import com.example.data.TestCase
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import java.util.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
    }.start(wait = true)

}
