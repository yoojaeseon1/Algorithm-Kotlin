package computing
//86
fun main() {

    val citation = intArrayOf(3, 0, 6, 1, 5)

    val hIndex = HIndex()

    println(hIndex.solution(citation))

}

class HIndex {

    fun solution(citations: IntArray): Int {
        var hIndex = 0
        citations.sort()

        for ((index,citation) in citations.withIndex()) {

            if(citation >= citations.size - index) {
                hIndex = citations.size - index
                break
            }
        }

        return hIndex
    }

}