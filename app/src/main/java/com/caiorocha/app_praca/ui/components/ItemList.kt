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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caiorocha.app_praca.R
import com.caiorocha.app_praca.data.repository.ListItemDB

@Composable
fun ItemList(items: List<ListItemDB>) {
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
                    Text(
                        text = "Photo: ${item.urlPhoto}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Text(
                        text = "Nome: ${item.nome}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Text(
                        text = "Tipo: ${item.tipo}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Text(
                        text = "Horario: ${item.horario}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                    Text(
                        text = "Referencia: ${item.referencia}",
                        modifier = Modifier.padding(8.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemList() {
    //ItemList{}
}