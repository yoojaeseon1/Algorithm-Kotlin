package computing

fun main() {

//    val answer = IntArray(5) { -1 }

//    println("answer.contentToString() = ${answer.contentToString()}")

    val findTheBiggestNumber = FindTheBiggestNumber()

    val numbers = intArrayOf(9, 1, 5, 3, 6, 2)

    println(findTheBiggestNumber.solution(numbers).contentToString())

}

class FindTheBiggestNumber {

    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }

        val afterBiggerNumbers = IntArray(numbers.size)
        afterBiggerNumbers[afterBiggerNumbers.size-1] = numbers[numbers.size-1]

        for(afterIndex in numbers.size-2 downTo 0) {
            if(afterBiggerNumbers[afterIndex+1] > numbers[afterIndex]) {
                afterBiggerNumbers[afterIndex] = afterBiggerNumbers[afterIndex+1]
            } else {
                afterBiggerNumbers[afterIndex] = numbers[afterIndex]
            }
        }

        println(afterBiggerNumbers.contentToString())

        for((numberIndex, number) in numbers.withIndex()) {
            if(numbers[numberIndex] == afterBiggerNumbers[numberIndex])
                continue
            for(innerNumberIndex in numberIndex+1..numbers.size-1) {
                val innerNumber = numbers[innerNumberIndex]
                if(innerNumber > number){
                    answer[numberIndex] = innerNumber
                    break
                }
            }
        }
        return answer
    }
}