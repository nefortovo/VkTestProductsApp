package com.example.impl.base

import com.example.backend.utils.NetworkException
import com.example.backend.utils.NoNetworkException
import com.example.backend.utils.ResponseStatus
import com.example.base.entities.Entity
import com.example.impl.base.ResponseCodes.SERVER_ERROR_CODE
import com.example.impl.base.ResponseCodes.SUCCESS_CODES
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

open class BaseRepository(
    private val repository: String = TAG,
) {
    protected suspend fun <K : Any> safeApiSuspendResult(call: suspend () -> Response<K>?): ResponseStatus<K> {
        val response: Response<K>?
        return try {
            response = call.invoke()
            when (response?.code()) {
                in SUCCESS_CODES -> {
                    if (response?.isSuccessful == true) {
                        ResponseStatus.Success(
                            data = response.body(),
                            code = response.code()
                        )
                    } else {
                        ResponseStatus.Error(
                            exception = NetworkException(
                                message = response?.message(),
                                cause = Throwable(repository)
                            )
                        )
                    }

                }

                in SERVER_ERROR_CODE -> {
                    LocalBroadcastManager._error.emit(
                        ErrorStatus.Network(
                            response?.message() ?: ""
                        )
                    )
                    ResponseStatus.Error(
                        NetworkException(
                            response?.message(),
                            Throwable(repository),
                        )
                    )
                }


                else -> {
                    LocalBroadcastManager._error.emit(
                        ErrorStatus.Network(
                            response?.message() ?: ""
                        )
                    )
                    ResponseStatus.Error(
                        NetworkException(
                            response?.message(),
                            Throwable(repository),
                        )
                    )
                }
            }
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException -> {
                    LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                    ResponseStatus.Error(
                        NoNetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }

                is HttpException -> {
                    LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                    ResponseStatus.Error(
                        NetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }


                else -> {
                    LocalBroadcastManager._error.emit(ErrorStatus.Network(e.message ?: ""))
                    ResponseStatus.Error(
                        NetworkException(
                            e.message,
                            Throwable(repository),
                        )
                    )
                }
            }
        }
    }

    protected fun <G : Any> map(call: () -> G): Entity<G> {
        return try {
            Entity.Success(
                call.invoke()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Entity.Error("Произошла ошибка")
        }
    }


    companion object {
        private const val TAG = "Repository"
    }


}