package com.andromeda.mars.demos.readers

import java.io.InputStreamReader
class GetReader {
    fun getReader(relativePath: String): InputStreamReader {

        return InputStreamReader(this.javaClass.getResourceAsStream(relativePath), "UTF-8");

    }
}