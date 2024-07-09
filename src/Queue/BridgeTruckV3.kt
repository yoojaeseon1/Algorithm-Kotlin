package Queue

import java.util.*


fun main() {

    val bridgeTruck = BridgeTruckV3()

//    val bridge_length = 2
//    val weight = 10
//    val truck_weights = intArrayOf(7,4,5,6)
//    val bridge_length = 10
//    val weight = 3
//    val truck_weights = intArrayOf(3,4,5,2,3)
//    val bridge_length = 5
//    val weight = 10
//    val truck_weights = intArrayOf(10,5,5,10,10)
    val bridge_length = 5
    val weight = 5
    val truck_weights = intArrayOf(2,2,2,2,1,1,1,1,1)

    println(bridgeTruck.solution(bridge_length, weight, truck_weights))

}
class BridgeTruckV3 {

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        val truckQueue: Queue<Truck> = LinkedList()
        var truckIndex = 0
        truckQueue.add(Truck(1, truck_weights[truckIndex]))
        var currentTime = 1
        var currentWeight = truck_weights[truckIndex++]

        while (truckQueue.isNotEmpty()) {
            currentTime++
            val truck = truckQueue.peek()
            if(currentTime == truck.startTime + bridge_length) {
                answer = truck.startTime + bridge_length
                currentWeight -= truck.weight
                truckQueue.poll()
            }

            if (truckIndex < truck_weights.size && truck_weights[truckIndex] + currentWeight <= weight) {
                val nextTruck = truck_weights[truckIndex++]
                truckQueue.add(Truck(currentTime, nextTruck))
                currentWeight += nextTruck
            }
        }
        return answer
    }
}

class Truck(val startTime: Int, val weight: Int)