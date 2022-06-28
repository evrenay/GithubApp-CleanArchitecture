package com.evren.github.common

interface Mapper<In, Out> {
    fun map(input: In): Out
}
