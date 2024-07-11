package array


// 105
fun main() {

    val quard = Quard()

//    val arr = arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,0,0,0), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))
    val arr = arrayOf(intArrayOf(1,1,0,0), intArrayOf(1,0,0,0), intArrayOf(1,0,0,1), intArrayOf(1,1,1,1))

    println(quard.solution(arr).contentToString())

}
class Quard {
    private val answer = IntArray(2)
    fun solution(arr: Array<IntArray>): IntArray {


        divideFourArea(arr, 0,0, arr[0].size-1, arr.size-1)

        return answer
    }

    fun divideFourArea(arr: Array<IntArray>, startX: Int, startY: Int, endX: Int, endY: Int) {
        var isAllSame = true
        val startNumber = arr[startY][startX]
        for(arrI in startY..endY) {
            for(arrJ in startX..endX) {
                if(arr[arrI][arrJ] != startNumber) {
                    isAllSame = false
                    break
                }
            }
            if(!isAllSame)
                break
        }

        if(isAllSame) {
            answer[startNumber]++
            return
        }

        val numDecreased = (endX - startX + 1) / 2

        divideFourArea(arr, startX,startY, endX -numDecreased, endY-numDecreased)
        divideFourArea(arr, (endX-numDecreased)+1,startY, endX, endY-numDecreased)
        divideFourArea(arr, startX,(endY-numDecreased)+1, endX-numDecreased, endY)
        divideFourArea(arr, (endX-numDecreased)+1,(endY-numDecreased)+1, endX, endY)
    }



}