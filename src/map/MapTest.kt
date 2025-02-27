package map

fun main() {

    val numberToCount = mutableMapOf(1 to 2, 2 to 3)

    numberToCount[4] = (numberToCount[4]?:0) + 1 // include containsKey(4)
//    val count = numberToCount[4]
//    if(count != null) {
//        numberToCount[4] = count+1
//    }

    numberToCount[4] = (numberToCount[4]?:0) + 1
//    println(numberToCount[4])

    val entries = numberToCount.entries
    val keys = numberToCount.keys
    val values = numberToCount.values

    for(entry in entries) {
        print(entry.key)
        println(entry.value)
    }

    val words = mutableListOf<String>()

    words.add("1")
    words.add("3")
    words.add("10")
    words.add("4")

//    words.sortWith{ o1, o2 ->
//        o1.toInt().compareTo(o2.toInt())
//    }

//    words.sort()
//    words.sortDescending()

//    println(words)

//    val numbers = IntArray(5) // set size
    val initAllNumbers = IntArray(5){10} // set size + init all elements(as 10)
    val addNumbers = intArrayOf(1,2,3,4) // init elements(+ set size)

//    println(initAllNumbers.contentToString())

    val word = "hahahoho"

//    println(word.length) // no method
//    print(words.size) // no method

//    val numbers = mutableListOf<Int>()
//
//    numbers.add(1)
//    numbers.add(2)
//    numbers.add(3)
//    numbers.add(4)
//
//    for(number in numbers) {
//        for(number1 in numbers) {
//            println("${number} ${number1}")
//        }
//    }



}

class MapTest {
}