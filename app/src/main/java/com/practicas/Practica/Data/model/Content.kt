package com.practicas.Practica.Data.model

import com.google.gson.annotations.SerializedName

data class Content(
    val type: String? = null,
    val property_id: String? = null,
    val property_label: String? = null,
    val is_public: Boolean? = null,
    @SerializedName("@value") val value: String? = null
)

