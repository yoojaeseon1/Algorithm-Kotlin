package string


// 75
fun main() {


}
class MaxMinValue {
    fun solution(s: String): String {
        val splitS = s.split(" ")

        var minNumber = Int.MAX_VALUE
        var maxNumber = Int.MIN_VALUE
        for(number in splitS) {
            val numberToInt = number.toInt()
            minNumber = Integer.min(minNumber, numberToInt)
            maxNumber = Integer.max(maxNumber, numberToInt)
        }

        return "${minNumber} ${maxNumber}"
    }
}