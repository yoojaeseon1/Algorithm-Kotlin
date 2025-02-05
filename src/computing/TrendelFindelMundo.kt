package computing

import java.util.StringTokenizer

// Tren del Fin del Mundo(Softeer)

fun main() {

    val args = arrayOf("4", "10 5", "6 -3", "3 2", "4 2")

    val trendelFindelMundo = TrendelFindelMundo()

    trendelFindelMundo.solution(args)

}

class TrendelFindelMundo {

    fun solution(args: Array<String>) {

        val numCoordination = readln().toInt()

        val coordinations = mutableListOf<Coordination>()

//        for(argIndex in 1..args.size-1) {
//            val coordination = args[argIndex].split(" ")
//            coordinations.add(Coordination(coordination[0].toInt(), coordination[1].toInt()))
//        }

        for (numLoop in 1..numCoordination) {
            val coordination = StringTokenizer(readln())
            coordinations.add(Coordination(coordination.nextToken().toInt(), coordination.nextToken().toInt()))
        }

        var maxNorthCoordination = Coordination(1001,1001)

        for (coordination in coordinations) {
            if(maxNorthCoordination.y > coordination.y) {
                maxNorthCoordination = coordination
            }
        }

        println("${maxNorthCoordination.x} ${maxNorthCoordination.y}")

    }

}

data class Coordination(val x: Int, val y: Int)