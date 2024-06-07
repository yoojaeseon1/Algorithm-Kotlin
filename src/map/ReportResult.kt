package map

// 74
fun main() {
    val reporterToTarget = mutableMapOf<String, MutableSet<String>>()
    val set = mutableSetOf("haha")

    reporterToTarget["a"] = set

    print(reporterToTarget["a"]?.add("hoho"))

//    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
//    val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val id_list = arrayOf("con", "ryan")
    val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")

    val reportResult = ReportResult()

    print(reportResult.solution(id_list, report, k = 2).contentToString())

}

class ReportResult {

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

        val reporterToTarget = mutableMapOf<String, MutableSet<String>>()
        for(complaint in report) {
            val splitComplaint = complaint.split(" ")
            val reporter = splitComplaint[0]
            val target = splitComplaint[1]
            val targetSet = reporterToTarget[reporter]
            if(targetSet == null)
                reporterToTarget[reporter] = mutableSetOf(target)
             else
                targetSet.add(target)
        }

        val reporterIter = reporterToTarget.entries.iterator()
        val targetToCount = mutableMapOf<String, Int>()
        while (reporterIter.hasNext()) {
            val targetIter = reporterIter.next().value.iterator()
            while (targetIter.hasNext()) {
                val target = targetIter.next()
                targetToCount[target] = targetToCount.getOrDefault(target, 0) + 1
            }
        }

        val answer = IntArray(id_list.size)

        for(idIndex in id_list.indices) {
            val id = id_list[idIndex]
            val targets = reporterToTarget[id]
            var numMoreK = 0
            if(targets != null) {
                val targetIter = targets.iterator()
                while (targetIter.hasNext()) {
                    val target = targetIter.next()
                    if(targetToCount[target]!! >= k) {
                        numMoreK++
                    }
                }
            }
            answer[idIndex] = numMoreK
        }

        return answer
    }

}