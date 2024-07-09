package DFS


fun main() {

    val convertingNumber = ConvertingNumber()
//    val x = 10
//    val y = 40
//    val n = 5

//    val x = 10
//    val y = 97
//    val n = 2

    val x = 1
    val y = 100000
    val n = 1

    println(convertingNumber.solution(x, y, n))

//    val x: Int = 2
//    val y: Long = 3
//
//    val z = x + y
//
//    println("${z.javaClass}")

}
class ConvertingNumber {

    private var answer = Integer.MAX_VALUE
//    private var isChecked = false
//    private var numRecursive = 0
    fun solution(x: Int, y: Int, n: Int): Int {
        countNumCalcToY(x, y, n, 0)

        if(answer == Integer.MAX_VALUE)
            return -1

        return answer
    }

//    private fun countNumCalcToY(number: Int, y: Int, n: Int, numCalcToY: Int) {
////        numRecursive++
////        if(numRecursive >= 50)
////            return
////        println("${number}")
//
//        if(number < y && (y - number) % n == 0) {
//            val currentAnswer = numCalcToY + ((y - number) / n)
//            answer = Math.min(answer, currentAnswer)
//        }
//
////        if(number > y)
////            return
//
//        if(number >= y) {
//            if(number == y) {
//                answer = Math.min(answer, numCalcToY)
//            }
//            return
//        }
//
//        countNumCalcToY(number + n, y, n, numCalcToY+1)
//        countNumCalcToY(number * 2, y, n, numCalcToY+1)
//        countNumCalcToY(number * 3, y, n, numCalcToY+1)
//    }

    private fun countNumCalcToY(number: Int, y: Int, n: Int, numCalcToY: Int) {
        if(numCalcToY >= answer)
            return

        if(number < y && (y - number) % n == 0) {
            val currentAnswer = numCalcToY + ((y - number) / n)
            answer = Math.min(answer, currentAnswer)
        }

        if(number >= y) {
            if(number == y) {
                answer = Math.min(answer, numCalcToY)
            }
            return
        }

        countNumCalcToY(number * 3, y, n, numCalcToY+1)
        countNumCalcToY(number * 2, y, n, numCalcToY+1)
        countNumCalcToY((number + n) * 3, y, n, numCalcToY+2)
        countNumCalcToY((number + n) * 2, y, n, numCalcToY+2)
    }
}