package array

import java.util.*


fun main() {


    val numbers = mutableListOf(3, 5, 6, 1, 2)

//    for ((numbersIndex, number) in numbers.withIndex()) {
//
//        if(number == 6) {
//            numbers.removeAt(numbersIndex)
//        }
//
//        println(numbers)
//
//    }

//    for(numbersIndex in numbers.indices) {
//
//        val number = numbers[numbersIndex]
//
//        if(number == 6) {
//            numbers.removeAt(numbersIndex)
//        }
//
//        println(numbers)
//    }


//    var numbersIndex = 0
//
//    while (numbersIndex < numbers.size) {
//
//        val number = numbers[numbersIndex]
//
//        if(number == 6) {
//            numbers.removeAt(numbersIndex)
//        }
//
//        println(numbers)
//
//        numbersIndex++
//    }

    val phiSquared = PhiSquared()

    phiSquared.solution()

//    var queue: Queue<Int> = LinkedList()
//
//    val list = LinkedList<Int>()
//
//    list.add(1)
//    list.add(2)
//    list.add(3)
//
//    queue = list
//
//    println(queue.poll())

    val stack = Stack<Int>()

}

class PhiSquared {

    fun solution(){

        val numInput = readLine()!!.toInt()
        val micros = StringTokenizer(readLine()!!)

        var currentQueue: Queue<Micro> = LinkedList()
        var nextQueue = LinkedList<Micro>()

        var microNumber = 1
        while (micros.hasMoreTokens())
            nextQueue.add(Micro(microNumber++, micros.nextToken().toInt()))

        while (nextQueue.size != 1) {
            currentQueue = nextQueue
            nextQueue = LinkedList<Micro>()

            while (currentQueue.isNotEmpty()) {

                val currentMicro = currentQueue.poll()
                var beforeSum = 0
                var afterSum = 0

                if(nextQueue.size > 0 && currentMicro.sumCombine >= nextQueue[nextQueue.size -1].sumCombine) {
                    beforeSum = nextQueue[nextQueue.size - 1].sumCombine
                    nextQueue.removeLast()
                }

                if(currentQueue.size > 2 && currentMicro.sumCombine >= currentQueue.peek().sumCombine) {
                    val afterMicro = currentQueue.poll()
                    afterSum = afterMicro.sumCombine
                }

                currentMicro.sumCombine += beforeSum + afterSum
                nextQueue.add(currentMicro)

            }
        }

        val lastMicro = nextQueue.poll()

        println("${lastMicro.sumCombine}")
        print("${lastMicro.number}")

    }


//    fun solution(){
//
//        val numInput = readLine()!!.toInt()
//        val microSequence = StringTokenizer(readLine()!!)
//        var microNumber = 1
//
//        val micros = mutableListOf<Micro>()
//
//        while (microSequence.hasMoreTokens()) {
//            micros.add(Micro(microNumber++, microSequence.nextToken().toInt()))
//        }
//
//        var microsIndex = 0
//        while (micros.size > 1) {
//            microsIndex = 0
//
//            while (microsIndex < micros.size) {
//
//                val currentMicro = micros[microsIndex]
//                var beforeSum = 0
//                var afterSum = 0
//
//                if(microsIndex > 0) {
//                    val beforeMicro = micros[microsIndex - 1]
//
//                    if(currentMicro.sumCombine >= beforeMicro.sumCombine) {
//                        beforeSum = beforeMicro.sumCombine
//                    }
//                }
//
//                if(microsIndex < micros.size - 1) {
//                    val afterMicro = micros[microsIndex + 1]
//                    if(currentMicro.sumCombine >= afterMicro.sumCombine) {
//                        afterSum = afterMicro.sumCombine
//                    }
//                }
//
//                if (beforeSum > 0)
//                    micros.removeAt(microsIndex - 1)
//
//                if(afterSum > 0) {
//                    if (beforeSum > 0)
//                        micros.removeAt(microsIndex)
//                    else
//                        micros.removeAt(microsIndex + 1)
//
//                }
//
//                currentMicro.sumCombine += (beforeSum + afterSum)
//
//                microsIndex++
//            }
//        }
//    }
}

data class Micro(val number: Int, var sumCombine: Int)