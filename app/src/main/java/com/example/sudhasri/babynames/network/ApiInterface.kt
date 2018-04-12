package com.example.sudhasri.babynames.network

import com.example.sudhasri.babynames.model.NameDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface{

    @GET(UrlConfig.LIST_OF_NAMES)
    fun fetchNameList(@Query("fields") fields : String) : Observable<List<NameDTO>>
}