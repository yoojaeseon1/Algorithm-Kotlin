
// 104
fun main() {

    val findSosu = FindSosu()

    val numbers = "011"

    println(findSosu.solution(numbers))



}

class FindSosu {

    val allNumberCases = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        var answer = 0

        val numbersToChar = CharArray(numbers.length)

        for ((index, number) in numbers.withIndex()) {
            numbersToChar[index] = number
        }

        selectNumber(numbersToChar, StringBuilder(), BooleanArray(numbers.length))

        for (allNumberCase in allNumberCases) {
            if(isSosu(allNumberCase)) {
                println(allNumberCase)
                answer++
            }
        }


        return answer
    }


    fun selectNumber(numbers: CharArray, currentNumber: StringBuilder, isVisited: BooleanArray) {
        if(currentNumber.length > 0)
            allNumberCases.add(currentNumber.toString().toInt())


        for ((numbersIndex, number) in numbers.withIndex()) {
            if(!isVisited[numbersIndex]) {
                currentNumber.append(number)
                isVisited[numbersIndex] = true
                selectNumber(numbers, currentNumber, isVisited)
                currentNumber.deleteCharAt(currentNumber.length - 1)
                isVisited[numbersIndex] = false
            }
        }
    }


    fun isSosu(number: Int): Boolean{

        if(number <= 1)
            return false

        if(number == 2)
            return true

        val endNumLoop = Math.sqrt(number.toDouble()).toInt()

        for(divider in 2..endNumLoop) {
            if(number % divider == 0)
                return false
        }

        return true
    }

}