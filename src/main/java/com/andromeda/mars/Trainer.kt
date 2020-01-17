package com.andromeda.mars

import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList


class Trainer {
    fun main(data:InputStream){
        val s: Scanner = Scanner(data).useDelimiter("\\A")
        val fullText = if (s.hasNext()) s.next() else ""
        val list = JsonParse().preTrainer(fullText)
        val finalList = ArrayList<TrainedData>()
        for (i in list){
            var dataIsMerged = false
            val file = Trainer::class.java.getResource(i.dataDir)
            val dataToMerge = file.content
            println(dataToMerge)
            for (f in finalList){
                if (i.value == f.label){
                    dataIsMerged = true
                    break
                }
            }
            if (!dataIsMerged){
                finalList.add(TrainedData(i.value, dataToMerge))
            }
        }
    }
}