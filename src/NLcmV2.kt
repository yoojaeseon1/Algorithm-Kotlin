// 81

fun main() {

    val arr = intArrayOf(1,2,3)

    val nMinMultipleNumber = NLcm2()

    println(nMinMultipleNumber.solution(arr))

}

class NLcm2 {

    fun solution(arr: IntArray): Int {
        var lcm = arr[0]

        for(arrIndex in 1..arr.size-1) {
            val number2 = arr[arrIndex]
            val biggerNumber = Math.max(lcm, number2)
            val smallerNumber = Math.min(lcm, number2)
            var operand1 = 2
            var operand2 = 2
            var result1 = smallerNumber
            var result2 = biggerNumber

            while (result1 != result2) {
                result1 = smallerNumber * operand1++
                if(result1 == result2)
                    break

                if (result1 > result2)
                    result2 = biggerNumber * operand2++
            }
            lcm = result1
        }

        return lcm
    }

}