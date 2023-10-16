import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val adjAry = Array(n) { val stk = StringTokenizer(br.readLine());IntArray(n) { stk.nextToken().toInt() } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                if (adjAry[j][i] == 1 && 1 == adjAry[i][k])
                    adjAry[j][k] = 1
            }
        }
    }
    val sb = StringBuilder()
    for (i in 0 until n) {
        for(j in 0 until n) {
            sb.append(adjAry[i][j]).append(' ')
        }
        sb.append('\n')
    }
    println(sb)
}