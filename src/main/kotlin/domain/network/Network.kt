package domain

import core.Environment
import core.Constants.HEADER_API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofit(environment: Environment): Retrofit {
    return Retrofit.Builder()
        .baseUrl(environment.baseUrl)
        .client(provideOkHttpClient(environment))
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideOkHttpClient(environment: Environment): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(createInterceptor(environment)).build()
}

private fun createInterceptor(environment: Environment): Interceptor {
    return Interceptor { chain ->
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .url(originalRequest.url)
            .addHeader(HEADER_API_KEY, environment.apiKey)
            .method(originalRequest.method, originalRequest.body)
            .build()

        chain.proceed(newRequest)
    }
}

inline fun <reified T> provideApi(retrofit: Retrofit): T = retrofit.create(T::class.java)
