package computing
fun main() {

    val n = 8
    val a = 4
    val b = 7

    val matchTable = MatchTable()

    println(matchTable.solution(n, a, b))



    var (numA, numB) = a to b

    print("${numA}, ${numB}")

}

class MatchTable {


    fun solution(n: Int, a: Int, b: Int): Int {
        var numRound = 1
        var nextNumA = a
        var nextNumB = b

        while(!isSameMatch(nextNumA, nextNumB)) {
            nextNumA = calcNextRoundNumber(nextNumA)
            nextNumB = calcNextRoundNumber(nextNumB)
            numRound++
        }

        return numRound
    }

    fun calcNextRoundNumber(number: Int): Int{
        return when(number % 2) {
            0 -> number / 2
            else -> (number + 1) / 2
        }
    }

    fun isSameMatch(number1: Int, number2: Int): Boolean{

        val biggerNumber = Math.max(number1, number2)
        val gapNumbers = Math.abs(number1 - number2)

        return gapNumbers == 1 && biggerNumber % 2 == 0
    }
}