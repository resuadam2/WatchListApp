package com.resuadam2.watchlistapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import com.resuadam2.watchlistapp.data.WatchingTypes

@Composable
fun <T> EnumSpinner(
    modifier: Modifier = Modifier,
    items: Array<T>,
    label: String = "",
    selectedItem: T,
    onItemSelected: (T) -> Unit,
) where T : Enum<T>, T : EnumDisplayable {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        // Visual del selector
        OutlinedTextField(
            value = selectedItem.displayName,
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            readOnly = true,
            label = { Text(label.ifEmpty { "Seleccione una opción" }) }
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

/**
 * Muestra un preview de EnumSpinner
 * TODO No está funcionando el despliegue todavía
 */
@Preview
@Composable
fun EnumSpinnerPreview() {
    val items = WatchingTypes.entries.toTypedArray()
    var selectedItem by remember { mutableStateOf(WatchingTypes.FILM) }

    EnumSpinner(
        items = items,
        label = "Esto es una prueba",
        selectedItem = selectedItem,
        onItemSelected = { selectedItem = it }
    )
}