package com.miguel.midterm.network

object HttpRoutes {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    // Add API endpoints here
    const val POSTS = "$BASE_URL/posts"

    private const val CUR_BASE_URL = "https://dummyjson.com"
    const val QUOTES = "$CUR_BASE_URL/quotes"
    const val USERS = "$CUR_BASE_URL/users"
    const val RECIPES = "$CUR_BASE_URL/recipes"
    const val TODOS = "$CUR_BASE_URL/todos"
}