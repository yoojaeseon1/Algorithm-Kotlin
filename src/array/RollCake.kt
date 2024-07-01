package array

fun main() {

    val rollcake = Rollcake()

    val topping = intArrayOf(1, 2, 3, 1, 4)

    println(rollcake.solution(topping))

}
class Rollcake{


    fun solution(topping: IntArray): Int {
        var answer = 0
        val numYoungerToppings = IntArray(10001)
        val numOlderToppings = IntArray(10001)
        var numYoungerTypes = 0
        var numOlderTypes = 0

        for (top in topping) {
            numYoungerToppings[top]++
            if(numYoungerToppings[top] == 1)
                numYoungerTypes++
        }

        for (top in topping) {
            numYoungerToppings[top]--
            numOlderToppings[top]++

            if(numYoungerToppings[top] == 0)
                numYoungerTypes--

            if(numOlderToppings[top] == 1)
                numOlderTypes++

            if(numYoungerTypes == numOlderTypes)
                answer++
        }

        return answer
    }

}