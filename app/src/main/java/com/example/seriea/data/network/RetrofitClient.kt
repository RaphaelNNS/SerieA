package com.example.seriea.data.network

import android.util.Log
import com.example.seriea.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private const val BASE_URL = "https://api.football-data.org/v4/"
    private const val API_KEY = BuildConfig.API_KEY
        private val okHttpClient: OkHttpClient by lazy {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.HEADERS
                }).addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("X-Auth-Token", API_KEY).build()
                    chain.proceed(request)
                }
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
        }


        val instance: SoccerApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SoccerApiService::class.java)
    }
}