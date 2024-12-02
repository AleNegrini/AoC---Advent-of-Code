package org.example

import org.example.day01.Day01
import org.example.day02.Day02

fun main() {
    println("Day01 - part 1: " + Day01("src/main/resources/day01/input.txt").partOne())
    println("Day01 - part 2: " + Day01("src/main/resources/day01/input.txt").partTwo())
    println("Day02 - part 1: " + Day02("src/main/resources/day02/input.txt").partOne())
    println("Day02 - part 2: " + Day02("src/main/resources/day02/input.txt").partTwo())
}