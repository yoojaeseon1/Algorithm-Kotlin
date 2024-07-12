package sorting

// 103
fun main() {

    var numbers = intArrayOf(3, 30, 34, 5, 9)

//    val numbersToString = Array(numbers.size, {""})
//
//    for ((numbersIndex, number) in numbers.withIndex()) {
//        numbersToString[numbersIndex] = number.toString()
//    }

    val maxNumber = MaxNumber()

    println(maxNumber.solution(numbers))


//    println(numbersToString.sortedDescending())
}
class MaxNumber {

    fun solution(numbers: IntArray): String {
        val numbersToString = Array(numbers.size, {""})

        for ((numbersIndex, number) in numbers.withIndex()) {
            numbersToString[numbersIndex] = number.toString()
        }

        numbersToString.sortWith { s1, s2 -> (s2+s1).compareTo(s1+s2)}

        if(numbersToString[0].equals("0"))
            return "0"

        val answer = StringBuilder()

        for (number in numbersToString) {
            answer.append(number)
        }

        return answer.toString()
    }

}