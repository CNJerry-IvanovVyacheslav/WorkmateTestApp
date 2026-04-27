package com.melongamesinc.workmatetestapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "character_list") {
                        composable("character_list") {
                            CharacterListScreen(
                                onNavigateToDetail = { characterId ->
                                    navController.navigate("character_detail/$characterId")
                                }
                            )
                        }
                        composable("character_detail/{characterId}") { backStackEntry ->
                            val characterId = backStackEntry.arguments?.getString("characterId")

                            if (characterId != null) {
                                CharacterDetailScreen(
                                    characterId = characterId,
                                    onNavigateBack = { navController.popBackStack() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}