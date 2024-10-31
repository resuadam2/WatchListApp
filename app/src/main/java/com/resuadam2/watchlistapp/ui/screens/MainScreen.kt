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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.resuadam2.watchlistapp.data.Platforms
import com.resuadam2.watchlistapp.data.Watching
import com.resuadam2.watchlistapp.data.WatchingTypes
import com.resuadam2.watchlistapp.data.getPlatformColor
import com.resuadam2.watchlistapp.ui.state.WatchingListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(watchingListViewModel: WatchingListViewModel = WatchingListViewModel()) {
    val watchingUiState by watchingListViewModel.watchingListState.collectAsState()

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
    ) {
        // Content of the screen
        BodyContent(modifier = Modifier.padding(it), watchinSet = watchingUiState.watchingItems, watchingListViewModel = watchingListViewModel)
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier, watchinSet: Set<Watching>, watchingListViewModel: WatchingListViewModel) {
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(watchinSet.size) {
            WatchListItem(
                title = watchinSet.elementAt(it).title,
                platform = watchinSet.elementAt(it).platform,
                watchingType = watchinSet.elementAt(it).watchingType,
                deleteItem = {
                    watchingListViewModel.deleteWatching(watchinSet.elementAt(it))
                }
            )
        }
    }
}

@Composable
fun WatchListItem(
    modifier: Modifier = Modifier,
    title: String = "Title",
    platform: Platforms = Platforms.OTHERS,
    watchingType: WatchingTypes = WatchingTypes.SERIES,
    deleteItem: () -> Unit
) {
    val showAlertDeleteMessage = remember { mutableStateOf(false) }

    if (showAlertDeleteMessage.value) {
        DeleteDialog(
            title = "Deleting $title",
            onConfirm = deleteItem,
            showDeleteDialog = showAlertDeleteMessage
        )
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = getPlatformColor(platform))
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
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = watchingType.toString(), style = MaterialTheme.typography.labelSmall)
                Text(text = platform.toString(), style = MaterialTheme.typography.labelSmall)
            }
            Spacer(modifier = Modifier.size(32.dp))
            Row {
                IconButton(
                    onClick = { /* TODO */ }
                ) {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit")
                }
                IconButton(
                    onClick = {
                        showAlertDeleteMessage.value = true
                    }
                ) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun DeleteDialog(
    title: String = "Delete",
    message: String = "Are you sure you want to delete this item?",
    onConfirm: () -> Unit,
    showDeleteDialog: MutableState<Boolean>,
) {

    AlertDialog(
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            Button(onClick = {
                onConfirm()
                showDeleteDialog.value = false
            }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = {
                showDeleteDialog.value = false
            }) {
                Text("Dismiss")
            }
        },
        onDismissRequest = {
             showDeleteDialog.value = false
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}