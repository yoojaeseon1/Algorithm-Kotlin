package array

// 87
fun main() {

    val cuttingArray = CuttingArray()

    println(cuttingArray.solution(4,7,14).contentToString())

    var number1 = 5
    var number2 = 6



}
class CuttingArray {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val arraySize = right - left + 1
        val array = IntArray(arraySize.toInt())
        var arrayIndex = 0

        for(newArrayNumber in left..right) {
           val newArrayI = newArrayNumber / n
           val newArrayJ = newArrayNumber % n
           array[arrayIndex++] = Math.max(newArrayI, newArrayJ).toInt() + 1
        }

        return array
    }

}