package com.practicas.Practica.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.practicas.Practica.navigation.Routes
import com.practicas.Practica.ui.viewModels.Viewmodel
import com.practicas.R


@Composable
fun Screen2(navController: NavController, viewmodel: Viewmodel) {
    val item by viewmodel.item.collectAsState()

    LazyColumn {
        item{
            Button(
                onClick = { navController.navigate(Routes.principalScreen.routes) }) {
                Text(text = "Volver")
            }
            Text(text = item?.id?: "vacio")
            Text(text = item?.title?: "vacio")
            Image(
                painter = rememberImagePainter(
                    item?.thumbnail_display_urls?.medium ?: R.drawable.gatitio
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp)) // redondear las esquinas
            )
            for (value in item?.content?: emptyList()){
                Text(text = value.value?: "vacio")
            }
            for (value in item?.annotates?: emptyList()){
                Text(text = value.value?: "vacio")
            }
        }

        /*
        LazyColumn(){
            itemsIndexed(item?.content?: emptyList()){
                    index,item -> Text(text = item.value?: "vacio")

            }
        }

         */
    }

    /*
    Column {
        Button(
            onClick = { navController.navigate(Routes.principalScreen.routes) }) {
            Text(text = "Volver")
        }
        Text(text = item?.id?: "vacio")
        Text(text = item?.title?: "vacio")
        Image(
            painter = rememberImagePainter(item?.thumbnail_display_urls?.large ?: R.drawable.gatitio),
            contentDescription = null
        )
        for (value in item?.content?: emptyList()){
            Text(text = value.value?: "vacio")
        }
    }

     */

    /*
    IconButton(onClick = {  }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = Color.White
        )
    }

     */

}