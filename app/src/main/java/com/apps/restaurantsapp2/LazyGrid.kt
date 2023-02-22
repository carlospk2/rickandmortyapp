package com.apps.restaurantsapp2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.apps.restaurantsapp2.rickandmorty.datamodel.Character

@Composable
fun RowItem(item: Character, onClick: (restaurant: Restaurant) -> Unit) {

    Column(
        modifier = Modifier
            .size(100.dp)
            .background(MaterialTheme.colors.background)
            .border(1.dp, MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = item.name, color = MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "${item.id}", color = MaterialTheme.colors.primary)

    }
}