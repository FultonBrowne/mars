package com.andromeda.mars.nlp

import opennlp.tools.parser.Parse
import opennlp.tools.parser.Parser
import opennlp.tools.parser.ParserFactory
import opennlp.tools.parser.ParserModel
import java.io.InputStream
import java.util.ArrayList

/**
 * The main class for NLP
 * Tip just change the sentence value Its faster than making new instances every time.
 * **/
class MarsNLP(model:InputStream) {
    /**
     * parsing utility
     * **/
    private val key = KeyWord(model)
    /**
     * the value to be parsed
     * **/
    var sentence:String? = null
    fun getTopics(parse: Parser): ArrayList<WordGraph> {
        println("go")
        val toReturn = ArrayList<WordGraph>()
        print("start")

        var graph = key.getKeyWords(sentence!!,parse)?.get(0)
        graph?.show()


        var working = true
        if (graph != null) {
            print("not null")
            graph.show()

            while (working) {
                when {
                    graph?.childCount == 1 -> {
                        graph = graph.children?.get(0)
                    }
                    graph?.childCount == 0 -> {
                        working = false
                    }
                    else -> {
                        if (graph != null) {
                            toReturn.addAll(sortForNoun(graph))
                        }
                        working = false
                    }

                }
            }
        } else {
            print("null")
            println("fail")
        }
        return toReturn


    }

    private fun sortForNoun(graph: Parse): ArrayList<WordGraph> {
        val toReturn = ArrayList<WordGraph>()
        for (i in graph.children!!) {
            if (i.type == "NN" || i.type == "JJ"|| i.type == "PRP"|| i.type == "IN") {
                toReturn.add(WordGraph(i.coveredText, i.type))
            }
            if (i.childCount > 0) toReturn.addAll(sortForNoun(i))
        }
        return toReturn

    }

}