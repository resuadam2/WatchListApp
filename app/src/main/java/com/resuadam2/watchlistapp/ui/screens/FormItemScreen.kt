package com.resuadam2.watchlistapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.resuadam2.watchlistapp.data.Platforms
import com.resuadam2.watchlistapp.data.WatchingTypes
import com.resuadam2.watchlistapp.ui.components.EnumSpinner
import com.resuadam2.watchlistapp.ui.state.FormState
import com.resuadam2.watchlistapp.ui.state.FormViewModel

@Composable
fun FormItemScreen(
    modifier: Modifier = Modifier,
    formViewModel: FormViewModel = FormViewModel(),
    navigateBack: () -> Boolean
) {
    val formItemUiState by formViewModel.formState.collectAsState()

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            // ESTADO ACTUAL
            Text("Current title: ${formItemUiState.title}")
            Text("Current platform: ${formItemUiState.platform}")
            Text("Current type: ${formItemUiState.type}")
        }
        // Add the form item screen here
       Row (
           modifier = Modifier.padding(16.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           OutlinedTextField(
               value = formItemUiState.title,
               onValueChange = { formViewModel.onTitleChange(it) },
               label = { Text("Title") },
               singleLine = true,
               modifier = Modifier.weight(1f)
           )
       }
       Row (
           modifier = Modifier.padding(16.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ){
            /* TODO : Ni este desplegable ni el siguiente están funcinoando */
           EnumSpinner(
               items = WatchingTypes.entries.toTypedArray(),
               label = "Type",
               selectedItem = formItemUiState.type,
               onItemSelected = { formViewModel.onTypeChange(it) }
           )
       }
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            EnumSpinner(
                items = Platforms.entries.toTypedArray(),
                label = "Platform",
                selectedItem = formItemUiState.platform,
                onItemSelected = { formViewModel.onPlatformChange(it) }
            )
        }
        Row {
            // Add the error message here
        }
        Row {
            // Add the buttons here
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormItemScreenPreview() {
    FormItemScreen(navigateBack = { false })
}