package com.nbscvincent.csc4222024midterm.screens


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun DialogAlert(
    showDialog: Boolean,
    onDismiss: () -> Unit
){
    if (showDialog){
        AlertDialog(
            onDismissRequest = { onDismiss },
            confirmButton = {
                TextButton(onClick = onDismiss ) {
                    Text("OK")
                }
            },
            text = {
                Text(text = "Invalid Credentials")

            },
        )
    }
}