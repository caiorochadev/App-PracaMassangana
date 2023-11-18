package com.caiorocha.app_praca.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caiorocha.app_praca.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun MyBottomNavigation() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.background(MaterialTheme.colorScheme.primary),
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                val allFood = painterResource(id = R.drawable.allfood)
                BottomNavigationItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(allFood, contentDescription = "Todos", modifier = Modifier.size(28.dp))
                    },
                    label = { Text("Todos") })
                val saltyFood = painterResource(id = R.drawable.fast_food)
                BottomNavigationItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = {
                        Icon(
                            saltyFood,
                            contentDescription = "Salgados",
                            modifier = Modifier.size(28.dp)
                        )
                    },
                    label = { Text("Salgados") })
                val sweetFood = painterResource(id = R.drawable.ice_cream_cone_svgrepo_com)
                BottomNavigationItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = {
                        Icon(
                            sweetFood, contentDescription = "Doces", modifier = Modifier.size(28.dp)
                        )
                    },
                    label = { Text("Doces") })
            }
        },
        content = {
            // Conteúdo da tela correspondente à guia selecionada
            when (selectedTab) {
                1 -> SaltScreen()
                2 -> AllflavorsScreen()
                3 -> Sweetscreen()
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    MyBottomNavigation()
}