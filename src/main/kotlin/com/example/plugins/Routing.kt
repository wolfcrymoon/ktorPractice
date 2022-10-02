package com.example.plugins

import com.example.data.Problem
import com.example.data.TestCase
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.configureRouting() {

    val client = HttpClient(Apache) {
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    val testProblems = Collections.synchronizedList(
        mutableListOf(
            Problem(
                "101",
                "A + B Problem",
                "輸入兩數，將兩數加總。",
                listOf(
                    TestCase(
                        "3 4",
                        "7",
                        "",
                        50,
                        10.0
                    ),
                    TestCase(
                        "2147483646 1",
                        "2147483647",
                        "",
                        50,
                        10.0
                    )
                )
            ),
            Problem(
                "102",
                "A + B + C Problem",
                "輸入三數，將三數加總。",
                listOf(
                    TestCase(
                        "3 4 5",
                        "12",
                        "",
                        50,
                        10.0
                    ),
                    TestCase(
                        "2147483646 1 -1",
                        "2147483646",
                        "",
                        50,
                        10.0
                    )
                )
            )
        )
    )



    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/problems") {
            call.respond(
                mapOf(
                    "data" to testProblems
                )
            )
        }
    }


}

fun createQ() {

}
