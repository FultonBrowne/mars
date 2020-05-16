package com.andromeda.mars.nn

class Node() {
    var constant:Byte? = null
    fun operation(data:IntArray): Int {
        var output:Int = 0
        for (byte in data) {
            val i= (byte.times(constant!!))
            output = output + i
        }
        return output
    }
}