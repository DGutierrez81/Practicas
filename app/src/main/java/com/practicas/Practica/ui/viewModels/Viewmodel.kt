package com.practicas.Practica.ui.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practicas.Practica.Data.model.Content
import com.practicas.Practica.ui.states.ContentState
import com.practicas.Practica.ui.states.IteState
import com.practicas.Practica.domain.ItemUseCase
import com.practicas.Practica.domain.ItemUseCaseId
import com.practicas.Practica.domain.MediaUseCase
import com.practicas.Practica.ui.states.IdMediaState
import com.practicas.Practica.ui.states.MediaClassState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel@Inject constructor(private val itemUseCase: ItemUseCase, private val itemUseCaseId: ItemUseCaseId,
    private val mediaUseCase: MediaUseCase): ViewModel() {


    //Bueno para utilizar con el id
    private val _item = MutableStateFlow<IteState?>(null)
    val item: StateFlow<IteState?> = _item.asStateFlow()

    //Bueno para utilizar con el id
    var numero by mutableStateOf("")
        private set

    private val _show = mutableStateOf<Boolean>(false)
    val show: MutableState<Boolean> = _show


    private val _media = MutableStateFlow(MediaClassState())
    val media: StateFlow<MediaClassState> = _media.asStateFlow()

    var lista by mutableStateOf<List<IdMediaState>>(emptyList())
    private set

    private val _listItem = MutableStateFlow<List<IteState>>(emptyList())
    val listItem: StateFlow<List<IteState>> = _listItem.asStateFlow()


    private val _mapa = MutableStateFlow<List<HashMap<String, Any?>>>(emptyList())
    val mapa: StateFlow<List<HashMap<String, Any?>>> = _mapa

    fun getItem(){
        viewModelScope.launch {
            //_listItem.value = itemUseCase()
            _mapa.value = itemUseCase()
        }
    }

    fun getMedia(MediaNumber: String){
        viewModelScope.launch {
            _media.value = mediaUseCase(MediaNumber)
        }
    }

    fun objeto(map: Map<String,Any>): Content {
        val type = map["type"] as String
        val property_id = map["property_id"] as String
        val property_label = map["property_label"] as String
        val is_public = map["is_public"] as Boolean
        val value = map["value"] as String
        return Content(type, property_id, property_label,is_public,value)
    }


    /*
    val type: String?,
    val property_id: String?,
    val property_label: String?,
    val is_public: Boolean?,
    @SerializedName("@value") val value: String?
     */


//Esto funciona con el id
    fun getItemIndi(numero: String){
        viewModelScope.launch {
            //_item.value = itemUseCase(numero).thumbnail_display_urls?: mutableListOf()
            _item.value = itemUseCaseId(numero)

        }
    }

    fun addListIdMediaState(list: List<IdMediaState>){
        lista = list
    }

    fun changeNumber(number: String){
        numero = number
    }

    fun changeShow(expanded: Boolean){
        _show.value = expanded
    }
}