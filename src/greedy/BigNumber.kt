package greedy

// 107
fun main() {

    val bigNumber = BigNumber()
    val number = "4177252841"
    val k = 4
    println(bigNumber.solution(number, k))

}
class BigNumber {
    fun solution(number: String, k: Int): String {
        var numRemoved = 0
        val numberSB = StringBuilder(number)
        var numberSBIndex = 0
        while(numRemoved < k && numberSBIndex < numberSB.length) {
            while (numRemoved < k && numberSBIndex > 0 && numberSB[numberSBIndex].code > numberSB[numberSBIndex-1].code) {
                numberSB.deleteCharAt(numberSBIndex-1)
                numberSBIndex--
                numRemoved++
            }
            numberSBIndex++
        }

        if(numRemoved < k) {
            return numberSB.substring(0, numberSB.length - k - numRemoved)
        }

        return numberSB.toString()
    }

}