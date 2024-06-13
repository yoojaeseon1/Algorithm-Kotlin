fun main() {

    val arr = intArrayOf(2,6,8,14)
//
    val nLcm = NLcm()
//
    println(nLcm.solution(arr))

//    print(NLcm.calcGcm(6,8))
}

class NLcm {

    fun solution(arr: IntArray): Int {
        var lcm = arr[0]

        for(arrIndex in 1..arr.size-1) {
            val number = arr[arrIndex]
            lcm = calcLcm(lcm, number)
        }

        return lcm
    }

    fun calcGcm(number1: Int, number2: Int): Int {
        var gcm = number1
        var divider = number2
        var rest = 0

        while(divider > 0) {
            rest = gcm % divider
            gcm = divider
            divider = rest
        }

        return gcm
    }

    fun calcLcm(number1: Int, number2: Int) = number1 * number2 / calcGcm(number1, number2)

}