package hu.sophia

import android.graphics.Color
import android.graphics.Color.GRAY
import android.graphics.drawable.shapes.Shape
import androidx.compose.ui.graphics.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.sophia.ui.theme.SophiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SophiaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OptionsContainer()
                }
            }
        }
    }
}

@Composable
fun OptionsContainer() {
    Column() {
        Spacer(Modifier.weight(1f))
        Box(
            Modifier
                .height(200.dp)
                .border(BorderStroke(2.dp, color = Gray), shape = RectangleShape))
        {

            OptionsListComposable()
        }
        Spacer(Modifier.weight(1f))
    }

}

@Composable
fun ColorOverlay(){

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
fun OptionsContainerPreview(){
    OptionsContainer()
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SophiaTheme {
        OptionsListComposable()
    }
}