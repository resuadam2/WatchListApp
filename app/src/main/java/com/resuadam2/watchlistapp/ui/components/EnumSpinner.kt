package com.resuadam2.watchlistapp.ui.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.resuadam2.watchlistapp.data.WatchingTypes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> EnumSpinner(
    modifier: Modifier = Modifier,
    items: Array<T>,
    label: String = "",
    selectedItem: T,
    onItemSelected: (T) -> Unit,
) where T : Enum<T>, T : EnumDisplayable {
    var expandedState by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox (
        expanded = expandedState,
        onExpandedChange = {
            expandedState = !expandedState
        }
    ) {
        // Visual del selector
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().menuAnchor(),
            value = selectedItem.displayName,
            onValueChange = {},
            readOnly = true,
            label = { Text(label.ifEmpty { "Seleccione una opción" }) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState)}
        )

        // Menú desplegable
        ExposedDropdownMenu (
            modifier = Modifier.fillMaxWidth(),
            expanded = expandedState,
            onDismissRequest = { expandedState = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item.displayName) },
                    onClick = {
                        onItemSelected(item)
                        expandedState = false
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
