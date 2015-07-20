
object NumberUtils {

    // 求平均数
    def average(args: Int*): Int = {
        args.sum / args.length
    }

    // 交换奇偶位
    def swapOddAndEven(args: Int*): List[Int] = {
        args.sliding(2, 2).flatMap(_.reverse).toList
    }
}