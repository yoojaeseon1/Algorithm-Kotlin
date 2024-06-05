package array

fun main() {


    val park = arrayOf("OSO","OOO","OXO","OOO")
    val routes = arrayOf("E 2","S 3","W 1")

    val walkingPark = WalkingPark()

//    print(walkingPark.isPossibleRoute(2,0,2, 2, park))

    print(walkingPark.solution(park, routes).contentToString())


}

class WalkingPark {

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val directionX = intArrayOf(0,1,0,-1) // N,E,S,W
        val directionY = intArrayOf(-1,0,1,0)
        var currentX = -1
        var currentY = -1

        for(parkI in park.indices) {
            for(parkJ in park[parkI].indices) {
                if(park[parkI][parkJ] == 'S') {
                    currentX = parkJ
                    currentY = parkI
                    break;
                }
            }
            if(currentX >= 0)
                break;
        }

        for(route in routes) {
            val splitedRoute = route.split(" ")
            val direction = splitedRoute[0]
            val distance = splitedRoute[1].toInt()
            val directionIndex = when(direction) {
                "N" -> 0
                "E" -> 1
                "S" -> 2
                "W" -> 3
                else -> -1
            }

            if(validateMovement(currentX, currentY, distance, directionIndex, park)) {
                currentX += directionX[directionIndex] * distance
                currentY += directionY[directionIndex] * distance
            }
        }

        return intArrayOf(currentY, currentX)
    }

    fun validateMovement(currentX: Int
                         , currentY: Int
                         , distance: Int
                         , directionIndex: Int
                         , park: Array<String>): Boolean{

        val directionX = intArrayOf(0,1,0,-1)
        val directionY = intArrayOf(-1,0,1,0)

        // 최대 범위 체크
        val lastX = currentX + (directionX[directionIndex] * distance)
        val lastY = currentY + (directionY[directionIndex] * distance)
        if(lastX < 0 || lastX >= park[0].length || lastY < 0 || lastY >= park.size)
            return false
        
        // 이동 간 장애물 체크
        for(numMoved in 1..distance) {
            val movedX = currentX + (directionX[directionIndex] * numMoved)
            val movedY = currentY + (directionY[directionIndex] * numMoved)
            if(park[movedY][movedX] == 'X')
                return false
        }

        return true
    }

}