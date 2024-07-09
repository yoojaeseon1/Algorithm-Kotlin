package Queue

import java.util.*


fun main() {

    val bridgeTruck = BridgeTruckV2()

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
class BridgeTruckV2 {

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
//
//        val truckQueue:Queue<Truck> = LinkedList()
//        var currentBridgeWeight = 0
//        var currentTime = 1
//        var truckIndex = 0
//
//        while(truckIndex < truck_weights.size) {
//
//            if(truckQueue.isNotEmpty()) {
//                val currentTruck = truckQueue.poll()
//                currentTime = currentTruck.exitTime
//                currentBridgeWeight -= currentTruck.weight
//                println("currentTime = ${currentTime}")
//                println("currentBridgeWeight = ${currentBridgeWeight}")
//            }
//            println("===")
//            while(truckIndex < truck_weights.size && currentBridgeWeight + truck_weights[truckIndex] <= weight) {
//                println("current exit time = ${currentTime+bridge_length}")
//                val currentExitTime = currentTime+bridge_length
//                val currentTruckWeight = truck_weights[truckIndex++]
//                val lastExitTime = truckQueue.peek().exitTime
//                if(currentExitTime <= lastExitTime)
//                    truckQueue.add(Truck(currentTruckWeight, currentTime+bridge_length))
//                currentBridgeWeight += currentTruckWeight
//                currentTime++
//            }
//            println("=========")
//        }
//
//        while(truckQueue.isNotEmpty())
//            answer = truckQueue.poll().exitTime
//
        return answer
    }

}