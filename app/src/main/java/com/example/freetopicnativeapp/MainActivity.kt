package com.example.freetopicnativeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.freetopicnativeapp.ui.screens.AppScreen
import com.example.freetopicnativeapp.ui.theme.FreeTopicNativeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreeTopicNativeAppTheme {
                    AppScreen()
                }
            }
        }
    }


