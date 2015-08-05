package org.rubik.sandbox.algorithm

import org.scalatest._

class NumberUtilsSpec extends FlatSpec {

  // avg
  "average value" should "sum of numbers / size of numbers" in {
    assert(NumberUtils.avg(10) == 10)
    assert(NumberUtils.avg(21, 20, 22, 21) == 21)
  }

  it should "0's average value" in {
    assert(NumberUtils.avg(0) == 0)
    assert(NumberUtils.avg(0.0) == 0.0)
  }

  it should "multi number's average value" in {
    assert(NumberUtils.avg(-1, -2, 10, 100) == 26.75)
    assert(NumberUtils.avg(-0.2, -0.8, -10, 1000) == 247.25)
  }

  // swapOddAndEven
  "swap odd and even" should "odd digits" in {
    assert(NumberUtils.swapOddAndEven(1) == List(1))
    assert(NumberUtils.swapOddAndEven(-1, 3, 2) == List(3, -1, 2))
    assert(NumberUtils.swapOddAndEven(1, 2, 3, 4, 5) == List(2, 1, 4, 3, 5))
  }

  // fibonacci
  "fibonacci" should "index N numbers" in {
    assert(NumberUtils.fibonacci(0) == 1)
    assert(NumberUtils.fibonacci(1) == 1)
    assert(NumberUtils.fibonacci(10) == 55)
    assert(NumberUtils.fibonacci(-2) == 1)
  }

  // fibonacci with tailrec
  "fibonacci with tailrec" should "bigger index N numbers" in {
    assert(NumberUtils.fibonacciWithTailRec(100) == BigDecimal("573147844013817084101"))
    assert(NumberUtils.fibonacciWithTailRec(500) == BigDecimal("225591516161936330872512695036072072046011324913758190588638866418474627738686883405015987052796968498626"))
  }

  // arithmetic
  "arithmetic" should "equals difference" in {
    assert(NumberUtils.arithmetic(0) == 1)
    assert(NumberUtils.arithmetic(1) == 1)
    assert(NumberUtils.arithmetic(2) == 2)

    assert(NumberUtils.arithmetic(1, 2) == 1)
    assert(NumberUtils.arithmetic(3, 2) == 5)
    assert(NumberUtils.arithmetic(10, 2) == 19)
  }

  // arithmetic with tailrec
  "arithmetic with tailrec" should "foreach" in {
    assert(NumberUtils.arithmeticWithTailRec(1, 2) == 1)
    assert(NumberUtils.arithmeticWithTailRec(3, 2) == 5)
    assert(NumberUtils.arithmeticWithTailRec(1000, 10) == 9991)
  }

  // max sum of sub list
  "sub list" should "max sum" in {
    assert(NumberUtils.maxSumOfSubList(1, -5, -2, 8, 13, 20, -40) == 41)
  }

  "the count of coins face" should "counts of coins" in {
    val ints = List(1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1)
    assert(NumberUtils.countOfCoins(ints, 1) == 5)
  }

  "top N for word frequency" should "top N" in {
    val words = List("测试", "abc", "xyz", "xYz", "abc", "中国", "China", "测试", "测试abc", "abc", "xzy", "试测", "国中", "中国")
    assert(Seq(("abc",3), ("测试",2)) == NumberUtils.topNOfWordFrequency(words, 2))
  }

  "max multiply value of natural numbers" should "none" in {
    assert(None == NumberUtils.maxMultiplyValueOfNaturalNumber(2))
  }

  "max multiply value of natural numbers" should "max value" in {
    assert(Seq(198, 199, 200, 201, 202) == NumberUtils.maxMultiplyValueOfNaturalNumber(1000))
  }
}