package com.andromeda.mars.brain

abstract class CellBase(i:Int, u:Int, size:Int) {
    val index = i
    private val unitSize = u
    var finalData = 0

    private val data = arrayListOf<Int>()
    private val cells = arrayListOf<CellBase>()
    init {
        run{
        var indexParse = index
        if (indexParse + (unitSize * 2) < size){
        while (indexParse < index + unitSize  && indexParse + (unitSize* 2) < size ){
            indexParse += 1
            if (indexParse <= 0 ||indexParse+ (unitSize *  2) == size){
            }
            else if(indexParse + (unitSize *  2)  >= size  ) {
                return@run
            }
            else{
                cells.add(Cell(index = indexParse + (unitSize * 2) , size = size, unitWidth = u))
                println("done 121")

            }
        }}
            else return@run

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