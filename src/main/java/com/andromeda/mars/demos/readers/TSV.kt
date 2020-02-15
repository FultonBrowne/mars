package com.andromeda.mars.demos.readers

import com.univocity.parsers.tsv.TsvParser
import com.univocity.parsers.tsv.TsvParserSettings

class TSV {
    fun main(path:String){
        val settings = TsvParserSettings()
        settings.getFormat().setLineSeparator("\n")
        val parser = TsvParser(settings)
        val allRows = parser.parseAllRecords(GetReader().getReader(path))
        for(i in allRows){}
    }
}