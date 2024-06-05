package map

fun main() {

    val privateInfo = PrivateInfo()

//    println(privateInfo.calculateDateToAmount("2021.05.02"))

//    print("A".first().code)

    val today = "2022.05.19"
    val terms = arrayOf("A 6", "B 12", "C 3")
    val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")


    print(privateInfo.solution(today, terms, privacies))
}
class PrivateInfo {


    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        var termToExpiration = mutableMapOf<String, Int>()

        for(term in terms) {
            val splitedTerm = term.split(" ")
            termToExpiration.put(splitedTerm[0], splitedTerm[1].toInt())
        }
        val todayToAmount = calculateDateToAmount(today)
        for(privacyIndex in privacies.indices) {
            val splitedPrivacy = privacies[privacyIndex].split(" ")
            val calculatedDateAmount = calculateDateToAmount(splitedPrivacy[0]) + termToExpiration.get(splitedPrivacy[1])!! * 28
            if(todayToAmount >= calculatedDateAmount)
                answer.add(privacyIndex+1)
        }

        return answer.toIntArray()
    }

    fun calculateDateToAmount(dateString: String): Int {
        val splitedDate = dateString.split(".")

        return (splitedDate[0].toInt() * 12*28) + (splitedDate[1].toInt() * 28) + splitedDate[2].toInt()
    }
}