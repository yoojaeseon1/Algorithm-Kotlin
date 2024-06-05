package map

fun main() {
    var players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    var callings = arrayOf("kai", "kai", "mine", "mine")
    val runningMatch = RunningMatch()
    val solution = runningMatch.solution(players, callings)

    print(solution.contentToString())
}

class RunningMatch {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerToRank = mutableMapOf<String, Int>()
        val rankToPlayer = mutableMapOf<Int, String>()

        for(playersIndex in players.indices) {
            playerToRank[players[playersIndex]] = playersIndex
            rankToPlayer[playersIndex] = players[playersIndex]
        }

        for(calling in callings) {
            val callingPlayerRank = playerToRank[calling]!!
            playerToRank[calling] = callingPlayerRank - 1

            val beforePlayer = rankToPlayer[callingPlayerRank - 1]!!
            playerToRank[beforePlayer] = callingPlayerRank

            rankToPlayer[callingPlayerRank-1] = calling
            rankToPlayer[callingPlayerRank] = beforePlayer
        }

        val answer = Array(players.size) {""}
        val playerIterator = rankToPlayer.entries.iterator()
        while (playerIterator.hasNext()) {
            val player = playerIterator.next()
            answer[player.key] = player.value
        }

        return answer
    }

}