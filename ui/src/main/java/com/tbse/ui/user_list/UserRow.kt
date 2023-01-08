package com.tbse.ui.user_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tbse.domain.models.*
import java.time.LocalDate
import java.util.*
import kotlin.random.Random

/**
 * Created by toddsmith on 1/7/23.
 */
@Composable
fun UserRowComposable(
    userInfo: UserInfo,
) {
    Card(
        modifier = Modifier
            .background(
                color = Color.LightGray
            )
            .padding(
                start = 10.dp,
                top = 10.dp,
                end = 10.dp,
                bottom = 10.dp,
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.DarkGray
                )
                .padding(10.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(userInfo.picture.large)
                    .crossfade(true)
                    .build(),
                contentDescription = "user image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(text = "${userInfo.name.first} ${userInfo.name.last}")
                Text(
                    text = userInfo.email,
                    fontSize = 12.sp
                )
                Text(
                    text = userInfo.phone,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun UserRowComposablePreview(
    @PreviewParameter(UserInfoProvider::class) userInfo: UserInfo,
) {
    UserRowComposable(userInfo = userInfo)
}

class UserInfoProvider : PreviewParameterProvider<UserInfo> {
    override val values: Sequence<UserInfo>
        get() = generateSequence {
            UserInfo(
                cell = "cell",
                dob = Dob(
                    date = LocalDate.now().toString(),
                    age = Random.nextInt(),
                ),
                email = "email",
                gender = "gender",
                id = Id(
                    name = "name",
                    value = "value",
                ),
                location = Location(
                    city = "city",
                    coordinates = Coordinates(
                        latitude = "1",
                        longitude = "2",
                    ),
                    country = "country",
                    postcode = "pc",
                    state = "state",
                    street = Street(
                        name = "street name",
                        number = 123,
                    ),
                    timezone = Timezone(
                        description = "TZ",
                        offset = "-5",
                    )
                ),
                login = Login(
                    md5 = "md5",
                    password = "pw",
                    salt = "salt",
                    sha1 = "sha1",
                    sha256 = "sha256",
                    username = "username",
                    uuid = UUID.randomUUID().toString(),
                ),
                name = Name(
                    first = "first name",
                    last = "last name",
                    title = "Mr.",
                ),
                nat = "nat",
                phone = "phone",
                picture = Picture(
                    large = "l",
                    medium = "m",
                    thumbnail = "tn",
                ),
                registered = Registered(
                    age = Random.nextInt(),
                    date = LocalDate.now().toString(),
                )
            )
        }

}