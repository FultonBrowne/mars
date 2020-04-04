package com.andromeda.mars.demos.scripts

import com.andromeda.mars.ml.CellBase

class BasicDemo {
    fun main(){
        println("test 2 running")
        val cell = CellBase()
        cell.dataToCell(arrayListOf(0, 0, 2, 0), 0)
        cell.dataToCell(arrayListOf(0, 0, 3, 0), 0)
        cell.dataToCell(arrayListOf(5, 2, 2, 0), 3)
        val recognize = cell.recognize(arrayListOf(2, 0, 2, -7))
        println(recognize)
    }
}