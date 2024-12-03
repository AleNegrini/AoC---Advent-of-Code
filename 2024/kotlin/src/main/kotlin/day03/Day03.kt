package org.example.day03

import org.example.common.AoCChallenge

class Day03(fileName: String) : AoCChallenge(fileName) {

    private val corruptedInstructions: List<String> = this.inputLines

    private val mulRegex = """mul\((\d+),(\d+)\)""".toRegex()
    private val doRegex = """do\(\)""".toRegex()
    private val dontRegex = """don't\(\)""".toRegex()

    override fun partOne(): Long {
        val numbersToMultiply = corruptedInstructions
            .map { line ->
                mulRegex.findAll(line).map { match ->
                    Pair(match.groups[1]!!.value.toInt(), match.groups[2]!!.value.toInt())
                }.toList()
            }

        return numbersToMultiply
            .flatten()
            .map { p -> p.first * p.second }
            .reduce { acc, i -> acc + i }
            .toLong()
    }

    override fun partTwo(): Long {
        var enabled = true
        var sum = 0
        val regs = """${mulRegex}|${doRegex}|${dontRegex}""".toRegex()
        corruptedInstructions.map { line ->
            regs.findAll(line).forEach { match ->
                when (match.value) {
                    "don't()" -> enabled = false
                    "do()" -> enabled = true
                    else -> if(enabled) sum += match.groups[1]!!.value.toInt() * match.groups[2]!!.value.toInt()
                }
            }
        }

        return sum.toLong()
    }
}