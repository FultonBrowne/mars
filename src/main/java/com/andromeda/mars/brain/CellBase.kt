package com.andromeda.mars.brain

abstract class CellBase(u: Int) {
    var isRunning = true
    private val unitSize = u
    private var finalData = 0
    private val dataForMatch = arrayListOf<Int>()
    val structuredData = 0

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
            val newData2 = dataForMatch

            data.clear()
            isRunning = true
        }

    }
    fun setNewDataListener(run:Runnable){
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
}