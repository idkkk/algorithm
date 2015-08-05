package org.rubik.sandbox.algorithm

import org.scalatest._

class AlgorithmUtilsSpec extends FlatSpec {

  // avg
  "average value" should "sum of numbers / size of numbers" in {
    assert(AlgorithmUtils.avg(10) == 10)
    assert(AlgorithmUtils.avg(21, 20, 22, 21) == 21)
  }

  it should "0's average value" in {
    assert(AlgorithmUtils.avg(0) == 0)
    assert(AlgorithmUtils.avg(0.0) == 0.0)
  }

  it should "multi number's average value" in {
    assert(AlgorithmUtils.avg(-1, -2, 10, 100) == 26.75)
    assert(AlgorithmUtils.avg(-0.2, -0.8, -10, 1000) == 247.25)
  }

  // swapOddAndEven
  "swap odd and even" should "odd digits" in {
    assert(AlgorithmUtils.swapOddAndEven(1) == List(1))
    assert(AlgorithmUtils.swapOddAndEven(-1, 3, 2) == List(3, -1, 2))
    assert(AlgorithmUtils.swapOddAndEven(1, 2, 3, 4, 5) == List(2, 1, 4, 3, 5))
  }

  // fibonacci
  "fibonacci" should "index N numbers" in {
    assert(AlgorithmUtils.fibonacci(0) == 1)
    assert(AlgorithmUtils.fibonacci(1) == 1)
    assert(AlgorithmUtils.fibonacci(10) == 55)
    assert(AlgorithmUtils.fibonacci(-2) == 1)
  }

  // fibonacci with tailrec
  "fibonacci with tailrec" should "bigger index N numbers" in {
    assert(AlgorithmUtils.fibonacciWithTailRec(100) == BigDecimal("573147844013817084101"))
    assert(AlgorithmUtils.fibonacciWithTailRec(500) == BigDecimal("225591516161936330872512695036072072046011324913758190588638866418474627738686883405015987052796968498626"))
  }

  // arithmetic
  "arithmetic" should "equals difference" in {
    assert(AlgorithmUtils.arithmetic(0) == 1)
    assert(AlgorithmUtils.arithmetic(1) == 1)
    assert(AlgorithmUtils.arithmetic(2) == 2)

    assert(AlgorithmUtils.arithmetic(1, 2) == 1)
    assert(AlgorithmUtils.arithmetic(3, 2) == 5)
    assert(AlgorithmUtils.arithmetic(10, 2) == 19)
  }

  // arithmetic with tailrec
  "arithmetic with tailrec" should "foreach" in {
    assert(AlgorithmUtils.arithmeticWithTailRec(1, 2) == 1)
    assert(AlgorithmUtils.arithmeticWithTailRec(3, 2) == 5)
    assert(AlgorithmUtils.arithmeticWithTailRec(1000, 10) == 9991)
  }

  // max sum of sub list
  "sub list" should "max sum" in {
    assert(AlgorithmUtils.maxSumOfSubList(1, -5, -2, 8, 13, 20, -40) == 41)
  }

  "the count of coins face" should "counts of coins" in {
    val ints = List(1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1)
    assert(AlgorithmUtils.countOfCoins(ints, 1) == 5)
  }

  "top N for word frequency" should "top N" in {
    val words = List("测试", "abc", "xyz", "xYz", "abc", "中国", "China", "测试", "测试abc", "abc", "xzy", "试测", "国中", "中国")
    assert(Seq(("abc",3), ("测试",2)) == AlgorithmUtils.topNOfWordFrequency(words, 2))
  }

  "max multiply value of natural numbers" should "max value" in {
    assert(Seq(2, 3) == AlgorithmUtils.maxMultiplyValueOfNaturalNumber(5))
    assert(Seq(198, 199, 200, 201, 202) == AlgorithmUtils.maxMultiplyValueOfNaturalNumber(1000))
  }
}