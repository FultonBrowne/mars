package com.andromeda.mars.brain

class StructuredData(val label:Any, var data:ArrayList<Int> ) {
    fun addData(newData:ArrayList<Int>, cellBase: CellBase){
        newData.forEachIndexed { index, t ->
            data[index] = cellBase.operation(t, data[index])
            }


    }
}