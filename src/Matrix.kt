// 37

fun main() {
//    var answer = arrayOf<IntArray>(IntArray(5))

//    answer[0] = IntArray(5)

    var answer = Array(2){IntArray(1)}

    var arr1 = Array(2){IntArray(1)}
    var arr2 = Array(2){IntArray(1)}

    print(arr1.size)
    print(arr1[0].size)

    arr1[0][0] = 1
//    arr1[0][1] = 2
    arr2[0][0] = 2
//    arr2[0][1] = 4

}

class Matrix {

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {

        var answer = Array(arr1.size){IntArray(arr1[0].size)}
        for(arrI in arr1.indices) {
            for(arrJ in arr1.indices) {
                answer[arrI][arrJ] = arr1[arrI][arrJ] + arr2[arrI][arrJ]
            }
        }

        return answer
    }
}