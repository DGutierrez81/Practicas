package com.practicas.Practica.navigation

sealed class Routes(val routes: String) {
    object principalScreen: Routes("principalScreen")
    object Screen2: Routes("screen2")
    object ScreenMedia: Routes("screenMedia")
}