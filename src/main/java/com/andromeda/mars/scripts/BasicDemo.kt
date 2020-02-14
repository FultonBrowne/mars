package com.andromeda.mars.scripts

import com.andromeda.mars.brain.Generate

class BasicDemo {
    fun main(){
        val cell = Generate().singleTrain(700, 4)
        val inputThread = Thread {

        }
        inputThread.start()
    }
}