package com.apjake.codetestmovielist.common.util

fun Boolean?.orFalse(): Boolean = this ?: false
fun Double?.orZero(): Double = this?:0.0
fun Int?.orZero(): Int = this?:0

fun String?.orUnhandledError(): String = this?: "Unhandled Error"

fun Double.toPercentString(): String = "${(this*10).toInt()} %"

fun String.fullPosterPath(): String = "https://image.tmdb.org/t/p/original/${this}"
fun String.thumbPosterPath(): String = "https://image.tmdb.org/t/p/w200/${this}"
