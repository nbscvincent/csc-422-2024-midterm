package com.bonaagua.midterm.data.posts.repository

import com.bonaagua.midterm.data.posts.model.Post

interface PostRepository {

    // Retrieve all posts
    suspend fun getPosts(): List<Post>
}