package string

// leetCode

class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {

        var commonPrefix = strs[0]

        for(strsIndex in 1..strs.size-1) {

            val str = strs[strsIndex]
            val shortLength = Math.min(commonPrefix.length, str.length)
            var commonLength = 0
            for(prefixIndex in 0..shortLength - 1) {
                if(str[prefixIndex] == commonPrefix[prefixIndex])
                    commonLength++
                else
                    break
            }

            commonPrefix = commonPrefix.substring(0, commonLength)
            if(commonPrefix.isEmpty())
                break
        }

        return commonPrefix
    }

}