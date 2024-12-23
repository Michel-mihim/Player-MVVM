package com.example.playermvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class TrackViewModel(
    private val trackId: String,
    private val tracksInteractor: TracksInteractor
) : ViewModel() {
    init {
        Log.d("wtf", "init!")
    }

    companion object {
        fun getViewModelFactory(trackId: String): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    val application = checkNotNull(extras[APPLICATION_KEY])

                    return TrackViewModel(
                        trackId,
                        (application as MyApplication).provideTracksInteractor()
                    ) as T
                }
            }
    }
}