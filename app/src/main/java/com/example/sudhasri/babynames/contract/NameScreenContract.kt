package com.example.sudhasri.babynames.contract

import com.example.sudhasri.babynames.repository.NameRepository
import com.example.sudhasri.babynames.presenter.BasePresenter
import com.example.sudhasri.babynames.presenter.NamePresenter
import com.example.sudhasri.babynames.model.NameDTO
import io.reactivex.Observable

interface NameScreenContract{
    interface View{
        fun showLoader()
        fun showDataInView(sourceList : List<NameDTO>)
        fun showErrorView()
    }

    interface Presenter : BasePresenter<View>{
        fun loadData()
        fun searchName(name: String?)
    }

    interface Repository{
        fun fetchNameList(): Observable<List<NameDTO>>
    }

    object Factory{
        fun getPresenter() :Presenter{
            return NamePresenter(NameRepository)
        }
    }
}