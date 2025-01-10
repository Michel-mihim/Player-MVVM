package com.example.playermvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class TrackViewModel(
    private val trackId: String,
): ViewModel() {
    private var loadingObserver: ((Boolean) -> Unit)? = null

    private var loadingLiveData = MutableLiveData(true)


    fun getLoadingLiveData(): LiveData<Boolean> = loadingLiveData


    companion object {
        fun getViewModelFactory(trackId: String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                TrackViewModel(
                    trackId
                )
            }
        }
    }
}