package com.practicas.Practica.Data

import com.practicas.Practica.Data.model.IdMedia
import com.practicas.Practica.Data.util.Constans.Companion.ENDPOINT
import com.practicas.Practica.Data.util.Constans.Companion.MEDIA
import com.practicas.Practica.Data.model.Ite
import com.practicas.Practica.Data.model.MediaClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemInterface {

    @GET(ENDPOINT)
    //suspend fun obtenerItems(): Response<List<Ite>>
    suspend fun obtenerItems(): Response<List<HashMap<String, Any?>>>

/*
    @GET(ENDPOINT)
    suspend fun obtenerItems(@Query("limit") limit:Int = 10): Response<List<Ite>>

 */

    @GET("$MEDIA/{MediaNumber}")
    suspend fun obtenerMedia(@Path("MediaNumber") MediaNumber: String): Response<MediaClass>



    //Esto funciona con el id
    @GET("$ENDPOINT/{ItemNumber}") // Cambiar la ruta según corresponda
    suspend fun obtenerImagen(@Path("ItemNumber") ItemNumber: String): Response<Ite>




}