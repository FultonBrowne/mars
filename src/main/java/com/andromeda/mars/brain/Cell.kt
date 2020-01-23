package com.andromeda.mars.brain

class Cell(index:Int, size:Int, unitWidth:Int): CellBase(index, unitWidth) {
    private val i = index
    val s = size
    val u = unitWidth
    init {
        val index = i - unitWidth / 2
        if (index < 0){

        }
    }
    override fun getData(newData:Int){
        data.add(newData)
        if (data.size == u){
            var finalData = 0
            data.forEach {
                if (finalData == 0)finalData = it
                else finalData.xor(it)
            }
            data.clear()
        }
    }

    override fun sendData(toSend: ArrayList<Int>) {

    }

}