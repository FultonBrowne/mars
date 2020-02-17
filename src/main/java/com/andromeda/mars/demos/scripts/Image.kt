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
        val file = File(readLine()!!)
        val fis = FileInputStream(file)
        val airplanesByteArray = fis.readAllBytes()
        val intArray = arrayListOf<Int>()
        var label: Int? = null
        var gotLabel = false
        airplanesByteArray.forEach {
            if (gotLabel){
                intArray.add(it.toInt())
                if (intArray.size == 3072){
                    cell.dataToCell(intArray, label!!)
                    intArray.clear()
                    gotLabel = false
                }
            }
            else{
                label = it.toInt()
                gotLabel = true
            }

        }
        test(cell)
    }
    fun test(cell:CellBase){
        val file = File(readLine()!!)
        val fis = FileInputStream(file)
        val airplanesByteArray = fis.readAllBytes()
        val intArray = arrayListOf<Int>()
        var label: Int? = null
        var gotLabel = false
        airplanesByteArray.forEach {
            if (gotLabel){
                intArray.add(it.toInt())
                if (intArray.size == 3072){
                    println("label = $label")
                    println("returned = " + cell.recognize(intArray))
                    intArray.clear()
                    gotLabel = false
                }
            }
            else{
                label = it.toInt()
                gotLabel = true
            }

        }
    }




}