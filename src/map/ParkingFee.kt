package map

import java.util.*

// 96

fun main() {

//    val fees = intArrayOf(180, 5000, 10, 600)
//    val records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")

//    val fees = intArrayOf(120, 0, 60, 591)
//    val records = arrayOf("16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN")

    val fees = intArrayOf(1, 461, 1, 10)
    val records = arrayOf("00:00 1234 IN")

    val parkingFee = ParkingFee()

    println(parkingFee.solution(fees, records))

//    println(15 / 10.0)00

}
class ParkingFee {

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carNumberToRecord = TreeMap<String, MutableList<String>>()
        for (record in records) {
            val splitRecord = record.split(" ")
            val parkingInfos = carNumberToRecord[splitRecord[1]]?: mutableListOf()
            parkingInfos.add(splitRecord[0])
            carNumberToRecord[splitRecord[1]] = parkingInfos
        }

        val sortedCarNumberToRecord = carNumberToRecord.toSortedMap()
        val answer = IntArray(carNumberToRecord.size)
        var answerIndex = 0
        for (carIter in sortedCarNumberToRecord) {
            val parkingTimes = carIter.value
            if (parkingTimes.size % 2 == 1)
                parkingTimes.add("23:59")

            var parkingTimesIndex = 0
            var totalUsingTime = 0
            var totalFee = 0
            while (parkingTimesIndex < parkingTimes.size) {
                val inTime = parkingTimes[parkingTimesIndex++].split(":")
                val outTime = parkingTimes[parkingTimesIndex++].split(":")
                val inTimeToMinutes = (inTime[0].toInt() * 60) + inTime[1].toInt()
                val outTimeToMinutes = (outTime[0].toInt() * 60) + outTime[1].toInt()

                totalUsingTime += outTimeToMinutes - inTimeToMinutes
            }

            if(totalUsingTime <= fees[0])
                totalFee = fees[1]
            else{
                totalUsingTime -= fees[0]
                totalFee += fees[1] + Math.ceil(totalUsingTime.toDouble() / fees[2]).toInt() * fees[3]
            }

            answer[answerIndex++] = totalFee
        }

        return answer
    }

}

