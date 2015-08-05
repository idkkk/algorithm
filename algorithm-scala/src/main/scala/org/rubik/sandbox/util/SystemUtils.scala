package org.rubik.sandbox.util

/**
 * 系统工具类.
 * @author xiajinxin
 * @since 2015-08-05
 */
object SystemUtils {

  /**
   * 耗时统计.
   * @param block 被统计函数
   * @tparam R 被统计函数返回值
   * @return 被统计函数返回值
   */
  def elapsedTime[R](block: => R): R = {
    val before = System.currentTimeMillis()
    val result = block
    val after = System.currentTimeMillis()
    println(s"Elapsed time: ${after - before}ms")
    result
  }
}
