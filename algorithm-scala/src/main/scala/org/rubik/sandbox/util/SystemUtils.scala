package org.rubik.sandbox.util

object SystemUtils {

  def elapsedTime[R](block: => R): R = {
    val before = System.currentTimeMillis()
    val result = block
    val after = System.currentTimeMillis()
    println(s"Elapsed time: ${after - before}ms")
    result
  }
}
