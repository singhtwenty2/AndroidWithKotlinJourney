package com.aryan.stockmarketapp.presentation.navigation

sealed class NavigationRoute(val route: String) {
    data object CompanyListings: NavigationRoute(Screen.COMPANYLISTINGS.name)
    data object CompanyInfo: NavigationRoute(Screen.COMPANYINFO.name)
}