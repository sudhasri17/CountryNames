package com.example.sudhasri.babynames.network

import com.example.sudhasri.babynames.model.NameDTO
import io.reactivex.Observable

class NetworkInterface : ApiInterface {
    private val retrofitInterface = RetrofitService.retrofitInterface

    override fun fetchNameList(fields : String): Observable<List<NameDTO>> {
        return retrofitInterface.fetchNameList(fields)
    }
}