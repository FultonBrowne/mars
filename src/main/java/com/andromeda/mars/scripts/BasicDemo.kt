package com.andromeda.mars.scripts

import com.andromeda.mars.brain.Generate

class BasicDemo {
    fun main(){
        println("test 2 running")
        val cell = Generate().amlModel( 4)
        cell.dataToCell(arrayListOf(0, 0, 2, 0), 0)
        cell.dataToCell(arrayListOf(0, 0, 3, 0), 0)
        cell.dataToCell(arrayListOf(5, 2, 2, 0), 3)
        val recognize = cell.recognize(arrayListOf(5, 2, 2, 0))
        println(recognize)
    }
}