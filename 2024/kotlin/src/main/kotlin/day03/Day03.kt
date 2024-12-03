package org.example.day03

import org.example.common.AoCChallenge

class Day03(fileName: String): AoCChallenge(fileName) {

    private val corruptedInstructions = this.inputLines

    override fun partOne(): Long {
        val matchResults: List<List<Pair<Int, Int>>> = corruptedInstructions.map { line -> val mulRegex = """mul\((\d+),(\d+)\)""".toRegex()
            val matchResult = mulRegex.findAll(line)

            matchResult.forEach { println(it.groups.get(0)) }

            matchResult.map { match ->
                Pair(match.groups[1]!!.value.toInt(), match.groups[2]!!.value.toInt())
            }.toList()

        }

        return matchResults.flatten().map { p -> p.first * p.second }.reduce{acc, i -> acc+i }.toLong()
    }

    override fun partTwo(): Long {
        corruptedInstructions.map { line ->
            val regex = """don't\(\)(.*?)do\(\)""".toRegex()
            val matchResult = regex.findAll(line)

            var newLines = matchResult.map { match ->
                Pair(match.groups[1]!!.value.toInt(), match.groups[2]!!.value.toInt())
            }.toList()
            return 1L;

        }
        return 1L;
    }


}