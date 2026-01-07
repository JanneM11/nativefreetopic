package com.example.freetopicnativeapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.freetopicnativeapp.ui.components.ScreenTopBar

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Info", navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(16.dp)
        ) {
            Text("Tämä sovellus hakee bitcoinin hinnan API:sta ja näyttää sen ruudulla", modifier = Modifier.padding(innerPadding))
        }

    }
}