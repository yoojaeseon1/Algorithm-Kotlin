package map

// 89
fun main() {

    val want = arrayOf("banana", "apple", "rice", "pork", "pot")
    val number = intArrayOf(3,2,2,2,1)
    val discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")

    val martSale = MartSale()

    println(martSale.solution(want, number, discount) )// IntArray != Array<Int>
}

class MartSale {

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer= 0
        val wantToNumber = mutableMapOf<String, Int>()
        for (wantIndex in want.indices) {
            wantToNumber[want[wantIndex]] = number[wantIndex]
        }

        var numGetWant = 0
        for(discountIndex in 0..9) {
            val currentFruit = discount[discountIndex]
            numGetWant += updateWantFruit(wantToNumber, currentFruit, true)
        }

        if(numGetWant == want.size)
            answer++

        for(discountIndex in 1..discount.size - 10) {
            val yesterdayFruit = discount[discountIndex-1]
            numGetWant += updateWantFruit(wantToNumber, yesterdayFruit, false)

            val todayFruit = discount[discountIndex + 9]
            numGetWant += updateWantFruit(wantToNumber, todayFruit, true)

            if(numGetWant == want.size)
                answer++
        }

        return answer
    }

    private fun updateWantFruit(wantToNumber: MutableMap<String, Int>, discountFruit: String, isAdded: Boolean): Int{

        val numDiscountFruit = wantToNumber[discountFruit]
        if(numDiscountFruit != null) {
            if(isAdded) // 오늘 과일이 추가되는 것
                wantToNumber[discountFruit] = numDiscountFruit - 1
            else // 어제 과일이 빠지는 것
                wantToNumber[discountFruit] = numDiscountFruit + 1
        }

        if(isAdded && numDiscountFruit == 1)
            return 1

        if(!isAdded && numDiscountFruit == 0)
            return -1

        return 0
    }
}