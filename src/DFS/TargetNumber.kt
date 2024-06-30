package DFS

// 94
fun main() {

//    val numbers = intArrayOf(1, 1, 1, 1, 1)
//    val target = 3

    val numbers = intArrayOf(4,1,2,1)
    val target = 4

    val targetNumber = TargetNumber()

    println(targetNumber.solution(numbers, target))
}
class TargetNumber {

    private var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
        calcNumbers(numbers, 0, 0, target)
        return answer
    }

    private fun calcNumbers(numbers: IntArray, numbersIndex: Int, currentResult: Int, target: Int): Unit{

        if(numbersIndex == numbers.size) {
            if(currentResult == target)
                answer++
            return
        }

        calcNumbers(numbers, numbersIndex+1, currentResult + numbers[numbersIndex], target)
        calcNumbers(numbers, numbersIndex+1, currentResult - numbers[numbersIndex], target)
    }
}