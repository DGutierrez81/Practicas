package com.practicas.Practica.Data.model

import com.google.gson.annotations.SerializedName

data class Ite(
    @SerializedName("o:id") val id: String? = null,
    @SerializedName("o:title") val title: String? = null,
    val thumbnail_display_urls: Item? = null,
    @SerializedName("dcterms:abstract") val content: List<Content>? = null,
    @SerializedName("o:media") val media: List<IdMedia>? = null,
    @SerializedName("bibo:annotates") val annotates: List<Content>? = null
    /*
    val id: String? = null,
    val url: String? = null,
    val width: String? = null

     */
)
