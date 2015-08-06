package org.rubik.sandbox.algorithm

import scala.annotation.tailrec

/**
 * 算法工具类.
 *
 * @author xiajinxin
 * @since 2015-08-05
 */
object AlgorithmUtils {
  def isPrimeNumber(n: Int): Boolean = {
    if (n == 1) true else (2 to n - 1).par.count(n % _ == 0) == 0
  }

  /**
   * 给定任一正整数，求连续自然数之和中乘积最大的那一组自然数
   * @param n 自然数 （n >= 6）
   * @return 连续自然数
   */
  def maxMultiplyValueOfNaturalNumber(n: Int): Seq[Int] = {
    val numbers = 1 to n/2
    val result = for(i <- numbers; subList = numbers.view.sliding(i).filter(_.reduce(_ + _) == n) if subList.nonEmpty)
                    yield subList
    if (result.nonEmpty)
      result.view.flatten.maxBy(_.par.reduce(_ * _)).force
    else
      Seq()
  }

  /**
   * 给定单词集合，求TOP N词频.
   * @param words 单词集合
   * @param n 取前几
   * @return TOP N词频
   */
  def topNOfWordFrequency(words: List[String], n: Int): Seq[(String, Int)] = {
    words.groupBy(word => word).mapValues(_.length).toSeq.sortBy(_._2).reverse.take(n)
  }

  /**
   * 给定一组硬币，统计硬币出现连续同样朝面的总次数.
   * @param numbers 朝面值集合
   * @param valueOfSurface 朝面值
   * @return 硬币出现连续同样朝面的总次数
   */
  def countOfCoins(numbers: List[Int], valueOfSurface: Int): Int = {
    val result = for(elem <- numbers.sliding(2) if (elem.head == valueOfSurface && elem.head == elem.last)) yield elem
    result.length
  }

  /**
   * 求N个数字的平均值.
   * @param numbers N个数字
   * @return 平均数
   */
  def avg(numbers: BigDecimal*): BigDecimal = {
    numbers.sum / numbers.size
  }

  /**
   * 数字集合的奇偶互换.
   * @param numbers 数字集合
   * @return 互换后的集合
   */
  def swapOddAndEven(numbers: Int*): List[Int] = {
    numbers.sliding(2, 2).flatMap(_.reverse).toList
  }

  /**
   * 给出一组数字，找出连续最大和的子数组.
   * @param numbers N个数字
   * @return 连续最大和的子数组
   */
  def maxSumOfSubList(numbers: Int*): BigInt = {
    val result = for(i <- 1 to numbers.length) yield numbers.sliding(i)
    result.view.flatten.maxBy(_.sum).sum
  }

  /**
   * 斐波那契数组(递归实现).
   * @param n 第N个数
   * @return 第N个数的值
   */
  def fibonacci(n: Int): BigDecimal = {
    if(n <= 2) 1 else fibonacci(n - 1) + fibonacci(n - 2)
  }

  /**
   * 斐波那契数组(尾递归实现).
   * @param n 第N个数
   * @return 第N个数的值
   */
  def fibonacciWithTailRec(n: BigDecimal): BigDecimal = {
    @tailrec
    def go(n: BigDecimal, acc1: BigDecimal, acc2: BigDecimal): BigDecimal = {
      if (n <= 0) acc1 else go(n - 1, acc2, acc1 + acc2)
    }

    go(n, 1, 1)
  }

  /**
   * 等差数列(递归实现).
   * @param n 第N个数
   * @param step 等差值，默认值为1
   * @return 第N个数的值
   */
  def arithmetic(n: Int, step: Int = 1): BigDecimal = {
    if (n <= 1) 1 else arithmetic(n - 1, step) + step
  }

  /**
   * 等差数列(尾递归实现).
   * @param n 第N个数
   * @param step 等差值，默认值为1
   * @return 第N个数的值
   */
  def arithmeticWithTailRec(n: BigDecimal, step: Int = 1): BigDecimal = {
    @tailrec
    def go(n: BigDecimal, acc: BigDecimal, step: Int = 1): BigDecimal = {
      if (n <= 1) acc else go(n - 1, acc + step, step)
    }

    go(n, 1, step)
  }
}