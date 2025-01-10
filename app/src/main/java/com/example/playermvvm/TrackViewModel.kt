package com.example.playermvvm

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class TrackViewModel(
    private val trackId: String,
): ViewModel() {
    private var loadingObserver: ((Boolean) -> Unit)? = null

    var isLoading: Boolean = true
        private set(value) {
            field = value
            loadingObserver?.invoke(value)
        }

    fun addLoadingObserver(loadingObserver: ((Boolean) -> Unit)) {
        this.loadingObserver = loadingObserver
    }

    fun removeLoadingObserver() {
        this.loadingObserver = null
    }

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