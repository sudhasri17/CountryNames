package com.example.sudhasri.babynames.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit :Retrofit = getRetrofitInstance()
    val retrofitInterface : ApiInterface = retrofit.create(ApiInterface::class.java)

    private fun getRetrofitInstance() : Retrofit {

        return Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build()
    }

    private fun getHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build()
    }
}