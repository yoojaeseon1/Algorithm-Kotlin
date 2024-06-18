package computing
// 85
fun main() {
    val elements = intArrayOf(7,9,1,1,4)

    val partialSequence = PartialSequence()

    print(partialSequence.solution(elements))


}

class PartialSequence {

    fun solution(elements: IntArray): Int {
        val sumSet = mutableSetOf<Int>()
        val sumElements = mutableListOf<Int>()
        val rotatingElements = mutableListOf<Int>()

        for (element in elements) {
            sumSet.add(element)
            sumElements.add(element)
            rotatingElements.add(element)
        }

        var numRotate = 2
        while (numRotate < elements.size) {
            rotatingElements.add(rotatingElements[0])
            rotatingElements.removeFirst()
            for (sumIndex in sumElements.indices) {
                val sumNumber = sumElements[sumIndex] + rotatingElements[sumIndex]
                sumElements[sumIndex] = sumNumber
                sumSet.add(sumNumber)
            }
            numRotate++
        }

        rotatingElements.add(rotatingElements[0])
        rotatingElements.removeFirst()
        sumSet.add(sumElements[0] + rotatingElements[0])

        return sumSet.size
    }

}