package com.andromeda.mars.models

import com.andromeda.mars.brain.CellBase

class StructuredData(val label:Int, val data:ArrayList<Int> ) {
    fun addData(newData:ArrayList<Int>, cellBase: CellBase){
        newData.forEachIndexed { index, t ->
            cellBase.operation(t, data[index])
        }
    }
}