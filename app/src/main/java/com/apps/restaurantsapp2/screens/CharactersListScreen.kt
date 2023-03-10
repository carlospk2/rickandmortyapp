package com.apps.restaurantsapp2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apps.restaurantsapp2.rickandmorty.api.RickAndMortyViewModel
import com.apps.restaurantsapp2.ui.theme.Background

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantsScreen(viewModel: RickAndMortyViewModel = viewModel()) {

    val currentPage = viewModel.currentPage
    val maxPages = viewModel.maxPages

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(
            // set number of items in a row
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier.fillMaxHeight(0.95f).background(Background)
        ) {
            items(viewModel.state.value.size) { index ->
                val character = viewModel.state.value[index]
                RowItem(character) { characterId ->
                    // Lógica para manejar la acción del usuario al hacer clic en una fila
                }
            }
        }
        Row(
            Modifier.fillMaxWidth().fillMaxHeight(0.95f).background(Background),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = {
                viewModel.loadPreviousPage()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Previous page",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Página ${currentPage.value} de ${maxPages.value}", color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = {
                viewModel.loadNextPage()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next page",
                    tint = Color.White
                )
            }
        }
    }
}