package com.andromeda.mars.brain

abstract class CellBase(i:Int, u:Int, size:Int) {
    val index = i
    val unitSize = u
    val data = arrayListOf<Int>()
    val cells = arrayListOf<CellBase>()
    init {
        println("==============================================================")
        val sizeSplit =unitSize / 2
        println("size =" + size )
        var indexParse = index - unitSize
        println("index =$index")
        while (indexParse != sizeSplit + unitSize){
            indexParse = indexParse + 1
            println(indexParse)
            if (indexParse <= 0){
                println("nope 1")
            }
            else if(indexParse == size) {
                println("brain")
                break
            }
            else{
                println(indexParse)
                cells.add(Cell(index = indexParse + 1, size = size, unitWidth = u))
            }
        }
        println("done")
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
        println(toSend)
        cells.forEach {
            it.getData(toSend)
        }
    }
}