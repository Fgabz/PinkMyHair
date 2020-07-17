package com.pinkmyhair.service.api

class HttpErrorException(val httpCode: Int, message: String?) : Exception(message)