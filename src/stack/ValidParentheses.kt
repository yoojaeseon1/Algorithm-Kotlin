package stack

import java.util.*

//ValidParentheses(leetcode)

class ValidParentheses {

    fun isValid(s: String): Boolean {

        val openToClose = mutableMapOf('[' to ']', '{' to '}', '(' to ')')

        val bracketStack = Stack<Char>()
        for (bracket in s) {

            if(bracket in setOf('[', '{', '(')) {
                bracketStack.push(bracket)
            } else {
                if(bracketStack.size == 0)
                    return false

                val pop = bracketStack.pop()

                if(openToClose[pop] != bracket)
                    return false
            }
        }
        return bracketStack.size == 0
    }
}