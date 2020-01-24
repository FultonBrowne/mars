package com.andromeda.mars.brain

abstract class CellBase(i:Int, u:Int, size:Int) {
    val index = i
    val unitSize = u
    val data = arrayListOf<Int>()
    val cells = arrayListOf<CellBase>()
    init {
        var sizeSplit =unitSize / 2
        var indexParse = i - sizeSplit
        while (!sizeSplit.equals(unitSize)){
            indexParse += 1
            sizeSplit = sizeSplit.plus(1)
        }
    }
    open fun getData(newData:Int){
        var finalData = 0

        data.add(newData)
        if (data.size == unitSize){
            data.forEach {
                finalData = if (finalData == 0) it
                else finalData.xor(it)
            }
            data.clear()
        }
        sendData(finalData)
    }
    open fun sendData(toSend:Int){
        cells.forEach {
            it.getData(toSend)
        }
    }
}