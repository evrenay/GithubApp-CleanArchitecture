package com.evren.github.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

fun <T> Flow<Resource<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<Resource<T>> =
    transform { value ->
        if (value is Resource.Success) {
            action(value.data)
        }
        return@transform emit(value)
    }

fun <T> Flow<Resource<T>>.doOnStatusChanged(action: suspend (Status) -> Unit): Flow<Resource<T>> =
    transform { value ->
        when (value) {
            is Resource.Success -> action(Status.Content)
            is Resource.Error -> action(Status.Error(value.exception))
            Resource.Loading -> action(Status.Loading)
        }
        return@transform emit(value)
    }