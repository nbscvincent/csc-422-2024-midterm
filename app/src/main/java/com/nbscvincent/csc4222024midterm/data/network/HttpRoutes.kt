package com.nbscvincent.csc4222024midterm.data.network

object HttpRoutes {
    private const val BASEURL: String = "https://dummyjson.com"
    const val login: String = "$BASEURL/auth/login"
    const val quotes: String = "$BASEURL/quotes/random"

    const val recipes: String = "$BASEURL/recipes"
    const val todos: String = "$BASEURL/todos"

    private const val URL = "https://jsonplaceholder.typicode.com"
    const val TODO = "$URL/todos"
}