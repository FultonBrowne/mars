package com.andromeda.mars.nlp

import opennlp.tools.parser.Parser
import opennlp.tools.parser.ParserFactory
import opennlp.tools.parser.ParserModel
import java.io.InputStream

/**
 * The main class for NLP
 * Tip just change the sentence value Its faster than making new instances every time.
 * **/
class MarsNLP(model:InputStream) {
    /**
     * the value to be parsed
     * **/
    private var parse: Parser = ParserFactory.create(ParserModel(model))
    var sentence:String? = null
    fun getNouns(){

    }

}