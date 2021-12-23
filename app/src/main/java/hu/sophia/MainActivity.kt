package hu.sophia

import android.graphics.Color
import android.graphics.Color.GRAY
import android.graphics.drawable.shapes.Shape
import androidx.compose.ui.graphics.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.sophia.ui.theme.SophiaTheme
import hu.sophia.ui.theme.themeColorBackground
import hu.sophia.ui.theme.themeTextColor
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SophiaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = themeColorBackground) {
                    SimpleContent(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SimpleContent(
    modifier: Modifier = Modifier,
) {
    var answer by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(true) }

    // todo: animate fade in of answer:
    // https://developer.android.com/jetpack/compose/animation

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(initialAlpha = 0f),
            //exit = fadeOut()
        ) {
            Text(
                text = answer,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontSize = 36.sp,
                fontWeight = FontWeight.W500,
                color = themeTextColor
            )
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = {
            visible = false
            answer = getRandomAnswer()
            visible = true
        }) {
            Text(
                text = "Segíts dönteni",
                fontSize = 24.sp
            )
        }
        Spacer(Modifier.weight(1f))
    }
}

fun getRandomAnswer(): String {
    val options = listOf(
        "Persze.",
        "Dehogyis.",
        "Talán...",
        "Kérdezd meg holnap.",
        "Erre Te is tudod a választ.",
        "Ötletem sincs.",
        "Bazsa erre mit mondana?",
        "Déjá vu-m van...",
        "Ezt te sem mondod komolyan.",
        "Az élet nagy kérdései...",
        "Ez ennél összetettebb...",
        "Ne gondold túl.",
        "Csak bártran!"
    )
    val index = Random.nextInt(0, options.size - 1)
    return options[index]
}


@Composable
fun OptionsContainer() {
    Column() {
        Spacer(Modifier.weight(1f))
        Box(
            Modifier
                .height(200.dp)
                .border(BorderStroke(2.dp, color = Gray), shape = RectangleShape)
        )
        {

            OptionsListComposable()
        }
        Spacer(Modifier.weight(1f))
    }

}

@Composable
fun ColorOverlay() {

}

@Composable
fun OptionsListComposable() {
    val options = listOf("igen", "nem", "talán...", "kérdezd meg holnap")
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(options) { option ->
            Text(
                text = option,
                modifier = Modifier.padding(48.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.W700

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SimpleContentPreview() {
    SophiaTheme {
        SimpleContent(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun OptionsContainerPreview() {
    OptionsContainer()
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SophiaTheme {
        OptionsListComposable()
    }
}