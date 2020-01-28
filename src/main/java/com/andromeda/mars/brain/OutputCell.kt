package com.andromeda.mars.brain

class OutputCell(i:Int, u:Int, size:Int):CellBase(i, u, size) {
    override fun dataOutOfCell(toSend: Int) {
        println("$index $toSend")
    }
}