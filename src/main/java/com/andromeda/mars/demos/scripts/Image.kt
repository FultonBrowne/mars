package com.andromeda.mars.demos.scripts

import com.andromeda.mars.ml.CellBase
import java.io.File
import java.io.FileInputStream


class Image {
    //read the cifar-10 dataset
    fun main(){
        println("start")
        val cell = CellBase()
        add(cell)
        test(cell)
    }
    fun add(cell: CellBase){
        val file = File(readLine()!!)
        val fis = FileInputStream(file)
        val airplanesByteArray = fis.readAllBytes()
        var intArray = arrayListOf<Int>()
        var label: Int? = null
        var gotLabel = false
        airplanesByteArray.forEach {
            if (gotLabel){
                intArray.add(it.toInt())
                if (intArray.size == 3072){
                    cell.dataToCell(intArray, label!!)
                    intArray= arrayListOf<Int>()
                    gotLabel = false
                }
            }
            else{
                label = it.toInt()
                gotLabel = true
            }

        }
        println("add more data")
        if (readLine() == "y"){
            add(cell)
        }
    }
    fun test(cell:CellBase){
        val file = File(readLine()!!)
        val fis = FileInputStream(file)
        val airplanesByteArray = fis.readAllBytes()
        val intArray = arrayListOf<Int>()
        var label: Int? = null
        var gotLabel = false
        var yes = 0
        var no = 0
        airplanesByteArray.forEach {
            if (gotLabel){
                intArray.add(it.toInt())
                if (intArray.size == 3072){
                    if(label == cell.recognize(intArray)) yes += 1
                    else no += 1
                    intArray.clear()
                    gotLabel = false
                }
            }
            else{
                label = it.toInt()
                gotLabel = true
            }

        }
        println("yes = $yes")
        println("no = $no")
    }




}