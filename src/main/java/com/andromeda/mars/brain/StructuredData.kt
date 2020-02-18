package com.andromeda.mars.brain

class StructuredData(val label:Any, var data:ArrayList<Int> ) {
    fun addData(newData:ArrayList<Int>, cellBase: CellBase){
        val newVal = arrayListOf<Int>()
        newData.forEachIndexed { index, t ->
            newVal.add(cellBase.operation(t, data[index]))
            newVal.reverse()
            data = newVal
            println(data.size)

        }
    }
}