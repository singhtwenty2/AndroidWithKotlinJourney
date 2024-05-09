package com.aryan.stockmarketapp.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.aryan.stockmarketapp.data.remote.dto.InteradayInfoDto
import com.aryan.stockmarketapp.domain.model.IntraDayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun InteradayInfoDto.toIntradayInfo(): IntraDayInfo {
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    return IntraDayInfo(
        date = localDateTime,
        close = close
    )
}