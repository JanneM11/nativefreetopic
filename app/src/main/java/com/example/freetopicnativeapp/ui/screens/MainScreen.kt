package com.example.freetopicnativeapp.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.freetopicnativeapp.ui.components.MainTopAppBar
import com.example.freetopicnativeapp.ui.theme.Gold
import com.example.freetopicnativeapp.view.BTCView
import com.example.freetopicnativeapp.viewmodel.BTCState
import com.example.freetopicnativeapp.viewmodel.BTCViewModel


@Composable
fun MainScreen(navController: NavController, viewModel: BTCViewModel = viewModel()
) {
    Scaffold(
        topBar = { MainTopAppBar("Bitcoin App", navController) },
    ) {padding->
        val state by viewModel.state.collectAsState()
        val title by viewModel.title.collectAsState()
        Box( modifier = Modifier.padding(padding).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is BTCState.Success -> {
                    val btc = (state as BTCState.Success).btc
                    BTCView(
                        title = title,
                        btcValue = btc.priceUsd + " $"
                    )
                }

                is BTCState.Error -> {
                    val msg = (state as BTCState.Error).message
                    Text(text = "Virhe: $msg", color = Color.Red)
                }

                is BTCState.Loading -> {
                        Text("Ladataan...", color = Gold)
                }
            }

        }
    }
}
