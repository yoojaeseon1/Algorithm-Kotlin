package stack

import java.util.Stack

fun main() {


//    val list1 = mutableListOf<Int>()
//    val list2 = mutableListOf<Int>()
//
//    list1.add(1)
//    list1.add(2)
//    list1.add(3)
//    list2.add(1)
//    list2.add(2)
//    list2.add(4)
//
//    print(list1.equals(list2))

//    val ingredientStack = Stack<Int>()
//    ingredientStack.push(1)
//    ingredientStack.push(2)
//    ingredientStack.push(3)
//    ingredientStack.push(3)
//
//    print(ingredientStack.search(3))

    var ingredient = intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)

    val makingBurger = MakingBurger()

//    print(makingBurger.solution(ingredient))

    val sb = StringBuilder()

    sb.append('0'+1)

    print('6'+1)

}

class MakingBurger {

    fun solution(ingredient: IntArray): Int {
        var answer = 0

        val ingredientStack = Stack<Int>()

        val burgerSequence = mutableListOf<Int>()
        for(element in ingredient) {
            if(element == 1 && ingredientStack.size >= 3) {
                burgerSequence.add(1)
                burgerSequence.add(ingredientStack.pop())
                burgerSequence.add(ingredientStack.pop())
                burgerSequence.add(ingredientStack.pop())

                if (checkCorrectBurger(burgerSequence))
                    answer++
                else {
                    for (burgerIndex in burgerSequence.size - 1 downTo 0) {
                        ingredientStack.push(burgerSequence.get(burgerIndex))
                    }
                }
                burgerSequence.clear()
            } else
                ingredientStack.push(element)

        }
        return answer
    }

    fun checkCorrectBurger(burgerSequence: List<Int>): Boolean{
        val correctSequence = mutableListOf(1,3,2,1)
        return burgerSequence.equals(correctSequence)
    }

}