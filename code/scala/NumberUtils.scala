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
        if (n <= 2) 1 else fibonacci(n - 1) + fibonacci(n - 2)
    }

    // 斐波那契数列 (尾递归实现)
    def fibonacciWithTailRec(n: BigDecimal): BigDecimal = {
        @tailrec
        def go(n: BigDecimal, acc1: BigDecimal, acc2: BigDecimal): BigDecimal = {
            if (n <= 0) acc1 else go(n - 1, acc2, acc1 + acc2)
        }

        go(n, 1, 1)
    }
}