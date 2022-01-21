package cinema

var rows = 7
var cols = 8

fun main() {
    println("Enter the number of rows:")
    rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    cols = readLine()!!.toInt()
    println("Total income:\n$${income()}")
//    draw()
}

fun price(row: Int): Int = if (rows * cols <= 60 || row <= rows / 2) 10 else 8

fun income(): Int {
    var sum = 0
    for (row in 1..rows) {
        sum += cols * price(row)
    }
    return sum
}

fun draw() {
    println()
    println("Cinema:")
    print("  ")
    for (j in 1..cols) print("$j ")
    println()
    for (i in 1..rows) {
        print("$i ")
        for (j in 1..cols)
            print("S ")
        println()
    }
}