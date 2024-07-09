package Queue

import java.util.*


fun main() {

    val bridgeTruck = BridgeTruck()

    val bridge_length = 2
    val weight = 10
    val truck_weights = intArrayOf(7,4,5,6)

    println(bridgeTruck.solution(bridge_length, weight, truck_weights))

}
class BridgeTruck {

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        val truckQueue:Queue<Int> = LinkedList()

        for (truckWeight in truck_weights) {
            truckQueue.add(truckWeight)
        }

        while (truckQueue.isNotEmpty()) {
            var currentWeight = truckQueue.poll()
            var numCrossTruck = 1
            while (truckQueue.isNotEmpty() && truckQueue.peek() + currentWeight <= weight) {
                val truck = truckQueue.poll()
                currentWeight += truck
                numCrossTruck++
            }
            answer += bridge_length + (numCrossTruck - 1)
        }


        return answer + 1
    }

}