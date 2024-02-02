package com.aryan.stockapp.domain.repository

import com.aryan.stockapp.domain.model.CompanyListing
import com.aryan.stockapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}