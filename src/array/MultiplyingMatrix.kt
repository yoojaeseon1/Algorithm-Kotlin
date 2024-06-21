package array
// 88
fun main() {
//    val arr1 = arrayOf<IntArray>(intArrayOf(1,4), intArrayOf(3,2), intArrayOf(4,1))
//    val arr2 = arrayOf<IntArray>(intArrayOf(3,3), intArrayOf(3,3))
//
//    val multiplyingMatrix = MultiplyingMatrix()
//
//    val answer = multiplyingMatrix.solution(arr1, arr2)
//
//    for(answerI in answer.indices) {
//        println(answer[answerI].contentToString())
//    }

    val arr1 = Array(3, {IntArray(2, {1})})
    val arr2 = Array(2, {IntArray(4, {1})})

    val multiplyingMatrix = MultiplyingMatrix()

    val answer = multiplyingMatrix.solution(arr1, arr2)
    for(answerI in answer.indices) {
        println(answer[answerI].contentToString())
    }


}
class MultiplyingMatrix {

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array(arr1.size, {IntArray(arr2[0].size)})

        for(arrI in arr1.indices) {
            for(arrJ in arr2[0].indices) {
                var sumElements = 0
                for(arrK in arr2.indices) {
                    sumElements +=  arr1[arrI][arrK] * arr2[arrK][arrJ]
                }
                answer[arrI][arrJ] = sumElements
            }
        }
        return answer
    }
}