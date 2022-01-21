package cinema

var rows = 7
var cols = 8
val seats by lazy { MutableList(rows) { MutableList(cols) { 'S' } } }


fun main() {
    println("Enter the number of rows:")
    rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    cols = readLine()!!.toInt()

    while (true) {
        when (menu()) {
            1 -> draw()
            2 -> buyTicket()
            else -> break
        }
    }
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
            print("${seats[i - 1][j - 1]} ")
        println()
    }
}

fun menu(): Int {
    println("""
1. Show the seats
2. Buy a ticket
0. Exit""")
    return readLine()!!.toInt().coerceIn(0..2)
}

fun buyTicket() {
    println()
    println("Enter a row number:")
    val row = readLine()!!.toInt()
    println("Enter a seat number in that row:")
    val col = readLine()!!.toInt()

    println("Ticket price: \$${price(row)}")
    seats[row - 1][col - 1] = 'B'
}