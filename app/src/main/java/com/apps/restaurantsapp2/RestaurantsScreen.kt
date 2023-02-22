package com.apps.restaurantsapp2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apps.restaurantsapp2.rickandmorty.RickAndMortyViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RestaurantsScreen(viewModel: RickAndMortyViewModel = viewModel()) {
    LazyVerticalGrid(
        // set number of items in a row
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(viewModel.state.value.size) { index ->
            val character = viewModel.state.value[index]
            RowItem(character) { characterId ->
                // Lógica para manejar la acción del usuario al hacer clic en una fila
            }
        }
    }
}