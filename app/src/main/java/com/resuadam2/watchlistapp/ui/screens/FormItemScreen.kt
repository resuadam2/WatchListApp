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

@Composable
fun FormItemScreen(modifier: Modifier = Modifier, navigateBack: () -> Boolean) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Add the form item screen here
       Row (
           modifier = Modifier.padding(16.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           Text(
               "Title: ",
               modifier = Modifier.padding(end = 16.dp),
                style = MaterialTheme.typography.titleMedium
               )
           OutlinedTextField(value = "", onValueChange = { /*TODO*/ })
       }
       Row (
           modifier = Modifier.padding(16.dp),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.SpaceBetween
       ){
           var selectedWatchingType by remember { mutableStateOf(WatchingTypes.SERIES) }
            /* TODO : Ni este desplegable ni el siguiente están funcinoando */
           EnumSpinner(
               items = WatchingTypes.entries.toTypedArray(),
               selectedItem = selectedWatchingType,
               onItemSelected = { selectedWatchingType = it }
           )
       }
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            var selectedPlatform by remember { mutableStateOf(Platforms.OTHERS) }

            EnumSpinner(
                items = Platforms.entries.toTypedArray(),
                selectedItem = selectedPlatform,
                onItemSelected = { selectedPlatform = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormItemScreenPreview() {
    FormItemScreen(navigateBack = { false })
}