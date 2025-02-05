package string

import java.util.StringTokenizer

// X marks the Spot(Softeer)

fun main() {

    val xMarksTheSpot = XMarksTheSpot()

    xMarksTheSpot.solution()

}

class XMarksTheSpot {

    fun solution(){

        val numInput = readLine()!!.toInt()

        val pairWords = mutableListOf<PairWord>()

        for(pairWordIndex in 1..numInput) {
            val pairWord = StringTokenizer(readLine()!!)
            val s = pairWord.nextToken()
            val t = pairWord.nextToken()
            pairWords.add(PairWord(s,t))
        }

        val answer = StringBuilder()

        for (pairWord in pairWords) {

            for ((sIndex, sChar) in pairWord.s.withIndex()) {
                if(sChar == 'x' || sChar == 'X') {
                    answer.append(pairWord.t[sIndex].toUpperCase())
                    break
                }
            }
        }
        print(answer)
    }
}

data class PairWord(val s: String, val t: String)