package com.example.playermvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class TrackViewModel(
    private val trackId: String,
): ViewModel() {
    init {
        Log.d("wtf", "init!: $trackId")
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