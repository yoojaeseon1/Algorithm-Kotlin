package stack

import java.util.Stack


// 84
fun main() {

//    var s = "1234"
//
//    s = s.plus('5').removeRange(0,1)
//
//    println("s = ${s}")

    val bracketRotation = BracketRotation()

    print(bracketRotation.solution("}}}"))

    val stack = Stack<String>()

    repeat(5) {

    }

}
class BracketRotation {

    fun solution(s: String): Int {
        var numCorrectRotate = 0
        var numRotate = 0
        val sToBuilder = StringBuilder(s)

        if(isCorrectBrakets(sToBuilder))
            numCorrectRotate++

        while (numRotate < s.length - 1) {
            sToBuilder.append(sToBuilder[0])
            sToBuilder.deleteCharAt(0)

            if(isCorrectBrakets(sToBuilder))
                numCorrectRotate++

            numRotate++
        }

        return numCorrectRotate
    }

    fun isCorrectBrakets(brackets: StringBuilder): Boolean{
        val bracketStack = Stack<Char>()
        val closeBrackets = mutableListOf(')','}',']')
        val closeToOpen = mutableMapOf(')' to '(', '}' to '{', ']' to '[')

        for (bracket in brackets) {
            if (bracket in closeBrackets) {
                if (bracketStack.isNotEmpty() && closeToOpen[bracket] == bracketStack.peek())
                    bracketStack.pop()
                else
                    return false
            } else
                bracketStack.push(bracket)
        }

        return bracketStack.isEmpty()
    }

}
