import java.io.*
import java.util.*

lateinit var tree: IntArray
var s = 1
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stk = StringTokenizer(br.readLine())
    val n = stk.nextToken().toInt()
    val k = stk.nextToken().toInt()
    val target = (k + 1) / 2
    val data = IntArray(n + 1)
    var answer = 0L
    init()
    for (i in 1..n) {
        val temperature = br.readLine().toInt()
        data[i] = temperature
        update(temperature, 1)
        if (i >= k) {
            answer += query(1, s, 1, target)
            update(data[i - k + 1], -1)
        }
    }
    println(answer)
}

fun init() {
    while (s <= 100_000) {
        s *= 2
    }
    tree = IntArray(s * 2)
}

fun update(target: Int, cnt: Int) {
    var node = target + s
    tree[node] += cnt
    while (node > 1) {
        node /= 2
        tree[node] = tree[node * 2] + tree[node * 2 + 1]
    }
}

fun query(left: Int, right: Int, node: Int, target: Int): Int {
    if (left == right) {
        return node - s
    }
    val mid = (left + right) shr 1
    return if (tree[node * 2] >= target) {
        query(left, mid, node * 2, target)
    } else {
        query(mid + 1, right, node * 2 + 1, target - tree[node * 2])
    }
}