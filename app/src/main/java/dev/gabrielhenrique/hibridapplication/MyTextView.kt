package dev.gabrielhenrique.hibridapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyTextView(text: String) {
    Box(Modifier.background(Color.Cyan)) {
        Text(text)
    }
}

@Composable
@Preview
fun MyPreview() {
    MyTextView("My composable text view")
}