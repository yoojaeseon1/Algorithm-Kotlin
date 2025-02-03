package computing

// 동영상 재생기 (프로그래머스)

fun main() {
    val videoPlayer = VideoPlayer()


    val video_len = "110:33"
    val pos = "00:00"
    val op_start = "00:55"
    val op_end = "02:55"
    val commands = arrayOf("prev","prev","prev","prev","next","prev")

    println(videoPlayer.solution(video_len, pos, op_start, op_end, commands))

}

class VideoPlayer {

    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {

        var currentTime = convertTimeToSeconds(pos)
        val convertedVideoLength = convertTimeToSeconds(video_len)
        val convertedOpStart = convertTimeToSeconds(op_start)
        val convertedOpEnd = convertTimeToSeconds(op_end)

        if(currentTime in convertedOpStart..convertedOpEnd)
            currentTime = convertedOpEnd

        for (command in commands) {
            currentTime = if(command == "next") {
                moveToNext(currentTime, convertedVideoLength, convertedOpStart, convertedOpEnd)
            } else {
                moveToPrev(currentTime, convertedOpStart, convertedOpEnd)
            }
        }

        return convertSecondsToTime(currentTime)
    }

    fun convertTimeToSeconds(time: String): Int{

        val splitTime = time.split(":")

        val minuteToSeconds = splitTime[0].toInt() * 60
        val seconds = splitTime[1].toInt()

        return minuteToSeconds + seconds

    }

    fun convertSecondsToTime(seconds: Int): String{

//        val convertedTime = StringBuilder((seconds / 60).toString())
        var convertedMinutes = StringBuilder((seconds / 60).toString())
        var convertedSeconds = StringBuilder((seconds % 60).toString())

        if(convertedMinutes.length == 1)
            convertedMinutes.insert(0, "0")

        if (convertedSeconds.length == 1)
            convertedSeconds.insert(0, "0")

//        if(convertedTime.length == 1)
//            convertedTime.insert(0, "0")

//        convertedTime.append(":" + (seconds % 60).toString())

        return convertedMinutes.toString() + ":" + convertedSeconds.toString()
    }

    fun moveToNext(currentTime: Int, videoLength: Int, opStart: Int, opEnd: Int): Int{
        val movedTime = currentTime + 10


        return if(movedTime in opStart..opEnd)
            opEnd
        else if(movedTime > videoLength)
            videoLength
        else
            movedTime
    }

    fun moveToPrev(currentTime: Int, opStart: Int, opEnd: Int): Int{
        var movedTime = currentTime - 10

        if(movedTime < 0)
            movedTime = 0

        return if(movedTime in opStart..opEnd)
            opEnd
        else
            movedTime
    }

}