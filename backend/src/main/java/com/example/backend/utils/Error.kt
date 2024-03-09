package com.example.backend.utils

class NetworkException(
    override val message: String?,
    override val cause: Throwable,
) : Exception(message, cause)

class AuthException(
    override val message: String?,
    override val cause: Throwable,
) : Exception(message, cause)

class NoNetworkException(
    override val message: String?,
    override val cause: Throwable
) : Exception(message, cause)

class NetworkError(val errorCode: Int) : Throwable()