/*Дана строка символов s. Найти длину самой длинной подстроки состоящей из неповторяющихся символов.
Протестировать полученное решение, в том числе и на таких исходных данных. Добиться, чтобы время выполнения программы было в разумных пределах (до 200 мс)*/

import kotlin.system.measureTimeMillis
fun longestSubstringLen(s: String): Int {
    val charIdMap = mutableMapOf<Char, Int>()
    var maxLength = 0
    var start = 0

    for (i in s.indices) {
        val currentChar = s[i]

        if (charIdMap.containsKey(currentChar))
            start = maxOf(start, charIdMap[currentChar]!! + 1)

        charIdMap[currentChar] = i
        maxLength = maxOf(maxLength, i - start + 1)
    }

    return maxLength
}

fun main() {
    print("| Введите s: ")
    val s = readLine() ?: return

    testLongestSubstringLen(s)
}

fun testLongestSubstringLen(s: String) {
    val startTime = System.currentTimeMillis()
    val result = longestSubstringLen(s)
    val endTime = System.currentTimeMillis()
    val time = endTime - startTime
    println("Вывод: $result, Время: $time мс")
}