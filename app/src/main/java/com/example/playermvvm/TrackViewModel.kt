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
        fun getViewModelFactory(trackId: String): ViewModelFactory = viewModelProvider.Factory {
               initializer {
                   val interactor = (this[APPLICATION_KEY] as MyApplication).provideTracksInteractor()

                   TrackViewModel(
                       trackId,
                       interactor
                   )
               }
            }
    }
}