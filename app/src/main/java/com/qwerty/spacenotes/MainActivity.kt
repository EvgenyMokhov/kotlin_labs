package com.qwerty.spacenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.qwerty.spacenotes.ui.screens.NotesApp
import com.qwerty.spacenotes.ui.theme.SpaceNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceNotesTheme {
                NotesApp()
            }
        }
    }
}
