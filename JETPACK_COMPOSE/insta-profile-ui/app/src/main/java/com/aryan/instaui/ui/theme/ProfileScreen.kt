package com.aryan.instaui.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aryan.instaui.R

@Composable
fun ProfileComposable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0C0F14))
    ) {
        TopAppBarComposable(
            name = "rishi_r__",
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSectionComposable()
    }
}

@Composable
fun TopAppBarComposable(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                start = 10.dp,
                end = 10.dp,
                bottom = 16.dp
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default
            ),
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.bell),
            contentDescription = "Bell",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.dor_menu),
            contentDescription = "Bell",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSectionComposable(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.img),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatsSectionComposable(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatsSectionComposable(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
    ) {
        ProfileStatsComposable(number = "0", text = "posts")
        ProfileStatsComposable(number = "69M", text = "followers")
        ProfileStatsComposable(number = "179", text = "following")
    }
}

@Composable
fun ProfileStatsComposable(
    number: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Text(
            text = number,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            color = Color.White
        )
    }
}