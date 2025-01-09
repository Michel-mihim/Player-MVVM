package com.example.playermvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrackViewModel(
    private val trackId: String,
): ViewModel() {
    init {
        Log.d("wtf", "init!: $trackId")
    }

    companion object {
        fun getViewModelFactory(trackId: String): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                // 1
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TrackViewModel(
                        trackId
                    ) as T
                }
            }
    }
}