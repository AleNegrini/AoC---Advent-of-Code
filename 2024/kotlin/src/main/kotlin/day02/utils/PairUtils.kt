package org.example.day02.utils

import kotlin.math.abs

fun Pair<Int, Int>.isFirstLessThanSecond(): Boolean {
    return this.first < this.second
}

fun Pair<Int, Int>.isSecondLessThanFirst(): Boolean {
    return this.first > this.second
}

fun Pair<Int, Int>.maxDiffOf(value: Int): Boolean {
    return abs(this.first - this.second) <= value
}

fun Pair<Int, Int>.minDiffOf(value: Int): Boolean {
    return abs(this.first - this.second) >= value
}

