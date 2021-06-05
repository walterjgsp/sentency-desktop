package core

import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.File

class Config {

    var baseUrl: String = ""
    var apiKey: String = ""

    init {
        getConfigJson()
    }

    private fun getConfigJson(){
        val bufferedReader: BufferedReader = File("./src/main/resources/config.json").bufferedReader()
        val parser = JsonParser().parse(bufferedReader).asJsonObject
        baseUrl = parser.get("baseUrl").asString
        apiKey = parser.get("apiKey").asString
    }
}
