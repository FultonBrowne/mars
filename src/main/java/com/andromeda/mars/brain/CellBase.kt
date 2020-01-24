package com.andromeda.mars.brain

abstract class CellBase(i:Int, u:Int, size:Int) {
    val index = i
    val unitSize = u
    val data = arrayListOf<Int>()
    val cells = arrayListOf<CellBase>()
    init {
        val sizeSplit =unitSize / 2
        if(index - sizeSplit < 0){
            var toUp = index - sizeSplit
            while(!toUp.equals(0)){
                cells.add(OutputCell(i, u, size))
                toUp + 1
            }
        }
    }
    open fun getData(newData:Int){
        data.add(newData)
        if (data.size == unitSize){
            var finalData = 0
            data.forEach {
                if (finalData == 0)finalData = it
                else finalData.xor(it)
            }
            data.clear()
        }
        sendData(data)
    }
    abstract fun sendData(toSend:ArrayList<Int>)
}