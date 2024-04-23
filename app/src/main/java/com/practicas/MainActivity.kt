package com.practicas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practicas.Practica.navigation.Routes
import com.practicas.Practica.ui.views.Screen
import com.practicas.Practica.ui.views.Screen2
import com.practicas.Practica.ui.viewModels.Viewmodel
import com.practicas.Practica.ui.views.ScreenMedia
import com.practicas.ui.theme.PracticasTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: Viewmodel by viewModels()
    //private val viewModel: Viewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.principalScreen.routes){
                        composable(Routes.principalScreen.routes){ Screen(navController, viewModel) }
                        composable(Routes.Screen2.routes){ Screen2(navController, viewModel) }
                        composable(Routes.ScreenMedia.routes){ ScreenMedia(
                            navController = navController,
                            viewmodel = viewModel
                        )}
                    }
                }
            }
        }
    }
}
