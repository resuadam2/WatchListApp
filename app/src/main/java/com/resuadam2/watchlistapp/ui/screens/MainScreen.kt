package com.resuadam2.watchlistapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold (
        topBar = {
            TopAppBar(title = {
                Text("Watchlist")
            }, actions = {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Account")
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.MoreVert, contentDescription = "Options")
                }
            },
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) },
        floatingActionButton = { /* TODO */ }
    ) { innerPadding ->
        // Content of the screen
        BodyContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(10) {
            WatchListItem(modifier = modifier.fillMaxSize())
        }
    }
}

@Composable
fun WatchListItem(modifier: Modifier = Modifier, title: String = "Title", platform: String = "Platform", watchingType: String = "Type") {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = platformColor(platform))
            .padding(16.dp)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.size(32.dp))
            IconButton(
                modifier = Modifier.size(16.dp),
                onClick = { /* TODO */ }
            ) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Edit")
            }
        }
        Row (
            modifier = Modifier.padding(top = 8.dp).fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = watchingType, style = MaterialTheme.typography.labelSmall)
                Text(text = platform, style = MaterialTheme.typography.labelSmall)
            }
            Spacer(modifier = Modifier.size(32.dp))
            Row {
                IconButton(
                    onClick = { /* TODO */ }
                ) {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit")
                }
                IconButton(
                    onClick = { /* TODO */ }
                ) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

fun platformColor(platform: String): Color {
    return when (platform) {
        "NETFLIX" -> Color.Red
        "MAX" -> Color.Blue
        "PRIME" -> Color.Green
        "DISNEY" -> Color.Yellow
        else -> Color.Gray
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}