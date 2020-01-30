package com.andromeda.mars.brain

class Generate {
    fun main(size:Int, unitSize:Int): ArrayList<CellBase> {
        val cellList = arrayListOf<CellBase>()
        var mainInt = 0
       while (mainInt < size){
           cellList.add(Cell(mainInt, unitSize))
           mainInt += 1
       }
        val mainNum = unitSize / 2
        cellList.forEachIndexed { index, cellBase ->
            var newIndex = index - mainNum
            while (newIndex < index + mainNum + 1){
                try {
                    if (newIndex != index)
                    cellBase.cells.add(cellList[newIndex])

                }
                catch (e:Exception){
                }
                newIndex += 1
            }
        }
        return cellList
    }
}