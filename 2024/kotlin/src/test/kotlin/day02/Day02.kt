package day02

import org.example.day02.Day02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02 {
    private val testFilePath = "src/test/resources/day02/input-test.txt"
    private val dayTwoChallenge = Day02(testFilePath)

    @Test
    fun shouldSolveDay01PartOne() {
        val result = dayTwoChallenge.partOne()
        assertEquals(result, 2)
    }

    @Test
    fun shouldSolveDay01PartTwo() {
        val result = dayTwoChallenge.partTwo()
        assertEquals(result, 4)
    }
}