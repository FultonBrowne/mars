package com.andromeda.mars.demos.scripts

import com.andromeda.mars.brain.CellBase
import java.awt.Label
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream


class Image {
    //read the cifar-10 dataset
    fun main(){
        val cell = CellBase()
        val file = File("CharacterStats.dat")
        val fis = FileInputStream(file)
        val airplanesByteArray = fis.readAllBytes()
    }

    fun writeData(label: String, data:Any, cellBase: CellBase){

    }


}