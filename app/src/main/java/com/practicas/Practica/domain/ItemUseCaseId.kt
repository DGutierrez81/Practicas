package com.practicas.Practica.domain

import com.practicas.Practica.Data.Repository
import com.practicas.Practica.ui.states.IteState
import javax.inject.Inject


class ItemUseCaseId@Inject constructor(private val repository: Repository) {
    //Esto funciona con el id
    suspend operator fun invoke(itemNumero: String): IteState {
        return repository.obtenerImagen(itemNumero)
    }
}