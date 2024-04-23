package com.practicas.Practica.domain

import com.practicas.Practica.Data.Repository
import com.practicas.Practica.ui.states.MediaClassState
import javax.inject.Inject

class MediaUseCase@Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(MediaNumber: String): MediaClassState{
        return repository.obtenerMedia(MediaNumber)
    }
}