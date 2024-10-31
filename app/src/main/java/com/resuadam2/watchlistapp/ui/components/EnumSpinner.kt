package com.resuadam2.watchlistapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun <T> EnumSpinner(
    items: Array<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    modifier: Modifier = Modifier
) where T : Enum<T>, T : EnumDisplayable {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        // Visual del selector
        OutlinedTextField(
            value = selectedItem.displayName,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            readOnly = true,
            label = { Text("Seleccione una opción") }
        )

        // Menú desplegable
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item.displayName) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

// Interfaz que garantiza que el enum tiene una propiedad displayName
interface EnumDisplayable {
    val displayName: String
}
