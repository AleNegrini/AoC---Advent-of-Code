package day02

import org.example.day03.Day03
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03 {

    @Test
    fun shouldSolveDay01PartOne() {
        val testFilePath = "src/test/resources/day03/input-test.txt"
        val dayThreeChallenge = Day03(testFilePath)
        val result = dayThreeChallenge.partOne()
        assertEquals(result, 161)
    }

    @Test
    fun shouldSolveDay01PartTwo() {
        val testFilePath = "src/test/resources/day03/input-test-2.txt"
        val dayThreeChallenge = Day03(testFilePath)
        val result = dayThreeChallenge.partTwo()
        assertEquals(result, 48)
    }
}