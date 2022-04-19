package com.apjake.codetestmovielist.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apjake.codetestmovielist.common.util.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val dispose = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        dispose.clear()
    }
}