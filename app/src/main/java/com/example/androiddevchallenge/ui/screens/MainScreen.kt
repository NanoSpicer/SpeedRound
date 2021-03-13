package com.example.androiddevchallenge.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MySootheSearch
import com.example.androiddevchallenge.ui.theme.TextCaption
import com.example.androiddevchallenge.ui.theme.TextH2
import com.example.androiddevchallenge.ui.theme.TextH3
import com.example.androiddevchallenge.ui.theme.gray800
import com.example.androiddevchallenge.ui.theme.mdSpacing
import com.example.androiddevchallenge.ui.theme.smSpacing
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.white800
import com.example.androiddevchallenge.ui.utils.BackgroundLayer

@Composable
fun MainScreen(
    favouriteCollection: Pair<List<Pair<Int, String>>, List<Pair<Int, String>>>,
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
                    val (firstRow, secondRow) = favouriteCollection
                    LazyRow() {
                        items(firstRow, key = { (_, l) -> l }) { (drawable, label) ->
                            FavoriteCollection(modifier = Modifier.padding(end = smSpacing), imageId = drawable, label = label)
                        }
                    }
                    LazyRow(modifier = Modifier.padding(top = smSpacing)) {
                        items(secondRow, key = { (_, l) -> l }) { (drawable, label) ->
                            FavoriteCollection(modifier = Modifier.padding(end = smSpacing), imageId = drawable, label = label)
                        }
                    }
                }
            }
            Row {
                HomeSection(title ="Align your body") {
                    LazyRow(modifier = Modifier.height(112.dp)){
                        items(alignYourBody) { (drawable, label) ->
                            Collection(modifier = Modifier.padding(end = smSpacing), imageId = drawable, label = label)
                        }
                    }
                }
            }
            Row {
                HomeSection(title ="Align your mind") {
                    LazyRow(modifier = Modifier.height(112.dp)){
                        items(alignYourMind) { (drawable, label) ->
                            Collection(modifier = Modifier.padding(end = smSpacing), imageId = drawable, label = label)
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
                    FloatingActionButton(backgroundColor= MaterialTheme.colors.primary, onClick = {  }) {
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
fun FavoriteCollection(modifier: Modifier = Modifier, @DrawableRes imageId: Int, label: String) {
    val cardHeight = 56.dp
    val img = painterResource(id = imageId)
    val colors = if(isSystemInDarkTheme()) {
        TextFieldDefaults.textFieldColors()
    }else {
        TextFieldDefaults.textFieldColors(
            textColor = gray800,
            backgroundColor = white800
        )
    }
    Row(
        modifier =
        modifier
            .clip(MaterialTheme.shapes.small)
            .background(colors.backgroundColor(true).value)
            .width(192.dp)
            .height(cardHeight),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(cardHeight),
            painter = img,
            contentDescription = "A favourite collection of $label",
            contentScale = ContentScale.FillBounds
        )
        TextH3(modifier = Modifier.padding(smSpacing), text = label)
    }
}


@Composable
fun Collection(modifier: Modifier = Modifier, @DrawableRes imageId: Int, label: String) {
    val img = painterResource(id = imageId)

    Column(
        modifier = modifier
            .wrapContentHeight()
            .width(88.dp)
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

        TextH3(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = smSpacing),
            text = label,
            textAlign = TextAlign.Center
        )

    }
}
