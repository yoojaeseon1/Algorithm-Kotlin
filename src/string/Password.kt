package string// 67

fun main() {

    val password = Password()
    var s = "aukks"
    var skip = "wbqd"
    var index = 5

    print(password.solution(s,skip,index))


}

class Password {

    fun solution(s: String, skip: String, index: Int): String {
        var answer = StringBuilder()

        var isSkipAlphabets = BooleanArray(26)

        for(skipAlphabet in skip) {
            isSkipAlphabets[skipAlphabet.code-97] = true
        }

        for(sChar in s) {
            var endIndex = sChar.code - 97
            var numSkip = index
            while(numSkip > 0) {
                var startIndex = endIndex+1
                endIndex += numSkip
                numSkip = 0
                for(skipIndex in startIndex..endIndex) {
                    if(isSkipAlphabets[skipIndex % 26])
                        numSkip++
                }
            }
            endIndex %= 26
            answer.append((endIndex+97).toChar())
        }

        return answer.toString()
    }


}