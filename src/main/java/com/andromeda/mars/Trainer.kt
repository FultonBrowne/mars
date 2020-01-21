package com.andromeda.mars

import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList


class Trainer {
    fun main(data:InputStream){
        val s: Scanner = Scanner(data).useDelimiter("\\A")
        val fullText = if (s.hasNext()) s.next() else ""
        val list = JsonParse().preTrainer(fullText)
        val finalList = ArrayList<Data>()
        for (i in list){
            var dataIsMerged = false
            val dataToMerge = i.data
            println(dataToMerge)
            for (f in finalList){
                val newData = ByteArray(f.data.size)
                if (i.label== f.label){
                    dataIsMerged = true
                    f.data.forEachIndexed { index, byte ->

                    }
                    break
                }
            }
            if (!dataIsMerged){
                finalList.add(Data(i.label, dataToMerge))
            }
        }
    }
}