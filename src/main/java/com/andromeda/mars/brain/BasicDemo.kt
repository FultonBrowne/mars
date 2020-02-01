package com.andromeda.mars.brain

import java.util.*

class BasicDemo {
    fun main(){
        val cell = Generate().main(700, 4)
        var inputThread = Thread{
            val time = Timer()
            val refresh = object : TimerTask() {
                override fun run() {
                    cell[500].dataToCell(100000 + (Math.random() * ((10000 - 400) + 1) ).toInt())
                }
            }
            time.schedule(refresh, 0, 18000)

        }
    }
}