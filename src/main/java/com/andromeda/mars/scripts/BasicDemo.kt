package com.andromeda.mars.scripts

import com.andromeda.mars.brain.Generate

class BasicDemo {
    fun main(){
        val cell = Generate().amlModel( 4)
        cell.dataToCell(arrayListOf(0, 0, 2, 0), 0)
        val recognize = cell.recognize(arrayListOf(0, 0, 2, 0))
        println(recognize)
    }
}