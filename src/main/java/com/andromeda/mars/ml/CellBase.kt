@file:Suppress("MemberVisibilityCanBePrivate")

package com.andromeda.mars.ml

import com.google.gson.Gson
import kotlin.math.absoluteValue

open class CellBase {
    var isRunning = true
    val structuredData = arrayListOf<StructuredData>()
    var useDefaultOperation = true


    open fun dataToCell(newData:ArrayList<Int>, label:Int){
        println(newData.size)
            isRunning = false
            for (i in structuredData) {
                if (i.label == label){
                    i.addData(newData, this)
                    isRunning = true
                    return
                }

            }
            structuredData.add(StructuredData(label, newData))
            isRunning = true



    }
    open fun dataToCell(newData:ArrayList<Int>, label:String){
            for (i in structuredData) {
                if (i.label == label){
                    i.addData(newData, this)
                    isRunning = true
                    return
                }
            structuredData.add(StructuredData(label, newData))
        }

    }
    fun recognize(newData:ArrayList<Int>): Any? {
        val parsed = arrayListOf<StructuredData>()
        structuredData.forEach {
            val intArray = arrayListOf<Int>()
            it.data.forEachIndexed { index, i ->
                intArray.add((i - newData[index]).absoluteValue)
            }
            parsed.add(StructuredData(it.label, intArray))
        }
        var lowest: Any? = null
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

    fun operation(newData: Int, oldData:Int): Int {
        if (!useDefaultOperation){
            return scriptedOperation()
        }
        return newData.xor(oldData)
    }
    fun freeze(): String? {
        return Gson().toJson(this)
    }
    protected fun scriptedOperation(): Int{
        return 0
    }
}