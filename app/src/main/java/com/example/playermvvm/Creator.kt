package com.example.playermvvm

object Creator {
    fun getRepository(): TracksRepository {
        return TracksRepositoryImpl(NetworkClientImpl())
    }

    fun provideTracksInteractor(): TrackInteractor {
        return TracksInteractorImpl(getRepository())
    }
}