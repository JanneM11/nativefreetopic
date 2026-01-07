package com.example.freetopicnativeapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(title: String, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            IconButton(onClick = {expanded = !expanded}) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Open menu",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                 containerColor = Color(0xFF333333)
            ) {
                DropdownMenuItem(
                    text = { Text("Info")},
                    onClick = { navController.navigate("info")}
                )
            }
        }
    )
}