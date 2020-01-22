package com.andromeda.mars.brain

class Cell(index:Int, size:Int, unitWidth:Int) {
    private val i = index
    val s = size
    val u = unitWidth
    init {
        val data = i - unitWidth
        if (data < 0){}
    }
    fun update(data:Int){

    }

}