package com.example.sudhasri.babynames.presenter

import android.text.TextUtils
import android.util.Log
import com.example.sudhasri.babynames.contract.NameScreenContract
import com.example.sudhasri.babynames.model.NameDTO
import io.reactivex.disposables.Disposable

class NamePresenter(private val nameRepository : NameScreenContract.Repository)
    : NameScreenContract.Presenter{

    var nameListView : NameScreenContract.View? = null
    var disposable : Disposable? = null
    var nameList : List<NameDTO> = emptyList()

    override fun onCreateView(view : NameScreenContract.View){
        this.nameListView = view
    }

    override fun loadData() {
        disposable = nameRepository.fetchNameList()
                .doOnSubscribe{nameListView?.showLoader()}
                .subscribe({ nameList ->
                    this.nameList = nameList
                    nameListView?.showDataInView(nameList)
                }, { throwable ->
                    Log.e("Presenter", throwable.message, throwable)
                   nameListView?.showErrorView()
                })
    }

    override fun searchName(name: String?) {
        val filteredNameList =  if (!TextUtils.isEmpty(name)){
            nameList.filter{ nameDTO ->  nameDTO.name.contains(name!!, true) }
        } else nameList
        nameListView?.showDataInView(filteredNameList)
    }

    override fun onDestroyView(){
        disposable?.dispose()
        nameListView = null
    }
}
