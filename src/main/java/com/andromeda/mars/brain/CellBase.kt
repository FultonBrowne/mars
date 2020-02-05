@file:Suppress("MemberVisibilityCanBePrivate")

package com.andromeda.mars.brain

import com.andromeda.mars.models.StructuredData
import kotlin.math.absoluteValue

abstract class CellBase(u: Int) {
    var isRunning = true
    private val unitSize = u
    private var finalData = 0
    private val dataForMatch = arrayListOf<Int>()
    val structuredData = arrayListOf<StructuredData>()
    var useDefaultOperation = true
    var dataScript = ""


    private val data = arrayListOf<Int>()
     val cells = arrayListOf<CellBase>()

    open fun dataToCell(newData:Int){
        if(isRunning)data.add(newData)
        else return
        if (data.size == unitSize){
            isRunning = false
            println(cells.size)
                val newData2 = data

                for (it in newData2) {
                    finalData = if (finalData == 0) it
                    else finalData.xor(it)
                    dataOutOfCell(finalData)

                }
                data.clear()
            isRunning = true
        }

    }
    open fun dataToCell(newData:Int, label:Int){
        if(isRunning)dataForMatch.add(newData)
        else return
        if (dataForMatch.size == unitSize){
            isRunning = false
            for (i in structuredData) {
                if (i.label == label){
                    i.addData(dataForMatch, this)
                    dataForMatch.clear()
                    isRunning = true
                    return
                }
            }
            structuredData.add(StructuredData(label, dataForMatch))
            dataForMatch.clear()
            isRunning = true



        }


    }
    open fun dataToCell(newData:ArrayList<Int>, label:Int){
        if(isRunning)dataForMatch.addAll(newData)
        else return
        if (dataForMatch.size == unitSize){
            isRunning = false
            for (i in structuredData) {
                if (i.label == label){
                    i.addData(dataForMatch, this)
                    dataForMatch.clear()
                    isRunning = true
                    return
                }
            }
            structuredData.add(StructuredData(label, dataForMatch))
            dataForMatch.clear()
            isRunning = true



        }


    }
    fun recognize(newData:ArrayList<Int>): Int {
        val parsed = arrayListOf<StructuredData>()
        structuredData.forEach {
            val intArray = arrayListOf<Int>()
            it.data.forEachIndexed { index, i ->
                intArray.add((i - newData[index]).absoluteValue)
            }
            parsed.add(StructuredData(it.label, intArray))
        }
        var lowest = 0
        var lowestVal = Int.MAX_VALUE
        parsed.forEach{
            var current = 0
            it.data.forEach {
                current += it
            }
            if (current < lowestVal){
                lowest = it.label
                lowestVal = current
            }
        }
        return lowest
    }
    open fun dataOutOfCell(toSend:Int){
        println(toSend)
        try {
            cells.forEach {
                it.dataToCell(toSend)
            }
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun operation(newData: Int, oldData:Int): Int {
        if (!useDefaultOperation){
            return scriptedOperation()
        }
        return oldData.xor(newData)
    }
    fun freeze(){

    }
    protected fun scriptedOperation(): Int{
        return 0
    }
}