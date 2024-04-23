package com.nbscvincent.csc4222024midterm.data.posts.repository

import com.nbscvincent.csc4222024midterm.data.posts.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}