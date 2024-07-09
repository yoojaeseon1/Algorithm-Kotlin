package computing

import kotlin.math.max

fun main() {

    val underTwoBitsV2 = UnderTwoBitsV2()

//    val binary1 = StringBuilder("111")
//    val binary2 = StringBuilder("111011")

//    println(underTwoBits.isDifferTwoDigits(binary1, binary2))

    var number1: Int = 5
    var number2: Long = 10
    
    var number3 = number1 + number2

    println("number3.javaClass = ${number3.javaClass}")

    println(underTwoBitsV2.solution(longArrayOf(17592186044415)).contentToString())
//    println(underTwoBitsV2.convertBinaryToTen(StringBuilder("100111")))

}

private val listOfSelectedIndices = mutableListOf<IntArray>()

class UnderTwoBitsV2 {

    //        for ((numberIndex, number) in numbers.withIndex()) {
//            var upperNumber = number + 1
//            val numberToBinary = convertTenToBinary(number)
//            var currentAnswer = Long.MAX_VALUE
//
////            println("number = ${number}")
////            println("upperNumber = ${upperNumber}")
//            while (currentAnswer == Long.MAX_VALUE) {
//                val upperToBinary = convertTenToBinary(upperNumber)
////                println("upperToBinary = ${upperToBinary}")
//                if(isDifferUnderTwoDigits(numberToBinary, upperToBinary))
//                    currentAnswer = Math.min(currentAnswer, upperNumber)
//
//                upperNumber++
//            }
//
//            answer[numberIndex] = currentAnswer
////            println("==============")
//        }


    fun solution(numbers: LongArray): LongArray {
        val answer = LongArray(numbers.size)
        for ((numberIndex, number) in numbers.withIndex()) {

            val numberToBinary = convertTenToBinary(number)

            numberToBinary.insert(0, '0')
            println("numberToBinary = ${numberToBinary}")
            for ((numberToBinaryIndex, digit) in numberToBinary.withIndex().reversed()) {
//                println("${numberToBinaryIndex}, ${digit}")

                if(digit == '0') {
                    numberToBinary[numberToBinaryIndex] = '1'
                    if(numberToBinaryIndex < numberToBinary.length -1)
                        numberToBinary[numberToBinaryIndex+1] = '0'
                    break
                }
            }
            println("========")

            answer[numberIndex] = convertBinaryToTen(numberToBinary)
        }


        return answer
    }

//    private fun selectIndices(selectedIndices: IntArray, selectedIndex: Int, targetIndex: Int, maxIndex: Int) {
//    private fun selectIndices(selectedIndices: IntArray, selectedIndex: Int, targetIndex: Int) {
//
//        if(selectedIndices.size == selectedIndex) {
//            println("selectedIndices = ${selectedIndices.contentToString()}")
//            listOfSelectedIndices.add(selectedIndices.copyOf())
//            return
//        }
//
//        if(targetIndex < 0)
//            return
//
//        selectedIndices[selectedIndex] = targetIndex
//
////        selectIndices(selectedIndices, selectedIndex+1, targetIndex+1, maxIndex)
////        selectIndices(selectedIndices, selectedIndex, targetIndex+1, maxIndex)
//        selectIndices(selectedIndices, selectedIndex+1, targetIndex-1)
//        selectIndices(selectedIndices, selectedIndex, targetIndex-1)
//
//    }


    private fun convertTenToBinary(number: Long): StringBuilder {

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

    fun convertBinaryToTen(binary: StringBuilder): Long {

        var convertedNumber: Long = 0
        var multiplyer = 1

        for (digit in binary.reversed()) {
            if(digit == '1')
                convertedNumber += multiplyer
            multiplyer *= 2
        }

        return convertedNumber
    }

//    fun isExistOnlyOne(binary: StringBuilder): Boolean{
//        for (digit in binary) {
//            if(digit == '0')
//                return false
//        }
//        return true
//    }

}