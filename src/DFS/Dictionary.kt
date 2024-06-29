package DFS

// 97
fun main() {

    val dictionary = Dictionary()

    val word = "I"

    println(dictionary.solution(word))

}

class Dictionary {


    private val possibleWords = mutableListOf<String>()
    private val aeiou = mutableListOf("A","E","I","O","U")

    fun solution(word: String): Int {
        makeDictionary("")
        return possibleWords.indexOf(word)
    }

    private fun makeDictionary(word: String) {
        if(word.length > 5)
            return

        possibleWords.add(word)

        for (alphabet in aeiou) {
            makeDictionary(word.plus(alphabet))
        }
    }

}