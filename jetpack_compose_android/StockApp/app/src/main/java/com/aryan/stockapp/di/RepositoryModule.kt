package com.aryan.stockapp.di

import com.aryan.stockapp.data.csv.CSVParser
import com.aryan.stockapp.data.csv.CompanyListingParser
import com.aryan.stockapp.data.repository.StockRepositoryImplimentation
import com.aryan.stockapp.domain.model.CompanyListing
import com.aryan.stockapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindsStockRepository(
        stockRepositoryImplimentation: StockRepositoryImplimentation
    ): StockRepository
}