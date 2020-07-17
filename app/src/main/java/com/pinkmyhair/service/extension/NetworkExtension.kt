package com.pinkmyhair.service.extension

import com.pinkmyhair.entity.Answer
import com.pinkmyhair.entity.FailureReason
import com.pinkmyhair.service.api.HttpErrorException
import retrofit2.Response
import java.io.IOException

fun IOException.throwIOException() =
    Answer.Failure(this, this.message.toString(), FailureReason.NETWORK)

fun <T> Response<T>.throwHttpException(): Answer.Failure {
    val error = HttpErrorException(
        this.code(),
        this.errorBody()?.toString()
    )
    return Answer.Failure(error, error.message.toString(), FailureReason.NETWORK)
}