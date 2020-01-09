package com.andromeda.mars

import java.io.InputStream
import java.util.*


class Trainer {
    fun main(data:InputStream){
        val s: Scanner = Scanner(data).useDelimiter("\\A")
        val fullText = if (s.hasNext()) s.next() else ""
    }
}