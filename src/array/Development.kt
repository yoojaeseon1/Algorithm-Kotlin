package computing

// 91
fun main() {

//    println(Math.ceil(2.1))

    val development = Development()

//    val progresses = intArrayOf(93, 30, 55)
//    val speeds = intArrayOf(1, 30, 5)

//    val progresses = intArrayOf(95, 90, 99, 99, 80, 99)
//    val speeds = intArrayOf(1, 1, 1, 1, 1, 1)

    val progresses = intArrayOf(95,95,95,95)
    val speeds = intArrayOf(4,3,2,1)

    println(development.solution(progresses, speeds).contentToString())

}
class Development {

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