package DP

// 82

class LongJump {

    fun solution(n: Int): Long {
        if(n == 1)
            return 1

        val numJumpWay = LongArray(n+1)
        numJumpWay[1] = 1
        numJumpWay[2] = 2

        for(numJumpWayIndex in 3..numJumpWay.size-1) {
            numJumpWay[numJumpWayIndex] = (numJumpWay[numJumpWayIndex-1] + numJumpWay[numJumpWayIndex-2]) % 1234567
        }

        return numJumpWay[n]
    }

}