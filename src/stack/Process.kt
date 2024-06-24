package stack

import java.util.*

//92
fun main() {

    val priorities = intArrayOf(1, 1, 9, 1, 1, 1)
    val location = 0

    val process = Process()

    print(process.solution(priorities, location))

}

class Process {

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val priorityPairs = LinkedList<Pair<Int,Int>>()
        for ((index, priority) in priorities.withIndex()) {
            priorityPairs.add(Pair(index, priority))
        }

        var numExecute = 1
        while (priorityPairs.isNotEmpty()) {
            val priorityPair = priorityPairs.poll()
            if(isExistUpperPriorities(priorityPair.second, priorityPairs)) {
                priorityPairs.add(priorityPair)
                continue
            }

            if(priorityPair.first == location) {
                answer = numExecute
                break
            }
            numExecute++
        }
        return answer
    }

    private fun isExistUpperPriorities(currentPriority: Int, priorities: LinkedList<Pair<Int,Int>>): Boolean{

        for (priority in priorities) {
            if(priority.second > currentPriority)
                return true
        }
        return false
    }

}