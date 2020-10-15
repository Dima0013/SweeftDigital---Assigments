import java.util.*

fun main() {
    val palindrome = isPalindrome("tenet")

    val minSplit = minSplit(111)


    val notContains = notContains(listOf(5, 1, 2, 6, 10, 15, 13, 789, 12, 545, 87, 7, 3))


    val properly = isProperly("(()())")

    val countVariants = countVariants(5)
    println(countVariants)


}


// 1) Is Palindrome or not
fun isPalindrome(firstText: String): Boolean {
    // Make Second CharArray same size as firstText
    val temp = CharArray(firstText.length)


    for ((j, i) in (firstText.length - 1 downTo 0).withIndex()) {
        temp[j] = firstText[i]
    }
    val secondText = String(temp)

    return firstText == secondText
}


// 2) Minimum Split
fun minSplit(amount: Int): Int {
    var minSplit = 0
    var temp = amount
    if (temp / 50 >= 0) {
        minSplit += temp / 50
        temp %= 50
    }
    if (temp / 20 >= 0) {
        minSplit += temp / 20
        temp %= 20
    }
    if (temp / 10 >= 0) {
        minSplit += temp / 10
        temp %= 10
    }
    if (temp / 5 >= 0) {
        minSplit += temp / 5
        temp %= 5
    }
    if (temp / 1 >= 0) {
        minSplit += temp / 1
        temp %= 1
    }

    return minSplit

}


// 3) Not Contains Smallest Integer
fun notContains(array: List<Int>): Int {
    var i = 1

    while (true)
        if (array.contains(i)) i++ else break

    return i
}

// 4) Brackets Correctly Placed
fun isProperly(sequence: String): Boolean {
    val open = ('(')
    val closed = (')')
    val sm = Stack<Char>()

    sequence.forEach {
        if (it == open)
            sm.push(it)
        if (it == closed)
            sm.pop()

    }
    return sm.isEmpty()
}

// 5) Count Variants of Steps in N size stare
fun countVariants(staresCount: Int): Int {
    if (staresCount == 0 || staresCount == 1) return 1
    val num = IntArray(staresCount + 1)
    num[0] = 1
    num[1] = 1
    for (i in 2..staresCount)
        num[i] = num[i - 1] + num[i - 2]
    return num[staresCount]
}

// 6) Data Structure with Delete
fun dataStructure(element: Int) {
    val array = mutableListOf<Int>()
    val hash = mutableMapOf<Int, Int>()
    val index = hash[element] ?: return
    hash.remove(element)

    val size = array.size
    val last = array[size-1]
    Collections.swap(array,index,size-1)

    array.removeAt(size-1)
    hash[last] = index
}

