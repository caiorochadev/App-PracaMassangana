package com.caiorocha.app_praca.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.caiorocha.app_praca.R
import com.caiorocha.app_praca.ui.viewmodel.ListItem
import com.caiorocha.app_praca.ui.viewmodel.MainViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navigateToHomeScreen: () -> Unit) {
    // Inicializa o ViewModel
    val viewModel: MainViewModel = viewModel()
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lanches da Praça",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = { //icone do lado esquerdo topbar

                    IconButton(
                        onClick = {
                            navigateToHomeScreen() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = { //icone do lado direito topbar
                    IconButton(
                        onClick = {
                            // Lógica para a ação do search
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        bottomBar = {
            androidx.compose.material.BottomNavigation(
                modifier = Modifier.background(MaterialTheme.colorScheme.primary),
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                val allFood = painterResource(id = R.drawable.allfood,)
                BottomNavigationItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(allFood, contentDescription = "Todos",modifier = Modifier.size(28.dp))
                    },
                    label = { Text("Todos") }
                )
                val saltyFood = painterResource(id = R.drawable.fast_food)
                BottomNavigationItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(saltyFood, contentDescription = "Salgados",modifier = Modifier.size(28.dp))
                    },
                    label = { Text("Salgados") }
                )
                val sweetFood = painterResource(id = R.drawable.ice_cream_cone_svgrepo_com)
                BottomNavigationItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = {
                        Icon(sweetFood, contentDescription = "Doces",modifier = Modifier.size(28.dp))
                    },
                    label = { Text("Doces") }
                )
            }
        },
        content = {
            // Conteúdo principal
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                // Lista de itens
                ItemList(items = viewModel.listItems)
                Spacer(modifier = Modifier.height(16.dp))
                BottomNavigation()
            }
        }
    )
    /*when (selectedTab) {
        0 -> SalgadosScreen()
        1 -> TodosScreen()
        2 -> DocesScreen()
    }*/
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navigateToHomeScreen = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigation() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            androidx.compose.material.BottomNavigation(
                modifier = Modifier.background(MaterialTheme.colorScheme.primary),
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                BottomNavigationItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(Icons.Default.Add, contentDescription = "Salgados")
                    },
                    label = { Text("Salgados") }
                )

                BottomNavigationItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(Icons.Default.List, contentDescription = "Todos")
                    },
                    label = { Text("Todos") }
                )

                BottomNavigationItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = {
                        Icon(Icons.Default.List, contentDescription = "Doces")
                    },
                    label = { Text("Doces") }
                )
            }
        }
    ) {
        // Conteúdo da tela correspondente à guia selecionada
        when (selectedTab) {
            0 -> SalgadosScreen()
            1 -> TodosScreen()
            2 -> DocesScreen()
        }
    }
}

@Composable
fun SalgadosScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text("Página de Salgados")
    }
}

@Composable
fun TodosScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text("Página de Todos")
    }
}

@Composable
fun DocesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text("Página de Doces")
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    BottomNavigation()
}

@Composable
fun ItemList(items: List<ListItem>) {
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
                            .align(CenterHorizontally)
                    )
                    Text(
                        text = item.content,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Black
                    )
                }
            }
        }
    }
}






