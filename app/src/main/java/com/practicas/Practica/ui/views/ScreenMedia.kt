package com.practicas.Practica.ui.views

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.practicas.Practica.ui.states.MediaClassState
import com.practicas.Practica.ui.viewModels.Viewmodel
import com.practicas.R

@Composable
fun ScreenMedia(navController: NavController, viewmodel: Viewmodel) {
    val vista: MediaClassState by viewmodel.media.collectAsState()

    Image(
        painter = rememberImagePainter(vista.thumbnail_display_urls?.large ?: R.drawable.gatitio),
        contentDescription = "Imagen"
    )
}