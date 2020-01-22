package com.andromeda.mars.brain

abstract class CellBase {
    abstract fun getData(newData:Int)
    abstract fun sendData(toSend:ArrayList<Int>)
}