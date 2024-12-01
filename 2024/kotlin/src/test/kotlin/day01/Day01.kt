package day01

import org.example.day01.Day01
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01 {

    private val testFilePath = "src/test/resources/day01/input-test.txt"
    private val dayOneChallenge = Day01(testFilePath)

    @Test
    fun shouldSolveDay01PartOne() {
        val result = dayOneChallenge.partOne()
        assertEquals(result, 11)
    }

    @Test
    fun shouldSolveDay01PartTwo() {
        val result = dayOneChallenge.partTwo()
        assertEquals(result, 31)
    }
}