package com.nbscvincent.csc4222024midterm.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseQoutes(
    var id: Int,
    var quote: String,
    var author: String,
)
