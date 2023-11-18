package com.caiorocha.app_praca.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.caiorocha.app_praca.R
import com.caiorocha.app_praca.data.DataResponseMock

@Composable
fun ItemList(items: List<DataResponseMock>) {
    // Composable que exibe a lista de itens usando LazyColumn
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = maxOf(72).dp)
    ) {
        LazyColumn {
            items(items) { item ->
                // Bloco repetido para cada item na lista
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.praca0),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(width = 200.dp, height = 200.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    item.results.forEach { result ->
                        Text(
                            text = "Name: ${result.name}",
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.Black
                        )
                    }
                    item.results.forEach { result ->
                        Text(
                            text = "Email: ${result.url}",
                            modifier = Modifier
                                .padding(8.dp),
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}