package org.example.day01

import org.example.common.AoCChallenge
import kotlin.math.abs

class Day01(fileName: String) : AoCChallenge(fileName) {

    private val flatLocationIds = this.inputLines
        .flatMap { line -> line.split("   ") }
        .map { it.toLong() };

    override fun partOne(): Long {
        val sortedIdsPair: Pair<List<Long>, List<Long>> = Pair(
            flatLocationIds.filterIndexed { index, _ -> index % 2 == 0 }.sorted(),
            flatLocationIds.filterIndexed { index, _ -> index % 2 == 1 }.sorted()
        )

        assert(sortedIdsPair.first.size == sortedIdsPair.second.size)

        return sortedIdsPair.first.zip(sortedIdsPair.second)
            .map { (first, second) -> abs(first - second) }
            .reduce(Long::plus).toLong()
    }

    override fun partTwo(): Long {
        val pairOfIdList: Pair<List<Long>, List<Long>> = Pair(
            flatLocationIds.filterIndexed{ index, _ -> index %2 == 0 },
            flatLocationIds.filterIndexed{ index, _ -> index %2 == 1 }
        )

        val countersByIds = pairOfIdList.second.groupingBy { it }.eachCount()

        return pairOfIdList.first
            .map{value ->  value * countersByIds.getOrDefault(value, 0) }
            .reduce(Long::plus)
    }
}