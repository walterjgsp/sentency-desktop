package domain

import core.Config
import core.Constants.HEADER_API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofit(config: Config): Retrofit {
    return Retrofit.Builder()
        .baseUrl(config.baseUrl)
        .client(provideOkHttpClient(config))
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideOkHttpClient(config: Config): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(createInterceptor(config)).build()
}

private fun createInterceptor(config: Config): Interceptor {
    return Interceptor { chain ->
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .url(originalRequest.url)
            .addHeader(HEADER_API_KEY, config.apiKey)
            .method(originalRequest.method, originalRequest.body)
            .build()

        chain.proceed(newRequest)
    }
}

inline fun <reified T> provideApi(retrofit: Retrofit): T = retrofit.create(T::class.java)
