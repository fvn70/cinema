package cinema

import java.util.*

fun main() {
    println("Enter the number of rows: ")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row: ")
    val cols = readLine()!!.toInt()
    val cinema = Cinema(rows, cols)
    var cmd = 1

    while (cmd != 0) {
        println()
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        cmd = readLine()!!.toInt()
        when (cmd) {
            1 -> cinema.draw()
            2 -> cinema.buy()
            3 -> cinema.stat()
        }
    }
}

class Cinema(val rows: Int = 0, val cols: Int = 0) {
    var row = 0
    var col = 0
    val seats by lazy { MutableList(rows) { MutableList(cols) { 'S' } } }
    var sNums = 0
    var tickets = 0
    var income = 0
    var totalIncom = 0
    init {
        sNums = rows * cols
        val h1 = rows / 2
        val h2 = rows - h1
        totalIncom = cols * (if (sNums <= 60) 10 * rows else (h1 * 10 + h2 * 8))
    }

    fun price(row: Int): Int = if (sNums <= 60 || row <= rows / 2) 10 else 8

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

    fun buy() {
        while (true) {
            println()
            println("Enter a row number: ")
            row = readLine()!!.toInt()
            println("Enter a seat number in that row: ")
            col = readLine()!!.toInt()
            if (row > rows || col > cols) {
                println("Wrong input!")
                continue
            }
            if (seats[row - 1][col - 1] == 'B') {
                println("That ticket has already been purchased!")
                continue
            }
            break
        }
        seats[row - 1][col - 1] = 'B'
        val price = price(row)
        income += price
        tickets++

        println("Ticket price: $$price")
    }

    fun stat() {
        println()
        println("Number of purchased tickets: $tickets")
        println("Percentage: %.2f".format(Locale.US, 100.0 * tickets / sNums) + '%')
        println("Current income: $$income")
        println("Total income: $$totalIncom")
    }
}