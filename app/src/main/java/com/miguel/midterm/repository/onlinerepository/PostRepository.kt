package com.miguel.midterm.repository.onlinerepository

import com.miguel.midterm.dataclass.Post

interface PostRepository {

    // Retrieve all posts
    suspend fun getPosts(): List<Post>
}