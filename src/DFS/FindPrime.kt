package DFS

// 95
fun main() {

    val findPrime = FindPrime()

//     "110201010111"

//    println(findPrime.convertTenToK(437674, 3))
//    println(Integer.toString(2, 3))

//    print("11020101011".toLong())

    val n = 110011
    val k = 10

    println(findPrime.solution(n, k))
    
    val array = arrayOf(1,2,3)

    array.plus(1)

    println("array.contentToString() = ${array.contentToString()}")


}
class FindPrime {

    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val convertedK = convertTenToK(n, k).toString()
        var dividedN = StringBuilder()

        for (convertedChar in convertedK) {
            if(convertedChar != '0')
                dividedN.append(convertedChar)
            else if(dividedN.isEmpty())
                continue
            else if(isPrime(dividedN.toString())) {
                answer++
                dividedN.clear()
            } else
                dividedN.clear()
        }

        if(dividedN.isNotEmpty() && isPrime(dividedN.toString()))
            answer++

        return answer
    }

    fun convertTenToK(number: Int, k: Int): Long{
        val convertedNumber = StringBuilder()
        var share = number / k
        var remain = number % k

        while (share >= k) {
            convertedNumber.insert(0, remain)
            remain = share % k
            share /= k
        }

        convertedNumber.insert(0, remain)
        convertedNumber.insert(0, share)

        return convertedNumber.toString().toLong()
    }

    fun isPrime(number: String): Boolean{
        if(number == "1")
            return false

        val sqrtNumber = Math.sqrt(number.toLong().toDouble())

        for(divider in 2.. sqrtNumber.toLong()) {
            if((number.toLong() % divider).toInt() == 0)
                return false
        }

        return true
    }


}