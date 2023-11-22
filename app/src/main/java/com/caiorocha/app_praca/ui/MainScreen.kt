package com.caiorocha.app_praca.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.caiorocha.app_praca.R
import com.caiorocha.app_praca.ui.components.ItemList
import com.caiorocha.app_praca.ui.viewmodel.MainViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navigateToHomeScreen: () -> Unit) {
    val viewModel: MainViewModel = viewModel()
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Lanches da Praça",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }, navigationIcon = { //icone do lado esquerdo topbar

            IconButton(onClick = {
                navigateToHomeScreen()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, contentDescription = "Back"
                )
            }
        }, actions = { //icone do lado direito topbar
            IconButton(onClick = {
                // Lógica para a ação do search
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Black
                )
            }
        })
    }, bottomBar = {
        androidx.compose.material.BottomNavigation(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
            backgroundColor = MaterialTheme.colorScheme.primary

        ) {
            val allFood = painterResource(id = R.drawable.allfood)
            BottomNavigationItem(selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                icon = {
                    Icon(allFood, contentDescription = "Todos", modifier = Modifier.size(28.dp),

                        Color.White)
                },
                label = {
                    Text(
                        text = "Todos",
                        color = Color.White
                    )
                })
            val saltyFood = painterResource(id = R.drawable.fast_food)
            BottomNavigationItem(selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                icon = {
                    Icon(
                        saltyFood,
                        contentDescription = "Salgados",
                        modifier = Modifier.size(28.dp),
                        Color.White
                    )
                },
                label = {
                    Text(
                        text = "Salgados",
                        color = Color.White // Defina a cor branca aqui
                    )
                })
            val sweetFood = painterResource(id = R.drawable.ice_cream_cone_svgrepo_com)
            BottomNavigationItem(selected = selectedTab == 2,
                onClick = { selectedTab = 2 },
                icon = {
                    Icon(
                        sweetFood, contentDescription = "Doces", modifier = Modifier.size(28.dp),
                        Color.White
                    )
                },
                label = {
                    Text(
                        text = "Doces",
                        color = Color.White)
                })
        }
    }, content = {
        // Conteúdo principal
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Lista de itens
            ItemList(items = viewModel.listItemDBS)
            Spacer(modifier = Modifier.height(16.dp))
        }
    })
//    when (selectedTab) {
//        0 -> SaltScreen()
//        1 -> AllflavorsScreen()
//        2 -> Sweetscreen()
//    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen {}
}

