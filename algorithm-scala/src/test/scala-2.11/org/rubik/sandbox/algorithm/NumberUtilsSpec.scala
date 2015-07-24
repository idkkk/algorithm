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
    assert(NumberUtils.fibonacciWithTailRec(2000) == BigDecimal("6835702259575806647045396549170580107055408029365524565407553367798082454408054014954534318953113802726603726769523447478238192192714526677939943338306101405105414819705664090901813637296453767095528104868264704914433529355579148731044685634135487735897954629842516947101494253575869699893400976539545740214819819151952085089538422954565146720383752121972115725761141759114990448978941370030912401573418221496592822626"))
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
  "arithmetic with tailrec" should "equals difference" in {
    assert(NumberUtils.arithmeticWithTailRec(1, 2) == 1)
    assert(NumberUtils.arithmeticWithTailRec(3, 2) == 5)
    assert(NumberUtils.arithmeticWithTailRec(1000, 10) == 9991)
  }

  // max sum of sub list
  "sub list" should "max sum" in {
    assert(NumberUtils.maxSumOfSubList(1, -5, -2, 8, 13, 20, -40) == 41)
  }
}