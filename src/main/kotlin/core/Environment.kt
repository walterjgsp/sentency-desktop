package core

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory


class Environment {

    var baseUrl: String = ""
        private set
    var apiKey: String = ""
        private set

    init {
        getConfigJson()
    }

    private fun getConfigJson() {
        val conf: Config = ConfigFactory.load()
        baseUrl = conf.getStringOrNull("server.baseUrl") ?: "http://localhost:7000/"
        apiKey = conf.getStringOrNull("server.apiKey") ?: "APIKEY"
    }

    private fun Config.getStringOrNull(key: String): String? {
        return try {
            this.getString(key)
        } catch (e: Exception) {
            null
        }
    }

}
