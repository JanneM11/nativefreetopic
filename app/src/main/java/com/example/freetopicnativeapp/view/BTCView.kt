package com.example.freetopicnativeapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BTCView(
    title: String,
    btcValue: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = btcValue
        )
    }
}