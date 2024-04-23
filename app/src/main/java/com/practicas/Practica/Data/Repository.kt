package com.practicas.Practica.Data

import com.practicas.Practica.Data.model.Content
import com.practicas.Practica.Data.model.IdMedia
import com.practicas.Practica.Data.model.Ite
import com.practicas.Practica.Data.model.Item
import com.practicas.Practica.Data.model.ListaItem
import com.practicas.Practica.Data.model.MediaClass
import com.practicas.Practica.ui.states.ContentState
import com.practicas.Practica.ui.states.IdMediaState
import com.practicas.Practica.ui.states.IteState
import com.practicas.Practica.ui.states.ItemState
import com.practicas.Practica.ui.states.ListaItemState
import com.practicas.Practica.ui.states.MediaClassState
import javax.inject.Inject

class Repository @Inject constructor(private val api: ItemInterface) {



    suspend fun obtenerItems():List<HashMap<String, Any?>>{
        val response = api.obtenerItems()
        return response.body() ?: emptyList()
        }


/*
    suspend fun obetenerItems(): List<IteState>{
        val response = api.obtenerItems()

        return if(response.isSuccessful){
            response.body()?.obtenerLista()?: listOf(IteState())
           // response.body()?.obtenerLista() ?: listOf(Ite())
        }
        else {
            listOf(IteState())
        }
    }

     */


    suspend fun obtenerMedia(MediaNumber: String): MediaClassState {
        val response = api.obtenerMedia(MediaNumber)
        return if(response.isSuccessful){
            response.body()?.obtenerMedia() ?: MediaClassState()
        }else{
            MediaClassState()
        }
    }



    suspend fun obtenerImagen(ItemNumber: String): IteState {
        val response = api.obtenerImagen(ItemNumber)
        return if (response.isSuccessful) {
            response.body()?.obtenerIteState() ?: IteState()
        } else {
            IteState()
        }
    }

    fun ListaItem.obtenerListaItem(): ListaItemState{
        return ListaItemState(
            lista = this.lista
        )
    }

    fun MediaClass.obtenerMedia():MediaClassState{
        return MediaClassState(
            thumbnail_display_urls = this.thumbnail_display_urls?.getItemState()
        )
    }




    fun List<Ite>.obtenerLista(): List<IteState> {
        return this.map { it.obtenerIteState() }
    }


    private fun Ite.obtenerIteState(): IteState {
        return IteState(
            id = this.id,
            title = this.title,
            thumbnail_display_urls = this.thumbnail_display_urls?.getItemState(),
            content = this.content?.map{it.getContent()},
            media = this.media?.map{it.getIdMedia()},
            annotates = this.annotates?.map{it.getContent()}
        )
    }



    private fun Item.getItemState(): ItemState {
        return ItemState(
            large = this.large,
            medium = this.medium,
            square = this.square
        )
    }

    private fun Content.getContent(): ContentState {
        return ContentState(
            type = this.type,
            property_id = this.property_id,
            property_label = this.property_label,
            is_public = this.is_public,
            value = this. value
        )
    }

    private fun IdMedia.getIdMedia(): IdMediaState {
        return IdMediaState(
            idMedia = this.idMedia
        )
    }




    /*
    //Esto funciona con el id
    suspend fun obtenerImagen(ItemNumber: String): IteState {
        val response = api.obtenerImagen(ItemNumber)
        return if (response.isSuccessful) {
            response.body()?.getIteState() ?: IteState()
        } else {
            IteState()
        }
    }

    private fun Ite.getIteState(): IteState {
        return IteState(
            //thumbnail_display_urls = this.thumbnail_display_urls?.map { it.getItemState() }
            id = this.id,
            title = this.title,
            thumbnail_display_urls = this.thumbnail_display_urls?.getItemState()
        )
    }

    private fun Item.getItemState(): ItemState{
        return ItemState(
            large = this.large,
            medium = this.medium,
            square = this.square
        )
    }

     */



}


