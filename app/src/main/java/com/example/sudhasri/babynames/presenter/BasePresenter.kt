package com.example.sudhasri.babynames.presenter

interface BasePresenter<in T>{
    fun onCreateView(view : T)
    fun onDestroyView()
}