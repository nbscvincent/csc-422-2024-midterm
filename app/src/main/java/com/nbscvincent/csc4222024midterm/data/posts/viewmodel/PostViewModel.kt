package com.nbscvincent.csc4222024midterm.data.posts.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscvincent.csc4222024midterm.data.posts.model.Post
import com.nbscvincent.csc4222024midterm.data.posts.repository.PostRepository

class PostViewModel(private val postRepository: PostRepository): ViewModel() {
    var postsUiState by mutableStateOf(PostsUiState())

    suspend fun getPosts() {
        val posts = postRepository.getPosts()
        postsUiState =
            PostsUiState(posts = posts)
        Timber.i("postsUiState $postsUiState")
    }

    data class PostsUiState(
        var posts: List<Post> = emptyList()
    )
}