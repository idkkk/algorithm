import scala.annotation.tailrec

object NumberUtils {

    // 求平均数
    def average(args: Int*): Int = {
        args.sum / args.length
    }

    // 交换奇偶位
    def swapOddAndEven(args: Int*): List[Int] = {
        args.sliding(2, 2).flatMap(_.reverse).toList
    }

    // 斐波那契数列 (传统递归实现)
    def fibonacci(n: BigDecimal): BigDecimal = {
        if (n <= 0) 1 else n + fibonacci(n - 1)
    }

    // 斐波那契数列 (尾递归实现)
    def fibonacciWithTailRec(n: BigDecimal): BigDecimal = {
        @tailrec
        def go(n: BigDecimal, acc: BigDecimal): BigDecimal = {
            if (n <= 0) acc else go(n - 1, n + acc)
        }

        go(n, 1)
    }
}