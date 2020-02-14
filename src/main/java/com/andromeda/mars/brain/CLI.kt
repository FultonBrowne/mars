package com.andromeda.mars.brain

class CLI {
    fun main(){
        println("how big is the data set?")
        val size = readLine()!!.toInt()
        println("communication width???")
        val inSize = readLine()!!.toInt()
        val cell = Generate().singleTrain(size, inSize)
        println("type 'x' to exit")
        var isRunning = true
        while (isRunning){
            val input = readLine()!!
            if (input == "x")isRunning = false
            else cell[0].dataToCell(input.toInt())
        }

    }
}