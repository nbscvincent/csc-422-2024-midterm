package com.nbscvincent.csc4222024midterm.data.network

object HttpRoutes {
    private const val BASEURL: String = "https://dummyjson.com"
    const val login: String = "$BASEURL/auth/login"
    const val quotes: String = "$BASEURL/quotes/random"

    const val recipes: String = "$BASEURL/recipes"


    private const val TODO: String = "https://dummyjson.com"
    const val todos: String = "$TODO/todos"
}