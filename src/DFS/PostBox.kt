package DFS

import java.util.*

// 106
fun main() {


    val postBox = PostBox()

    println(postBox.solution(intArrayOf(5, 4, 3, 2, 1)))

}

class PostBox {


    fun solution(order: IntArray): Int {
        var answer = 0

        val postStack = Stack<Int>()
        var currentBoxNumber = 1
        val maxPostNumber = order.size

        for (o in order) {

            if(currentBoxNumber == o) {
                currentBoxNumber++
                answer++
                continue
            }

            if(postStack.isNotEmpty() && postStack.peek() == o) {
                postStack.pop()
                answer++
                continue
            }

            while (currentBoxNumber != o && currentBoxNumber <= maxPostNumber) {
                postStack.push(currentBoxNumber)
                currentBoxNumber++
            }

            if(currentBoxNumber == o) {
                answer++
                currentBoxNumber++
            } else
                break
        }

        return answer
    }

}