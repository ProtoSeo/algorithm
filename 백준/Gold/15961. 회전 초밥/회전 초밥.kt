import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stk = StringTokenizer(br.readLine())
    val n = stk.nextToken().toInt()
    val d = stk.nextToken().toInt()
    val k = stk.nextToken().toInt()
    val c = stk.nextToken().toInt()
    val ary = IntArray(n + k - 1)
    val q = ArrayDeque<Int>()
    val totalCnt = mutableSetOf<Int>()
    for (i in 0 until n) {
        ary[i] = br.readLine().toInt()
        totalCnt.add(ary[i])
    }
    for (i in n until n + k - 1) {
        ary[i] = ary[i - n]
    }
    val kinds = IntArray(d + 1)
    var kindsCount = 0
    var answer = 0
    for (i in 0 until n + k) {
        if (q.size == k) {
            val now = if (kinds[c] == 0) kindsCount + 1 else kindsCount
            answer = Math.max(now, answer)

            val pop = q.poll()
            if (--kinds[pop] == 0) kindsCount--
        }
        if (i == n + k - 1) break
        q.add(ary[i])
        if (kinds[ary[i]]++ == 0) kindsCount++
    }
    println(answer)
}