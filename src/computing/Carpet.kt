package computing
// 79

fun main() {

    val brown = 10
    val yellow = 2

//    val brown = 8
//    val yellow = 1

//    val brown = 24
//    val yellow = 24

    val carpet = Carpet()

//    println(carpet.solution(brown, yellow).contentToString())
//    print(1.5 % 1)

}

class Carpet {

    fun solution(brown: Int, yellow: Int): IntArray {

        var lengthYellowRow = yellow
        var lengthYellowColumn = 1

        while (lengthYellowRow >= lengthYellowColumn) {
            val divideToDouble = yellow / lengthYellowColumn.toDouble()

            if(divideToDouble % 1 == 0.0) {

                lengthYellowRow = divideToDouble.toInt()
                val numBrown = (lengthYellowRow * 2) + (lengthYellowColumn * 2) + 4
                if (numBrown == brown)
                    break
            }

            lengthYellowColumn++
        }

        return intArrayOf(lengthYellowRow + 2, lengthYellowColumn + 2)
    }
}