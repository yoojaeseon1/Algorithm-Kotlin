package Queue


// 마법의 엘리베이터(프로그래머스)

class MagicElevator {


    fun solution(storey: Int): Int {

        return Math.min(calcMinMovement(storey, true), calcMinMovement(storey, false))
    }

    private fun calcMinMovement(storey: Int, isMovedUpIfFive: Boolean): Int{
        var numMoved = 0

        val storeyToString = storey.toString()
        var isAddedFloor = false

        val downRange =
            if(isMovedUpIfFive) 4
            else 5

        for (storeyIndex in storeyToString.length - 1 downTo 0) {
            var currentFloor = storeyToString[storeyIndex].digitToInt()

            if (isAddedFloor)
                currentFloor++

            if (currentFloor in 0..downRange) {
                numMoved += currentFloor
                isAddedFloor = false
            } else {
                numMoved += 10 - currentFloor
                isAddedFloor = true
            }
        }

        if (isAddedFloor)
            numMoved++

        return numMoved
    }

//    fun solution(storey: Int): Int {
//
//        var numMoved = 0
//
//        val storeyToString = storey.toString()
//        var isAddedFloor = false
//
//        for (storeyIndex in storeyToString.length - 1 downTo 0) {
//            var currentFloor = storeyToString[storeyIndex].digitToInt()
//
//            if (isAddedFloor)
//                currentFloor++
//
//            when(currentFloor) {
//                in 0..4 -> {
//                    numMoved += currentFloor
//                    isAddedFloor = false
//                }
//                5 -> {
//                    if (storeyIndex > 0) {
//                        val beforeStorey = storeyToString[storeyIndex - 1].digitToInt()
//                        when(beforeStorey) {
//                            in 0..4 -> {
//                                numMoved += currentFloor
//                                isAddedFloor = false
//                            } else -> {
//                                numMoved += 10 - currentFloor
//                                isAddedFloor = true
//                            }
//                        }
//                    } else {
//                        numMoved += currentFloor
//                        isAddedFloor = false
//                    }
//                }
//                else -> {
//                    numMoved += 10 - currentFloor
//                    isAddedFloor = true
//                }
//            }
//        }
//
//        if (isAddedFloor)
//            numMoved++
//
//        return numMoved
//    }
}