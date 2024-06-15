package map

fun main() {

    val k = 6

    val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)

    val choice = GyoolChoice()

    println(choice.solution(k, tangerine))

//    val pairs = mutableListOf<Pair<Int,Int>>()
//    pairs.add(Pair(1,3))
//    pairs.add(Pair(2,2))


//    val sortepairs = pairs.sortedWith(compareBy({ it.first }, { it.second }))

//    for (pair in sortepairs) {
//        println("pair = ${pair}")
//    }

//    pairs.sortWith(compareBy({it.first}, {it.second}))
//
//    for (pair in pairs) {
//        println("pair = ${pair}")
//    }



}
class GyoolChoice {

    fun solution(k: Int, tangerine: IntArray): Int {

        val sizeToCount = mutableMapOf<Int,Int>()
        for (size in tangerine) {
            val numSize = sizeToCount[size]?:0
            sizeToCount[size] = numSize+1
        }

        val iterator = sizeToCount.values.iterator()
        val sizeCounts = mutableListOf<Int>()
        while (iterator.hasNext()) {
            val count = iterator.next()
            sizeCounts.add(count)
        }

        sizeCounts.sortWith{ o1, o2 ->
            Integer.compare(o2,o1)
        }

        var numChoice = 0
        var numChoiceSize = 0
        for (sizeCount in sizeCounts) {
            numChoice += sizeCount
            numChoiceSize++
            if(numChoice >= k)
                break
        }

        return numChoiceSize
    }

}