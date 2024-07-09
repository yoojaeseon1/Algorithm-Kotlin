package computing

fun main() {

    val underTwoBits = UnderTwoBits()

    val binary1 = StringBuilder("111")
    val binary2 = StringBuilder("111011")

//    println(underTwoBits.isDifferTwoDigits(binary1, binary2))

    println(underTwoBits.solution(longArrayOf(15,127,179,3783,819199,9126805503,38588121087,8796093022207,17592186044415)).contentToString())

}

class UnderTwoBits {

    fun solution(numbers: LongArray): LongArray {
        var answer = LongArray(numbers.size)

        for ((numberIndex, number) in numbers.withIndex()) {
            var upperNumber = number + 1
            val numberToBinary = convertTenToBinary(number)
            var currentAnswer = Long.MAX_VALUE

//            println("number = ${number}")
//            println("upperNumber = ${upperNumber}")
            while (currentAnswer == Long.MAX_VALUE) {
                val upperToBinary = convertTenToBinary(upperNumber)
//                println("upperToBinary = ${upperToBinary}")
                if(isDifferUnderTwoDigits(numberToBinary, upperToBinary))
                    currentAnswer = Math.min(currentAnswer, upperNumber)

                upperNumber++
            }

            answer[numberIndex] = currentAnswer
//            println("==============")
        }


        return answer
    }

    fun convertTenToBinary(number: Long): StringBuilder {

        val convertedToBinary = StringBuilder()

        var share = number
        var remain: Long

        while (share > 1) {
            remain = share % 2
            share /= 2
//            println("${remain}")
            convertedToBinary.insert(0, remain)
        }

//        convertedToBinary.insert(0, remain)
        convertedToBinary.insert(0, share)

        return convertedToBinary

    }

    fun isDifferUnderTwoDigits(binary1: StringBuilder, binary2: StringBuilder): Boolean {

        if(binary1.length != binary2.length) {
            var gapLength = Math.abs(binary1.length - binary2.length)
            if(binary1.length < binary2.length)
                addZero(binary1, gapLength)
            else
                addZero(binary2, gapLength)
        }

//        println("binary1 = ${binary1}")
//        println("binary2 = ${binary2}")

        var numDifferentDigits = 0
        for ((binaryIndex, binaryDigit1) in binary1.withIndex()) {
            val binaryDigit2 = binary2[binaryIndex]
            if(binaryDigit1 != binaryDigit2)
                numDifferentDigits++

            if(numDifferentDigits > 2)
                return false
        }

        return true
    }

    fun addZero(binary: StringBuilder, numZero: Int) {
        var numLoop = 0

        while(numLoop < numZero) {
            binary.insert(0,0)
            numLoop++
        }
    }

}