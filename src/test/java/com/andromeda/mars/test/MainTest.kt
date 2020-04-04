package com.andromeda.mars.test

import com.andromeda.mars.ml.CellBase
import org.junit.Assert
import org.junit.Test

class MainTest {
    @Test
    fun test(){
        val cellBase = CellBase()
        val data1 = arrayListOf(0, 0, 0, 2)
        cellBase.dataToCell(data1, 2)
        Assert.assertEquals(2, cellBase.recognize(data1))
        cellBase.dataToCell(data1, 2)
        Assert.assertEquals(2, cellBase.recognize(data1))

        cellBase.freeze()
    }
}