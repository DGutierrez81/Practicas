package com.practicas.Practica.ui.states

import com.practicas.Practica.ui.states.IteState

data class ListaItemState(
    val lista: List<HashMap<String, Any>>? = emptyList()
)