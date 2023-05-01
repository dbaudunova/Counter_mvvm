package com.geektech.counter_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private var count = 0
    var countLiveData = MutableLiveData<Int>()

    fun getReset() {
        count = 0
        countLiveData.value = count
    }

    fun getPlusCount() {
        count++
        countLiveData.value = count
    }

    fun getMinusCount() {
        count--
        countLiveData.value = count
    }
}