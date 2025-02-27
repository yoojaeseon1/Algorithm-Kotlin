package array

fun main() {

    val continuousSequence = ContinuousSequence()

    val sequence = intArrayOf(2, 2, 2, 2, 2)
    val k = 6

    println(continuousSequence.solution(sequence,k).contentToString())

}

class ContinuousSequence {

    fun solution(sequence: IntArray, k: Int): IntArray {
        val answer = intArrayOf(0,0)
        var startSum = 0

        for(sequenceLength in 1..sequence.size) {
            startSum += sequence[sequenceLength-1]
            var currentSum = startSum
            var beforeStartIndex = 0

            if(currentSum == k)
                return intArrayOf(0, sequenceLength-1)

            for(lastIndex in sequenceLength..sequence.size-1) {

                currentSum -= sequence[beforeStartIndex++]
                currentSum += sequence[lastIndex]

                if(currentSum == k)
                    return intArrayOf(beforeStartIndex, lastIndex)

            }
        }
        return answer
    }


}