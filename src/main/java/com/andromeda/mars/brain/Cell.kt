package com.andromeda.mars.brain

class Cell(index:Int, size:Int, unitWidth:Int) {
    private val i = index
    val s = size
    val u = unitWidth
    val data = arrayListOf<Int>()
    init {
        val index = i - unitWidth / 2
        if (index < 0){

        }
    }
    fun update(newData:Int){
        if (data.size > u){
            data.clear()
            data.add(newData)
        }
    }

}