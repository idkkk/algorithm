
object NumberUtils {
    def average(args: Int*): Int = {
        args.sum / args.length
    }

    def swapOddAndEven(args: Int*): List[Int] = {
        args.sliding(2, 2).flatMap(_.reverse).toList
    }
}