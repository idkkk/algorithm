package org.rubik.sandbox.algorithm

import scala.annotation.tailrec

object NumberUtils {
  def topNOfWordFrequency(words: List[String], n: Int): Seq[(String, Int)] = {
    words.groupBy(word => word).mapValues(_.length).toSeq.sortBy(_._2).reverse.take(n)
  }

  def countOfCoins(numbers: List[Int], valueOfSurface: Int): Int = {
    val result = for(elem <- numbers.sliding(2) if (elem.head == valueOfSurface && elem.head == elem.last)) yield elem
    result.length
  }

  def avg(numbers: BigDecimal*): BigDecimal = {
    numbers.sum / numbers.size
  }

  def swapOddAndEven(numbers: Int*): List[Int] = {
    numbers.sliding(2, 2).flatMap(_.reverse).toList
  }

  def maxSumOfSubList(numbers: Int*): BigInt = {
    val result = for(i <- 1 to numbers.length) yield numbers.sliding(i)
    result.map(subList => subList.map(_.sum)).flatten.max
  }

  def fibonacci(n: Int): BigDecimal = {
    if(n <= 2) 1 else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def fibonacciWithTailRec(n: BigDecimal): BigDecimal = {
    @tailrec
    def go(n: BigDecimal, acc1: BigDecimal, acc2: BigDecimal): BigDecimal = {
      if (n <= 0) acc1 else go(n - 1, acc2, acc1 + acc2)
    }

    go(n, 1, 1)
  }

  def arithmetic(n: Int, step: Int = 1): BigDecimal = {
    if (n <= 1) 1 else arithmetic(n - 1, step) + step
  }

  def arithmeticWithTailRec(n: BigDecimal, step: Int = 1): BigDecimal = {
    @tailrec
    def go(n: BigDecimal, acc: BigDecimal, step: Int = 1): BigDecimal = {
      if (n <= 1) acc else go(n - 1, acc + step, step)
    }

    go(n, 1, step)
  }
}