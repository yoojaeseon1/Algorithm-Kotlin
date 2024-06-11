package string


// 76

fun main() {

//    val s = "3people unFollowed me"
    val s = "for the last week"


    val jadenCase = JadenCase()

    println(jadenCase.solution(s))


}

class JadenCase {

    fun solution(s: String): String {

        val sStringBuilder = StringBuilder(s)
        if(s[0].code in 97..122)
            sStringBuilder[0] = Character.toUpperCase(s[0])

        var beforeChar = s[0]
        for(sIndex in 1.. s.length-1) {
            val currentChar = s[sIndex]
            if(beforeChar == ' ' && currentChar.code in 97..122)
                sStringBuilder[sIndex] = Character.toUpperCase(currentChar)

            if(beforeChar != ' ' && currentChar.code in 65..90)
                sStringBuilder[sIndex] = Character.toLowerCase(currentChar)

            beforeChar = currentChar
        }

        return sStringBuilder.toString()
    }


}
