package org.example.day02

import org.example.common.AoCChallenge
import org.example.day02.utils.*

class Day02(fileName: String) : AoCChallenge(fileName) {

    private val listOfSequences: List<List<Int>> = this.inputLines
        .map { line -> line.split("\\s".toRegex()) }
        .map { it.map { n -> n.toInt() } }

    private val listOfPairs: List<List<Pair<Int, Int>>> = listOfSequences
        .map { numberList -> numberList.zipWithNext() }

    private val MIN_BOUND = 1
    private val MAX_BOUND = 3

    override fun partOne(): Long {

        val sequences = listOfSequences
            .map { sequence ->
                (sequence.isIncrementalSequenceWithinBounds(
                    MIN_BOUND,
                    MAX_BOUND
                ) || sequence.isDecrementalSequenceWithinBounds(MIN_BOUND, MAX_BOUND))
            }
            .map { isSafe -> if (isSafe) LevelType.SAFE else LevelType.UNSAFE }

        return sequences
            .count { inc -> inc == LevelType.SAFE }
            .toLong()
    }

    override fun partTwo(): Long {
        val resultsIncreasing = listOfSequences
            .map { sequence -> sequence.isIncrementalSequenceWithinBounds(MIN_BOUND, MAX_BOUND) }
            .map { isSafe -> if (isSafe) LevelType.SAFE else LevelType.UNSAFE }

        val resultsDecreasing = listOfSequences
            .map { sequence -> sequence.isDecrementalSequenceWithinBounds(MIN_BOUND, MAX_BOUND) }
            .map { isSafe -> if (isSafe) LevelType.SAFE else LevelType.UNSAFE }

        val tentativeResultsIncreasing: List<LevelType> = resultsIncreasing.mapIndexed { index, levelType ->
            if (levelType == LevelType.UNSAFE && resultsDecreasing[index] == LevelType.UNSAFE) {
                val candidateToRemove = listOfPairs[index].indexOfFirst { pair -> !(pair.isFirstLessThanSecond() && pair.minDiffOf(1) && pair.maxDiffOf(3)) }
                val newPairs1 = listOfSequences[index].filterIndexed { idx, _ -> idx != candidateToRemove }.zipWithNext()
                val newPairs2 = listOfSequences[index].filterIndexed { id, _ -> id != candidateToRemove + 1 }.zipWithNext()

                if (newPairs1.all { pair1 -> pair1.isFirstLessThanSecond() && pair1.minDiffOf(1) && pair1.maxDiffOf(3) } || newPairs2.all { pair2 -> pair2.isFirstLessThanSecond() && pair2.minDiffOf(1) && pair2.maxDiffOf(3) }) {
                    LevelType.SAFE
                }
                LevelType.UNSAFE
            } else {
                LevelType.UNSAFE
            }
        }

        val tentativeResultsDecreasing: List<LevelType> = resultsDecreasing.mapIndexed { index, levelType ->
            if (levelType == LevelType.UNSAFE && resultsIncreasing[index] == LevelType.UNSAFE) {
                val candidateToRemove = listOfPairs[index].indexOfFirst { pair -> !(pair.isSecondLessThanFirst() && pair.minDiffOf(1) && pair.maxDiffOf(3)) }
                val newPairs1 = listOfSequences[index].filterIndexed { idx, _ -> idx != candidateToRemove }.zipWithNext()
                val newPairs2 = listOfSequences[index].filterIndexed { id, _ -> id != candidateToRemove + 1 }.zipWithNext()

                if (newPairs1.all { pair1 -> pair1.isSecondLessThanFirst() && pair1.minDiffOf(1) && pair1.maxDiffOf(3) } || newPairs2.all { pair2 -> pair2.isSecondLessThanFirst() && pair2.minDiffOf(1) && pair2.maxDiffOf(3) }) {
                    LevelType.SAFE
                }
                LevelType.UNSAFE
            } else {
                LevelType.UNSAFE
            }
        }

        val coalesced = resultsIncreasing
            .mapIndexed { i, value -> value == LevelType.SAFE || tentativeResultsIncreasing[i] == LevelType.SAFE || tentativeResultsDecreasing[i] == LevelType.SAFE || resultsDecreasing[i] == LevelType.SAFE }

        return coalesced.count { inc -> inc }.toLong()
    }
}