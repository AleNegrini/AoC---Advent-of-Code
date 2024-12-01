package org.example.common

import java.io.File

abstract class AoCChallenge(
    private val filePath: String
) {

    val inputLines: List<String> = readInput()

    private fun readInput(): List<String> {
        val file = File(filePath)
        if (!file.exists()) {
            throw IllegalArgumentException("Input file not found: $filePath")
        }
        return file.useLines { it.toList() }
    }

    /**
     * Abstract method for Part One solution
     */
    abstract fun partOne(): Long

    /**
     * Abstract method for Part Two solution
     */
    abstract fun partTwo(): Long

}