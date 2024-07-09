import java.util.*
import kotlin.math.max

fun main() {

    var numbers = intArrayOf(3, 30, 34, 5, 9)

    val numbersToString = Array(numbers.size, {""})

    for ((numbersIndex, number) in numbers.withIndex()) {
        numbersToString[numbersIndex] = number.toString()
    }

    val maxNumber = MaxNumber()

    println(maxNumber.solution(numbers))


    println(numbersToString.sortedDescending())
}
class MaxNumber {

    fun solution(numbers: IntArray): String {
        var answer = ""

        val numbersToString = Array(numbers.size, {""})

        for ((numbersIndex, number) in numbers.withIndex()) {
            numbersToString[numbersIndex] = number.toString()
        }

//        numbersToString.sortWith { s1: String, s2: String ->
//
//            val s1ToSB = StringBuilder(s1)
//            val s2ToSB = StringBuilder(s2)
//
////            if (s1ToSB.length > s2ToSB.length) {
////                s2ToSB.append(s2[s2.length - 1])
////            } else if (s1.length < s2.length) {
////                s1ToSB.append(s1[s1.length - 1])
////            }
//
//            s1ToSB.compareTo(s2ToSB)
//        }

        numbersToString.sortWith { s1: String, s2: String ->

            val s1ToSB = StringBuilder(s1)
            val s2ToSB = StringBuilder(s2)

            if (s1ToSB.length > s2ToSB.length) {
                s2ToSB.append(s2[s2.length - 1])
            } else if (s1.length < s2.length) {
                s1ToSB.append(s1[s1.length - 1])
            }

            s1ToSB.compareTo(s2ToSB)

        }


        return answer
    }

}