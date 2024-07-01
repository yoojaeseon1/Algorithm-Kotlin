package array

import computing.Development
import java.time.LocalDate

fun main() {

//    println(Math.ceil(2.1))

    val development = DevelopmentV2()

//    val answer = mutableListOf(1.0, 2.0)
    val answer = mutableListOf(1,2,3,4,5)

    answer.toIntArray()


}

class DevelopmentV2 {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val completedDays = IntArray(progresses.size)
        for ((progressIndex,progress) in progresses.withIndex()) {
            val speed = speeds[progressIndex].toDouble()
            val completedDay = Math.ceil((100-progress) / speed).toInt()
            completedDays[progressIndex] = completedDay

        }

        var numProgress = 1
        var maxCompletedDay = completedDays[0]
        for(completedDaysIndex in 1..completedDays.size-1) {
            val currentDay = completedDays[completedDaysIndex]
            if(currentDay > maxCompletedDay) {
                answer.add(numProgress)
                numProgress = 1
                maxCompletedDay = currentDay
            } else
                numProgress++
        }
        answer.add(numProgress)

        val answerArray = IntArray(answer.size)

        for ((answerIndex, value) in answer.withIndex()) {
            answerArray[answerIndex] = value
        }

        return answer.toIntArray()
    }
}