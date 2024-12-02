package org.example.day02.utils

fun List<Int>.isIncrementalSequenceWithinBounds(minDiff: Int, maxDiff: Int): Boolean {
    val pairs = this.zipWithNext()
    return pairs.all { pair -> pair.isFirstLessThanSecond() &&  pair.minDiffOf(minDiff) && pair.maxDiffOf(maxDiff)}
}

fun List<Int>.isDecrementalSequenceWithinBounds(minDiff: Int, maxDiff: Int): Boolean {
    val pairs = this.zipWithNext()
    return pairs.all { pair -> pair.isSecondLessThanFirst() &&  pair.minDiffOf(minDiff) && pair.maxDiffOf(maxDiff)}
}