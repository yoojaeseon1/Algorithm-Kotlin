package map

//90
class Clothes {

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val typeToClothes = mutableMapOf<String, MutableList<String>>()

        for (clothe in clothes) {
            val clotheName = clothe[0]
            val type = clothe[1]
            if(typeToClothes[type] == null)
                typeToClothes[type] = mutableListOf(clotheName)
            else
                typeToClothes[type]!!.add(clotheName)
        }

        for (typeToClothesIter in typeToClothes) {
            answer *= typeToClothesIter.value.size + 1
        }

        return answer-1
    }
}