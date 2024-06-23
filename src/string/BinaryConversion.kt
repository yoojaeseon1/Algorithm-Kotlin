import java.util.*


fun main() {

    val binaryConversion = BinaryConversion()

    println(binaryConversion.solution("1111111").contentToString())

}

class BinaryConversion {


    fun solution(s: String): IntArray {

        var numRemoveZero = 0
        var numConverted = 0
        val convertedS = StringBuilder(s)

        while (convertedS.length > 1) {
            var numZero = 0
            for (number in convertedS) {
                if (number == '0')
                    numZero++
            }

            numRemoveZero += numZero
            var share = convertedS.length - numZero
            convertedS.clear()

            while (share > 1) {
                var rest = share % 2
                share /= 2

                convertedS.insert(0, rest)
                if (share == 1) {
                    convertedS.insert(0, share)
                    break
                }
            }
            numConverted++
        }
        return intArrayOf(numConverted, numRemoveZero)
    }
}