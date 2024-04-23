package com.practicas.Practica.ui.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.gson.JsonObject
import com.practicas.Practica.Data.model.Ite
import com.practicas.Practica.Data.model.Item
import com.practicas.Practica.navigation.Routes
import com.practicas.Practica.ui.states.IdMediaState
import com.practicas.Practica.ui.states.IteState
import com.practicas.Practica.ui.states.ItemState
import com.practicas.Practica.ui.viewModels.Viewmodel
import com.practicas.R

@Composable
fun Screen(navController: NavController, viewmodel: Viewmodel) {

    val lista by viewmodel.listItem.collectAsState()
    val show = viewmodel.show.value
    val listaId = viewmodel.lista
    val context = LocalContext.current
    val lista2 by viewmodel.mapa.collectAsState()

    LaunchedEffect(Unit) {
        viewmodel.getItem()
    }

    LazyColumn() {
        itemsIndexed(lista2) { index, item ->

            //val termsTitle = item["dcterms:title"] as? List<Map<String, Any>>


            //Saco la información dependiendo si la clave contiene una determinada determinada
            for (mapa in lista2) {
                if (mapa.keys.any { it.contains("dcterms") }) {
                    // El mapa contiene la clase "dcterms"
                    for ((key, value) in mapa) {
                        Text(text = key)
                        if (value is List<*>) {
                            // Si el valor es una lista de mapas
                            for (submapa in value) {
                                if (submapa is Map<*, *>) {
                                    // Si el submapa es un mapa
                                    for ((subkey, subvalue) in submapa) {
                                        // Imprimir las claves y valores
                                        Text(text = "Clave $subkey, Valor $subvalue")
                                    }
                                }
                            }
                        }
                    }
                } else {
                    // El mapa no contiene la clase "dcterms"
                    Text(text = "No hay información de 'dcterms'")
                }
            }

            /*
            //Saco la información de o:media

            val id = item["o:id"] as? Double ?: 0.0
            val title = item["o:title"] as? String ?: "no hay title"
            val thumbnailDisplayUrls = item["thumbnail_display_urls"] as? Map<*, *>
            val media = item["o:media"] as? List<Map<String, Any>>
            val largeImageUrl = thumbnailDisplayUrls?.get("large")
            val itemObject = Ite(id.toString(),title)

            if(media != null){
                for(todo in media){
                    for((key,value) in todo){
                        //Text(text = "Clave: $key, Valor: $value")
                        if(key == "o:id"){
                            Text(text = value.toString(), modifier = Modifier.clickable {
                                viewmodel.getMedia(value.toString())
                                navController.navigate(Routes.ScreenMedia.routes)
                            })
                        }
                    }

                }
            }else {
                Text(text = "Esto es null")
            }

             */



            /*
            // Puedo sacar la información de las fotos sin conocer el nombre del valor
            if (thumbnailDisplayUrls != null) {
                for ((key, value) in thumbnailDisplayUrls) {
                    // Accede a cada par clave-valor dentro del mapa
                    val keyValue = "$key: $value"
                    // Haz lo que necesites con cada par clave-valor, por ejemplo, imprimirlo
                    Text(text = keyValue)

                    Image(painter = rememberImagePainter(value?: R.drawable.gatitio),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(8.dp)))
                }
            }

             */

            /*


            // De esta manera saco la informarción obteniendola directamente utilizando el nombre del valor
            val id = item["o:id"] as? Double ?: 0.0
            val title = item["o:title"] as? String ?: "no hay title"
            val thumbnailDisplayUrls = item["thumbnail_display_urls"] as? Map<*, *>
            val largeImageUrl = thumbnailDisplayUrls?.get("large")
            val itemObject = Ite(id.toString(),title)

            Text(text = itemObject.id ?: "")
            Text(text = itemObject.title ?: "")
            Image(painter = rememberImagePainter(largeImageUrl?: R.drawable.gatitio),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp)))

             */

            /*
                    Column {
                Column {
                    for (i in lista2) {
                        for ((k, v) in i) {
                            Text(text = "CLAVE $k: VALOR ${v.toString()}")
                        }
                    }
                }

                _____________________________________

                for( valor in item){
                    Text(text= valor.toString())
                }

             */
        }
    }
}


/*
    Row(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.width(200.dp)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(lista) { index, item ->
                    Column {
                        Text(text = item.id ?: "vacio")
                        Text(text = item.title ?: "vacio")
                        Image(
                            painter = rememberImagePainter(
                                item.thumbnail_display_urls?.large ?: R.drawable.gatitio
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(8.dp)) // redondear las esquinas
                                .clickable {
                                    viewmodel.getItemIndi(item.id ?: "vacio")
                                    navController.navigate(Routes.Screen2.routes)
                                }
                        )
                        Button(onClick = {
                            viewmodel.changeShow(true)
                            viewmodel.addListIdMediaState(item.media ?: emptyList())
                        }
                        ) {
                            Text(text = "IdMedia")
                        }
                    }

                }
            }
        }

        Column(modifier = Modifier.width(100.dp)) {
            Button(
                onClick = {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse( "https://patrimoniodigital.ucm.es/")
                        )
                    )
                }, // DCS - Inicia la actividad del navegador.
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Gray
                )
            ) {
                Text(text = "Sitio Web")
            }
            DropdownMenu(
                expanded = show, onDismissRequest = { viewmodel.changeShow(false) },
                modifier = Modifier.width(100.dp)
            ) {
                listaId.forEach { id ->
                    DropdownMenuItem(
                        text = { Text(text = id.idMedia ?: "vacio") },
                        onClick = {
                            viewmodel.getMedia(id.idMedia?: "vacio")
                            navController.navigate(Routes.ScreenMedia.routes)
                        })
                }
            }
        }
    }

     */









