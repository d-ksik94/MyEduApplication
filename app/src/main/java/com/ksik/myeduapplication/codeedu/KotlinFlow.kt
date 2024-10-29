package com.ksik.myeduapplication.codeedu

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import java.time.ZonedDateTime
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

var aa: Job? = null
var start: Int? = null
suspend fun main() {
    coroutineScope {
        aa = launch(Dispatchers.IO) {
            tickerFlow(5.toDuration(DurationUnit.SECONDS)).collect() { result ->
                println("$result")
                println("$start/${result.minute}")
                if (start == null) start = result.minute
                else start?.takeIf { it < result.minute }?.run {
                    println("cancel()")
                    aa?.cancel()
                }
            }
        }
    }
}

fun tickerFlow(period: Duration, initialDelay: Duration = Duration.ZERO) = flow {
    delay(initialDelay)
    while (true) {
        emit(ZonedDateTime.now())
        delay(period)
    }
}.filterNotNull()