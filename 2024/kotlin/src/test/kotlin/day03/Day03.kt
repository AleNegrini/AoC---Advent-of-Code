package day02

import org.example.day03.Day03
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03 {
    private val testFilePath = "src/test/resources/day03/input-test.txt"
    private val dayThreeChallenge = Day03(testFilePath)

    @Test
    fun shouldSolveDay01PartOne() {
        val result = dayThreeChallenge.partOne()
        assertEquals(result, 161)
    }

    @Test
    fun shouldSolveDay01PartTwo() {
        val result = dayThreeChallenge.partTwo()
        assertEquals(result, 48)
    }
}