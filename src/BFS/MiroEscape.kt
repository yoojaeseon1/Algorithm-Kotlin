package BFS

import java.util.*

// 미로 탈출(프로그래머스)

fun main() {

    val maps = arrayOf("SOOOL","XXXXO","OOOOO","OXXXX","OOOOE")
//    val maps = arrayOf("LOOXS","OOOOX","OOOOO","OOOOO","EOOOO")

    val miroEscape = MiroEscape()

    println(miroEscape.solution(maps))

}

class MiroEscape {
    fun solution(maps: Array<String>): Int {

        var lebarX = -1
        var lebarY = -1
        var escapeX = -1
        var escapeY = -1
        var startX = -1
        var startY = -1
        val maxX = maps.get(0).length-1
        val maxY = maps.size-1

        for ((positionY, y) in maps.withIndex()) {
            for ((positionX, x) in y.withIndex()) {
                if(x == 'L') {
                    lebarX = positionX
                    lebarY = positionY
                }

                if(x == 'E') {
                    escapeX = positionX
                    escapeY = positionY
                }

                if(x == 'S') {
                    startX = positionX
                    startY = positionY
                }
            }
            if(startX >= 0 && lebarX >= 0 && escapeX >= 0)
                break
        }

        var movedMaps = Array(maxY+1, {IntArray(maxX+1, {-1})})
        val startToLebar = findMinimumRoute(startX, startY, 'L', maps, movedMaps)

        if(startToLebar == -1)
            return -1

        movedMaps = Array(maxY+1, {IntArray(maxX+1, {-1})})

        val lebarToEscape = findMinimumRoute(lebarX, lebarY, 'E', maps, movedMaps)

        if(lebarToEscape == -1)
            return -1

        return startToLebar + lebarToEscape
    }

    private fun findMinimumRoute(startX: Int, startY: Int, targetMark: Char, maps: Array<String>, movedMaps: Array<IntArray>): Int{

        val positionQueue: Queue<Position> = LinkedList()
        movedMaps[startY][startX] = 0
        addPositionInQueue(positionQueue, startX, startY, maps, movedMaps)

        while (positionQueue.isNotEmpty()) {

            val currentPosition = positionQueue.poll()

            val currentX = currentPosition.x
            val currentY = currentPosition.y
            val currentStep = movedMaps[currentY][currentX]

            if(maps[currentY][currentX] == targetMark)
                return currentStep

            addPositionInQueue(positionQueue, currentX, currentY, maps, movedMaps)
        }

        return -1
    }

    private fun addPositionInQueue(positionQueue: Queue<Position>, currentX: Int, currentY: Int, maps: Array<String>, movedMaps: Array<IntArray>) {
        val nextX = arrayOf(0,1,0,-1)
        val nextY = arrayOf(-1,0,1,0)

        for (nextIndex in nextX.indices) {

            val movedX = currentX + nextX[nextIndex]
            val movedY = currentY + nextY[nextIndex]

            if(movedX in 0..movedMaps[0].size-1 && movedY in 0..movedMaps.size-1 && movedMaps[movedY][movedX] == -1 && maps[movedY][movedX] != 'X') {

                movedMaps[movedY][movedX] = movedMaps[currentY][currentX] + 1
                positionQueue.add(Position(movedX, movedY))

            }
        }
    }
}

data class Position(val x: Int, val y: Int)