@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var k = 0
    var t = n
    while (abs(t) > 9) {
        t = t / 10
        k += 1
    }
    return (k + 1)

}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = TODO()


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var k = n
    if (n % 2 == 0) {
        k = 2
    } else {
        for (a in 3..sqrt(n.toDouble()).toInt() step 2) {
            if (n % a == 0) {
                k = a
                break
            }
        }
    }
    return k
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var t = 1
    if (n % 2 == 0) {
        t = n / 2
    } else {
        for (a in sqrt(n.toDouble()).toInt() downTo 3 step 2) {
            if (n % a == 0) {
                t = n / a
                break

            }
        }
    }
    return t
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var t = x
    var k = 0
    while (t != 1) {
        if (t % 2 == 0) {
            t /= 2
            k += 1
        } else {
            t = 3 * t + 1
            k += 1
        }
    }
    return k


}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var a = 0
    var k = 0
    for (k in min(n, m)..m * n) {
        if (k % m == 0 && k % n == 0) {
            a = k
            break


        }
    }
    return a
}

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var a = 0
    var k = 0
    for (a in 2..max(m, n)) {
        if (m % a == 0 && n % a == 0) {
            return false
            break
        }
    }
    return true

}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var t = n
    var a = 0
    var b = 0
    while (t != 0) {
        a = t % 10
        b = b * 10 + a
        t = t / 10
    }
    return b
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val j = 9
    val i = 8
    val h = 7
    val g = 6
    val f = 5
    val e = 4
    val d = 3
    val c = 2
    val b = 1
    val a = 0
    var aa = 0
    var bb = 0
    var cc = 0
    var dd = 0
    var ee = 0
    var ff = 0
    var gg = 0
    var hh = 0
    var ii = 0
    var jj = 0
    var t = 0
    var k = n
    if (k == a || k == b || k == c || k == d || k == e || k == f || k == g || k == h || k == i || k == j) {
        return false
    } else {
        while (k > 0) {
            t = k % 10
            k /= 10
            if (t == a) {
                aa++
            }
            if (t == b) {
                bb++
            }
            if (t == c) {
                cc++
            }
            if (t == d) {
                dd++
            }
            if (t == e) {
                ee++
            }
            if (t == f) {
                ff++
            }
            if (t == g) {
                gg++
            }
            if (t == h) {
                hh++
            }
            if (t == i) {
                ii++
            }
            if (t == j) {
                jj++
            }
        }
    }
    return (aa > 0 && bb > 0) || (aa > 0 && cc > 0) || (aa > 0 && dd > 0) || (aa > 0 && ee > 0) || (aa > 0 && ff > 0) || (aa > 0 && gg > 0) || (aa > 0 && hh > 0) || (aa > 0 && ii > 0) || (aa > 0 && jj > 0)
            || (bb > 0 && cc > 0) || (bb > 0 && dd > 0) || (bb > 0 && ee > 0) || (bb > 0 && ff > 0) || (bb > 0 && gg > 0) || (bb > 0 && hh > 0) || (bb > 0 && ii > 0) || (bb > 0 && jj > 0)
            || (cc > 0 && dd > 0) || (cc > 0 && ee > 0) || (cc > 0 && ff > 0) || (cc > 0 && gg > 0) || (cc > 0 && hh > 0) || (cc > 0 && ii > 0) || (cc > 0 && jj > 0)
            || (dd > 0 && ee > 0) || (dd > 0 && ff > 0) || (dd > 0 && gg > 0) || (dd > 0 && hh > 0) || (dd > 0 && ii > 0) || (dd > 0 && jj > 0)
            || (ee > 0 && ff > 0) || (ee > 0 && gg > 0) || (ee > 0 && hh > 0) || (ee > 0 && ii > 0) || (ee > 0 && jj > 0)
            || (ff > 0 && gg > 0) || (ff > 0 && hh > 0) || (ff > 0 && ii > 0) || (ff > 0 && jj > 0)
            || (gg > 0 && hh > 0) || (gg > 0 && ii > 0) || (gg > 0 && jj > 0)
            || (hh > 0 && ii > 0) || (hh > 0 && jj > 0)
            || (ii > 0 && jj > 0)


}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var a = 0
    var b = 0
    var c = 0
    while (a < n) {
        b++
        c = sqr(b)
        a += digitNumber(c)
        if (a >= n) {
            break
        }
    }
    if (a != n) {
        a = a - 1
        c /= 10
    }
    return (c % 10)
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var a = 0
    var b = 0
    var c = 0
    while (a != n) {
        b++
        c = fib(b)
        a = digitNumber(c) + a
        if (a > n) {
            break
        }
    }
    while (a != n) {
        a = a - 1
        c /= 10
    }
    return (c % 10)
}
