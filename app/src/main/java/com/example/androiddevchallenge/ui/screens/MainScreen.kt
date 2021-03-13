package com.example.androiddevchallenge.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySootheEmail
import com.example.androiddevchallenge.ui.theme.MySootheSearch
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.PrimaryButton
import com.example.androiddevchallenge.ui.theme.SecondaryButton
import com.example.androiddevchallenge.ui.theme.TextBody1
import com.example.androiddevchallenge.ui.theme.TextCaption
import com.example.androiddevchallenge.ui.theme.TextH2
import com.example.androiddevchallenge.ui.theme.TextH3
import com.example.androiddevchallenge.ui.theme.lgSpacing
import com.example.androiddevchallenge.ui.theme.mdSpacing
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.smSpacing
import com.example.androiddevchallenge.ui.theme.taupe100
import com.example.androiddevchallenge.ui.theme.taupe800
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.utils.BackgroundLayer

@Composable
fun MainScreen(
    favouriteCollection: List<Pair<Int, String>>,
    alignYourBody: List<Pair<Int, String>>,
    alignYourMind: List<Pair<Int, String>>
)  {
    BackgroundLayer {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(mdSpacing),
        ) {
            Row {
                MySootheSearch(label = "Search", onTextChange = { })
            }

            Row {
                HomeSection(title ="Favourite Collections") {
                    // Splitn in two
                    LazyRow() {
                        items(favouriteCollection) { (drawable, label) ->
                            Collection(imageId = drawable, label = label)
                        }
                    }
                }
            }
            Row {
                HomeSection(title ="Align your body") {
                    LazyRow(modifier = Modifier.height(112.dp)){
                        items(alignYourBody) { (drawable, label) ->
                            Collection(imageId = drawable, label = label)
                        }
                    }
                }
            }
            Row {
                HomeSection(title ="Align your mind") {
                    LazyRow(modifier = Modifier.height(112.dp)){
                        items(alignYourMind) { (drawable, label) ->
                            Collection(imageId = drawable, label = label)
                        }
                    }
                }
            }

        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Box {
                BottomNavigation(
                    elevation = 8.dp,
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    val spa = painterResource(id = R.drawable.ic_spa)
                    val acc = painterResource(id = R.drawable.ic_account)

                    BottomNavigationItem(
                        icon = { Icon(spa, "Go to home page", modifier = Modifier.size(18.dp)) },
                        label = { TextCaption(text = "Home") },
                        selected = true,
                        onClick = {}
                    )

                    BottomNavigationItem(
                        icon = { Icon(acc, "Go to your account", modifier = Modifier.size(18.dp)) },
                        label = { TextCaption(text = "Profile") },
                        selected = true,
                        onClick = {}
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 0.dp, y = (-26).dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val play = painterResource(id = R.drawable.ic_play_arrow)
                    FloatingActionButton(onClick = {  },) {
                        Icon(play, "Play")
                    }
                }
            }
        }

    }
}



@Composable
fun HomeSection(title: String, content: @Composable () -> Unit) {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp), verticalAlignment = Alignment.Bottom) {
            TextH2(text = title)
        }
        content()
    }
}



@Composable
fun FavoriteCollection(@DrawableRes imageId: Int, label: String) {
    val smCorners = 8.dp
    val cardHeight = 56.dp
    val img = painterResource(id = imageId)
    Row(
        modifier = Modifier
            .background(white)
            .width(192.dp)
            .height(cardHeight)
            .clip(MaterialTheme.shapes.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier =
            Modifier
                .size(cardHeight)
                .clip(RoundedCornerShape(smCorners, 0.dp, 0.dp, smCorners)),
            painter = img,
            contentDescription = "A favourite collection of $label",
            contentScale = ContentScale.FillBounds
        )
        TextH3(modifier = Modifier.padding(mdSpacing), text = label)
    }
}


@Composable
fun Collection(@DrawableRes imageId: Int, label: String) {
    val smCorners = 8.dp
    val cardHeight = 56.dp
    val img = painterResource(id = imageId)

    Column(
        modifier = Modifier.wrapContentSize()
    ) {
        Image(
            modifier =
            Modifier
                .size(88.dp)
                .clip(CircleShape),
            painter = img,
            contentDescription = "A favourite collection of $label",
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier
                .height(24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            TextH3(modifier = Modifier.padding(mdSpacing), text = label)
        }

    }
}
