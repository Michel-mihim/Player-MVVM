package com.example.playermvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TrackActivity : ComponentActivity() {

    private lateinit var viewModel: TrackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_track)

        viewModel = ViewModelProvider(this, TrackViewModel.getViewModelFactory("123"))[TrackViewModel::class.java]

        viewModel.getLoadingLiveData().observe(this) { isLoading ->
            changeProgressBarVisibility(isLoading)
        }

    }

    private fun changeProgressBarVisibility(visible: Boolean) {}
}