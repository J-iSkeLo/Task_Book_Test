package com.books.app.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.books.app.ui.theme.HintColor

@Composable
fun Line() {
    Spacer(modifier = Modifier.height(16.dp))
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(HintColor)
    )
    Spacer(modifier = Modifier.height(16.dp))
}