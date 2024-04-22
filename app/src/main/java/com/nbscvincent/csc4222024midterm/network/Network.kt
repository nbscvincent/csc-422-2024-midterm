package com.nbscvincent.csc4222024midterm.network


import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.json.Json
import javax.inject.Singleton

object HttpRoutes {
    private const val BASEURL: String = "https://dummyjson.com"
    const val login: String = "$BASEURL/auth/login"
    const val quotes: String = "$BASEURL/quotes/random"
    const val todos: String = "$BASEURL/todos"
    const val recipes: String = "$BASEURL/recipes"
}


@Singleton
fun KtorClient(): HttpClient {
    return HttpClient(Android) {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("SAMPLE  HTTP call $message")
                }
            }
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json( Json {
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
                ignoreUnknownKeys = true

            })
        }
        install(HttpRedirect) {
            checkHttpMethod = false
            allowHttpsDowngrade = true
        }
    }
}
