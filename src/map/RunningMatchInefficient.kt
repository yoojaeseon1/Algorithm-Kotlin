package map

fun main() {

    var players = arrayOf("mumu", "soe", "poe", "kai", "mine")
    var callings = arrayOf("kai", "kai", "mine", "mine")

    val runningMatchInefficient = RunningMatchInefficient()

    runningMatchInefficient.solution(players, callings)

//    val nameToPlayer = mutableMapOf<String, Player?>()

//    val player = players[0]
//    nameToPlayer[player] = Player(player, 1, null)

//    nameToPlayer["mumu"]!!.rank--

//    print(nameToPlayer["mumu"]!!.rank)

}

class RunningMatchInefficient {


    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        val nameToPlayer = mutableMapOf<String, Player?>()
        val player = Player(players[0], 1, null)
        var afterPlayer = Player(players[1], 2, player)
        player.afterPlayer = afterPlayer
        nameToPlayer[player.name] = player

        for(playersIndex in 1.. players.size - 2) {
            val currentPlayer = afterPlayer
            afterPlayer = Player(players[playersIndex+1], playersIndex+2, currentPlayer)
            currentPlayer.afterPlayer = afterPlayer
            nameToPlayer[currentPlayer.name] = currentPlayer
        }
        nameToPlayer[afterPlayer.name] = afterPlayer


        for(calling in callings) {

            val player = nameToPlayer[calling]
            val beforePlayer = player?.beforePlayer
            player!!.rank--
            beforePlayer!!.rank++

            val tempPlayer = player?.afterPlayer
            player?.afterPlayer?.beforePlayer = beforePlayer
            beforePlayer?.beforePlayer?.afterPlayer = player

            player?.beforePlayer = beforePlayer?.beforePlayer
            player?.afterPlayer = beforePlayer
            beforePlayer?.beforePlayer = player
            beforePlayer?.afterPlayer = tempPlayer
        }

        var answer = Array(players.size, {""})
        val playerIter = nameToPlayer.entries.iterator()
        while (playerIter.hasNext()) {
            val entry = playerIter.next()
            val player = entry.value
            answer[player!!.rank-1] = player.name
        }
        return answer
    }

    class Player(
        var name: String
        , var rank: Int
        , var beforePlayer: Player? = null
        , var afterPlayer: Player? = null
    )

}