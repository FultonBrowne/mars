package com.andromeda.mars.brain

class StructuredData(val label:Any, val data:ArrayList<Int> ) {
    fun addData(newData:ArrayList<Int>, cellBase: CellBase){
        newData.forEachIndexed { index, t ->
            cellBase.operation(t, data[index])
        }
    }
}