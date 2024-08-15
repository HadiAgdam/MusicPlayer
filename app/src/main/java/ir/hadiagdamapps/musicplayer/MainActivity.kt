package ir.hadiagdamapps.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hadiagdamapps.musicplayer.ui.theme.MusicPlayerTheme
import ir.hadiagdamapps.musicplayer.ui.theme.darkBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicPlayerTheme {

                MainScreen()

            }
        }
    }
}


@Composable
fun MusicContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(darkBackground)
            .fillMaxSize()
            .padding(16.dp)
    ) {


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "All songs",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
            )
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.shuffle_random_icon),
                        contentDescription = "shuffle icon",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.sort_icon),
                        contentDescription = "shuffle icon",
                        tint = Color.White
                    )
                }
            }
        }


    }
}


@Composable
fun TopSearchBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(86.dp)
            .fillMaxWidth()
            .background(Color.Black)
    ) {

    }
}

@Composable
fun MainScreen() {
    Surface {
        Scaffold(
            topBar = {
                TopSearchBar()
            }
        ) {
            MusicContainer(modifier = Modifier.padding(it))
        }
    }
}


@Preview
@Composable
fun Preview() {
    MainScreen()
}


