package greedy

fun main() {

    for(number in 1..2) {
        print(number)
    }

}

class WiggleSubsequence {


    fun wiggleMaxLength(nums: IntArray): Int {

        val sequence = mutableListOf<Int>()

        for(numsIndex in 1..nums.size-1) {
            if(nums[numsIndex] - nums[numsIndex-1] > 0)
                sequence.add(1)
            else if(nums[numsIndex] - nums[numsIndex-1] < 0)
                sequence.add(-1)
        }

        if(sequence.size == 0)
            return 1

        var sequenceIndex = 1
        var answer = 1
        var beforeTag = sequence[0]

        while(sequenceIndex < sequence.size) {
            val tag = sequence[sequenceIndex]

            if(tag != beforeTag) {
                answer++
                beforeTag = tag
            }
            sequenceIndex++
        }

        return answer+1

    }
}