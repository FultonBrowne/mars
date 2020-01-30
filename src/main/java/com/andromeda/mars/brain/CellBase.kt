package com.andromeda.mars.brain

abstract class CellBase(i:Int, u:Int, size:Int) {
    val index = i
    private val unitSize = u
    var finalData = 0

    val data = arrayListOf<Int>()
    val cells = arrayListOf<CellBase>()
    init {
        run{
        var indexParse = index
        if (indexParse < size){
        while (indexParse < index + unitSize && indexParse < size){
            indexParse = indexParse + 1
            if (indexParse <= 0){
            }
            else if(indexParse == size) {
                return@run
            }
            else{
                cells.add(Cell(index = indexParse + 1, size = size, unitWidth = u))

            }
        }}
            else return@run
            println("done 2")

        }
    }
    open fun dataToCell(newData:Int){

        data.add(newData)
        if (data.size == unitSize){
            data.forEach {
                finalData = if (finalData == 0) it
                else finalData.xor(it)
                dataOutOfCell(finalData)

            }
            data.clear()

        }

    }
    fun setNewDataListener(run:Runnable){
        run.run()
    }
    open fun dataOutOfCell(toSend:Int){
        println(toSend)
        cells.forEach {
            it.dataToCell(toSend)
        }
    }
}