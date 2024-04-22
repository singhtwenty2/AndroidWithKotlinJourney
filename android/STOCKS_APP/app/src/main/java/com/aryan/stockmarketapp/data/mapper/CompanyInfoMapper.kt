package com.aryan.stockmarketapp.data.mapper

import com.aryan.stockmarketapp.data.remote.dto.CompanyInfoDto
import com.aryan.stockmarketapp.domain.model.CompanyInfo

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}