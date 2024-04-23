package com.practicas.Practica.domain

import com.practicas.Practica.Data.Repository
import com.practicas.Practica.ui.states.IteState
import javax.inject.Inject

class ItemUseCase@Inject constructor(private val repository: Repository) {


    /*
    suspend operator fun invoke(): List<IteState> {
        return repository.obetenerItems()
    }

     */

    suspend operator fun invoke(): List<HashMap<String, Any?>> {
        return repository.obtenerItems()
    }








}