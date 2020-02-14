package com.andromeda.mars.brain

class Generate {
    fun singleTrain(size:Int, unitSize:Int): ArrayList<CellBase> {
        val cellList = arrayListOf<CellBase>()
        var mainInt = 0
       while (mainInt < size){
           cellList.add(CellBase(unitSize))
           mainInt += 1
       }
        val mainNum = unitSize / 2
        cellList.forEachIndexed { index, cellBase ->
            var newIndex = index - mainNum
            while (newIndex < index + mainNum){
                try {
                    if (newIndex != index){
                    cellBase.cells.add(cellList[newIndex])
                    }

                }
                catch (e:Exception){
                    e.printStackTrace()
                }
                newIndex += 1
            }
        }
        return cellList
    }
    fun amlModel(unit:Int): CellBase {
        return CellBase(unit)
    }
}