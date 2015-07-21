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

    // 等差数列 (传统递归实现)
    def sumOfArithmetic(n: BigDecimal, step: Int = 1): BigDecimal = {
        if (n <= 1) 1 else sumOfArithmetic(n - 1, step) + step
    }

    // 等差数列 (尾递归实现)
    def sumOfArithmeticByReduce(n: BigDecimal, step: Int = 1): BigDecimal = {
        @tailrec
        def go(n: BigDecimal, acc: BigDecimal, step: Int = 1): BigDecimal = {
            if (n <= 1) acc else go(n - 1, acc + step, step)
        }

        go(n, 1, step)
    }

    // 子数组和最大值
    def maxOfSubArraySum(args: Int*): Int = {
        val result = for(i <- 1 to args.length) yield args.sliding(i).toStream
        result.map(subList => subList.map(_.sum)).flatten.max
    }
}