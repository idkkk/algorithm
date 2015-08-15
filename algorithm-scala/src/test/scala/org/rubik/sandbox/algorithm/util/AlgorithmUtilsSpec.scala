package org.rubik.sandbox.algorithm.util

import org.scalatest._
import org.rubik.sandbox.algorithm.util.AlgorithmUtils._

class AlgorithmUtilsSpec extends FlatSpec {

  // avg
  "average value" should "sum of numbers / size of numbers" in {
    assert(avg(10) == 10)
    assert(avg(21, 20, 22, 21) == 21)
  }

  it should "0's average value" in {
    assert(avg(0) == 0)
    assert(avg(0.0) == 0.0)
  }

  it should "multi number's average value" in {
    assert(avg(-1, -2, 10, 100) == 26.75)
    assert(avg(-0.2, -0.8, -10, 1000) == 247.25)
  }

  // swapOddAndEven
  "swap odd and even" should "odd digits" in {
    assert(swapOddAndEven(1) == List(1))
    assert(swapOddAndEven(-1, 3, 2) == List(3, -1, 2))
    assert(swapOddAndEven(1, 2, 3, 4, 5) == List(2, 1, 4, 3, 5))
  }

  // fibonacci
  "fibonacci" should "index N numbers" in {
    assert(fibonacci(0) == 1)
    assert(fibonacci(1) == 1)
    assert(fibonacci(10) == 55)
    assert(fibonacci(-2) == 1)
  }

  // fibonacci with tailrec
  "fibonacci with tailrec" should "bigger index N numbers" in {
    assert(fibonacciWithTailRec(100) == BigDecimal("573147844013817084101"))
    assert(fibonacciWithTailRec(500) == BigDecimal("225591516161936330872512695036072072046011324913758190588638866418474627738686883405015987052796968498626"))
  }

  // arithmetic
  "arithmetic" should "equals difference" in {
    assert(arithmetic(0) == 1)
    assert(arithmetic(1) == 1)
    assert(arithmetic(2) == 2)

    assert(arithmetic(1, 2) == 1)
    assert(arithmetic(3, 2) == 5)
    assert(arithmetic(10, 2) == 19)
  }

  // arithmetic with tailrec
  "arithmetic with tailrec" should "foreach" in {
    assert(arithmeticWithTailRec(1, 2) == 1)
    assert(arithmeticWithTailRec(3, 2) == 5)
    assert(arithmeticWithTailRec(1000, 10) == 9991)
  }

  // max sum of sub list
  "sub list" should "max sum" in {
    assert(maxSumOfSubList(1, -5, -2, 8, 13, 20, -40) == 41)
  }

  "the count of coins face" should "counts of coins" in {
    val ints = List(1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1)
    assert(countOfCoins(ints, 1) == 5)
  }

  "top N for word frequency" should "top N" in {
    val words = List("测试", "abc", "xyz", "xYz", "abc", "中国", "China", "测试", "测试abc", "abc", "xzy", "试测", "国中", "中国")
    assert(topNOfWordFrequency(words, 2) == Seq(("abc",3), ("测试",2)))
  }

  "max multiply value of natural numbers" should "max value" in {
    assert(maxMultiplyValueOfNaturalNumber(6) == Seq(1, 2, 3))
    assert(maxMultiplyValueOfNaturalNumber(1000) == Seq(198, 199, 200, 201, 202))
  }

  "the number" should "is prime number" in {
    assert(isPrimeNumber(11) == true)
    assert(isPrimeNumber(1024) == false)
  }

  "combination number" should "max number" in {
    val numbers = List(2, 1, 33, 35, 31, 9, 6, 86, 91, 98, 96, 66, 60, 0, 2)
    assert(maxNumber(numbers) == "998969186666603533312210" )
  }

  "multi List" should "flatten" in {
    val data = List(List(1, 2, 3), List(4, 5), List(6, 7, 8, 9))
    assert(flatten(data) == List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  }

  "nested multi List" should "flatten" in {
    val data = List(List(1, List(2, 3)), List(4, List(5, 6)), List(6, List(7, 8), List(8, 9, 10)))
    assert(flatten(data) == List(1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10))
  }
}