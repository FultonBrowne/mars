package com.andromeda.mars.brain

class OutputCell(i:Int, u:Int):CellBase(i, u) {
    override fun getData(newData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendData(toSend: ArrayList<Int>) {
        println(index.toString() + "" +toSend)
    }
}