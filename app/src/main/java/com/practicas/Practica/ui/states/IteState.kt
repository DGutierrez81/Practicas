package com.practicas.Practica.ui.states

import com.google.gson.annotations.SerializedName
import com.practicas.Practica.Data.model.Content
import com.practicas.Practica.ui.states.ContentState
import com.practicas.Practica.ui.states.ItemState

data class IteState(
    //val thumbnail_display_urls: List<ItemState>? = emptyList()

    val id: String? = "",
    val title: String? = "",
    val thumbnail_display_urls: ItemState? = null,
    val content: List<ContentState>? = null,
    val media: List<IdMediaState>? = null,
    val annotates: List<ContentState>? = null
)
