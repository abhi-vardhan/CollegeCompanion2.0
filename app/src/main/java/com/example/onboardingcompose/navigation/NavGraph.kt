@file:OptIn(ExperimentalFoundationApi::class)

package com.example.onboardingcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onboardingcompose.screen.*

import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Papers.route) {
            Papers(navController = navController)
        }
        composable(route= Screen.Question1.route) {
            Main1(navController = navController)
        }
        composable(route= Screen.ug1.route) {
            Main2(navController = navController)
        }
        composable(route= Screen.pg1.route) {
            Main3(navController = navController)
        }
        composable(route= Screen.ph1.route) {
            Main4(navController = navController)
        }
    }
}