package com.pinkmyhair.entity

sealed class Answer<out T : Any> {

    val isSuccess: Boolean
        get() = this is Success

    val isFailure: Boolean
        get() = this is Failure

    data class Success<T : Any>(val value: T) : Answer<T>()
    data class Failure(val error: Throwable, val message: String, val type: FailureReason?) : Answer<Nothing>()
}

enum class FailureReason {
    NETWORK,
    CACHE
}