package com.andromeda.mars.test

import com.andromeda.mars.nlp.MarsNLP
import org.junit.Test
import java.net.URL

class NLPTest {
    @Test
    fun createTest(){
        val url =
                URL("https://arafilestore.file.core.windows.net/ara-server-files/parse.bin?sv=2019-02-02&ss=bfqt&srt=sco&sp=rwdlacup&se=2024-04-01T22:11:11Z&st=2019-12-19T15:11:11Z&spr=https&sig=lfjMHSahA6fw8enCbx0hFTE1uAVJWvPmC4m6blVSuuo%3D")
        val `is` = url.openStream()
        val marsNLP = MarsNLP(`is`)
    }

}