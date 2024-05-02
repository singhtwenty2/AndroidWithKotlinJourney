package com.aryan.stockmarketapp.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aryan.stockmarketapp.presentation.company_info.CompanyInfoScreenComposable
import com.aryan.stockmarketapp.presentation.company_listings.CompanyListingScreenComposable

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigationComposable(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationRoute.CompanyListings.route
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(NavigationRoute.CompanyListings.route) {
            CompanyListingScreenComposable(navController = navController)
        }
        composable(
            route = NavigationRoute.CompanyInfo.route + "/{symbol}",
            arguments = listOf(
                navArgument("symbol") {
                    type = NavType.StringType
                }
            )
        ) {entry ->
            entry.arguments?.getString("symbol")?.let {
                CompanyInfoScreenComposable(
                    navController = navController,
                    symbol = it
                )
            }
        }
    }
}