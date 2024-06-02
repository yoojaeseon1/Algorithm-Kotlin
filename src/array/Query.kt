package array

class Query {

    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        for(query in queries) {
            val temp = arr[query[0]]
            arr[query[0]] = arr[query[1]]
            arr[query[1]] = temp
        }
        return arr
    }
}