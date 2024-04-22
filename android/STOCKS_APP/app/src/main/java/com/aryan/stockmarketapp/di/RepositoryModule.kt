package com.aryan.stockmarketapp.di

import com.aryan.stockmarketapp.data.csv.CSVParser
import com.aryan.stockmarketapp.data.csv.CompanyListingParser
import com.aryan.stockmarketapp.data.csv.InteradayInfoParser
import com.aryan.stockmarketapp.data.repository.StockRepositoryImpl
import com.aryan.stockmarketapp.domain.model.CompanyListing
import com.aryan.stockmarketapp.domain.model.IntraDayInfo
import com.aryan.stockmarketapp.domain.repository.StockRepository
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
    abstract fun bindIntradayInfoParser(
        interadayInfoParser: InteradayInfoParser
    ): CSVParser<IntraDayInfo>

    @Binds
    @Singleton
    abstract fun bindsStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}