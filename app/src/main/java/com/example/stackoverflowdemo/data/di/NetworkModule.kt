package com.example.stackoverflowdemo.data.di

import com.example.stackoverflowdemo.data.STACKOVERFLOW_API_HOST
import com.example.stackoverflowdemo.data.network.StackOverflowApi
import com.example.stackoverflowdemo.di.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @JvmStatic
    @AppScope
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @JvmStatic
    @AppScope
    @Provides
    fun provideStackOverFlowRetrofit(okHttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(STACKOVERFLOW_API_HOST)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
    }

    @JvmStatic
    @AppScope
    @Provides
    fun provideStackOverflowApi(retrofit: Retrofit): StackOverflowApi {
        return retrofit.create(StackOverflowApi::class.java)
    }
}