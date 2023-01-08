package com.tbse.ui.user_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tbse.domain.models.UsersDomain

@Composable
fun UserListScreen(
    users: UsersDomain,
) {
    LazyColumn(
        modifier = Modifier
            .background(
                color = Color.LightGray,
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    text = "All Users",
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                )
            }
        }

        items(users.results) { result ->

            UserRowComposable(result)

        }
    }
}
