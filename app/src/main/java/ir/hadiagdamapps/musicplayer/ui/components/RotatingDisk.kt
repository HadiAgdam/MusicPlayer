package ir.hadiagdamapps.musicplayer.ui.components

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Handler
import android.text.BoringLayout
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ir.hadiagdamapps.musicplayer.R
import ir.hadiagdamapps.musicplayer.ui.theme.lightBackground
import ir.hadiagdamapps.musicplayer.ui.theme.primary


@Composable
fun RotatingDisk(
    modifier: Modifier = Modifier,
    progress: Float,
    image: Uri?,
) {

    val rotationAngle = progress * 360f * 13


    Box(
        modifier = modifier
            .size(320.dp)
            .clip(CircleShape.copy(CornerSize(100)))
            .background(Color.White)
            .padding(3.dp)
            .clip(CircleShape.copy(CornerSize(100)))
            .background(lightBackground), contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator(
            progress = progress / 2,
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            strokeWidth = 4.dp,
            color = primary
        )

        Image(
            // TODO implement the image here
            // TODO also implement a default image
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "album image",
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .clip(CircleShape.copy(CornerSize(100)))
                .graphicsLayer(rotationZ = rotationAngle)
        )

    }

}
