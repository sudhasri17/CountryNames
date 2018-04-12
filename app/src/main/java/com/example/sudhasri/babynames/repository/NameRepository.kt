package com.example.sudhasri.babynames.repository

import com.example.sudhasri.babynames.contract.NameScreenContract
import com.example.sudhasri.babynames.model.NameDTO
import com.example.sudhasri.babynames.network.RetrofitService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object NameRepository : NameScreenContract.Repository{
    private const val FIELD_VALUE_NAME = "name"
    private val retrofitInterface  = RetrofitService.retrofitInterface

    override fun fetchNameList(): Observable<List<NameDTO>> {
        return retrofitInterface.fetchNameList(FIELD_VALUE_NAME)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}