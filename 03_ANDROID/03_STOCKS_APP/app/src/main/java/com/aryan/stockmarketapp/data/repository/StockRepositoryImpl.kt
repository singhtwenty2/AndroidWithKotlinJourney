package com.aryan.stockmarketapp.data.repository

import com.aryan.stockmarketapp.data.csv.CSVParser
import com.aryan.stockmarketapp.data.local.StockDatabase
import com.aryan.stockmarketapp.data.mapper.toCompanyInfo
import com.aryan.stockmarketapp.data.mapper.toCompanyListing
import com.aryan.stockmarketapp.data.mapper.toCompanyListingEntity
import com.aryan.stockmarketapp.data.remote.dto.StockApi
import com.aryan.stockmarketapp.domain.model.CompanyInfo
import com.aryan.stockmarketapp.domain.model.CompanyListing
import com.aryan.stockmarketapp.domain.model.IntraDayInfo
import com.aryan.stockmarketapp.domain.repository.StockRepository
import com.aryan.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    private val db: StockDatabase,
    private val companyListingParser: CSVParser<CompanyListing>,
    private val interadayInfo: CSVParser<IntraDayInfo>
): StockRepository {
    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListings(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if(shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                val response = api.getListings()
                companyListingParser.parse(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data due to IOException"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data due to HttpException"))
                null
            }
            remoteListings?.let {listings ->
                dao.clearCompanyListings()
                dao.insertCompanyListings(
                    listings.map { it.toCompanyListingEntity() }
                )
                emit(Resource.Success(
                    data = dao
                        .searchCompanyListings("")
                        .map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getIntradayInfo(symbol: String): Resource<List<IntraDayInfo>> {
        return try {
            val response = api.getIntradayInfo(symbol)
            val results = interadayInfo.parse(response.byteStream())
            Resource.Success(results)
        }catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load data due to IO Exception"
            )
        }catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load data due to HTTP Exception"
            )
        }
    }

    override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
        return try {
            val result = api.getCompanyInfo(symbol)
            Resource.Success(result.toCompanyInfo())
        }catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load data due to IO Exception"
            )
        }catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load data due to HTTP Exception"
            )
        }
    }
}