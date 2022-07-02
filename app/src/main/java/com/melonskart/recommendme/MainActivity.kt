package com.melonskart.recommendme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melonskart.recommendme.ui.theme.RecommendMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecommendMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val image = painterResource(id = R.drawable.androidparty)

                    RecommendMeWithImage(image, stringResource(R.string.message),
                        stringResource(R.string.message_from)
                    )

                }
            }
        }
    }
}

@Composable
fun RecommendMeWithText(name: String, from: String) {
    Column() {
        Text(
            text = stringResource(R.string.happy_birthday_text) + name,
            fontSize = 36.sp,
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = "- $from",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )

    }
}

@Composable
fun RecommendMeWithImage(painter: Painter , name: String, from: String) {
    Box {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxHeight()
                .fillMaxWidth(),

            contentScale = ContentScale.Crop
        )
        RecommendMeWithText(name = name, from = from)
    }
}

@Preview(showBackground = true, name = "RecommendMePreview" , showSystemUi = true)
@Composable
fun RecommendMePreview() {
    val image = painterResource(id = R.drawable.androidparty)
    RecommendMeTheme {
        RecommendMeWithImage(image, stringResource(R.string.message),
                    stringResource(R.string.message_from)
                )
    }
}