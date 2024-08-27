package ir.hadiagdamapps.musicplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hadiagdamapps.musicplayer.R
import ir.hadiagdamapps.musicplayer.models.Artist
import ir.hadiagdamapps.musicplayer.models.Song
import ir.hadiagdamapps.musicplayer.ui.theme.darkBackground


@Composable
fun SongItem(
    modifier: Modifier = Modifier,
    model: Song,
    onLikeClick: () -> Unit,
    onClick: () -> Unit,
    liked: Boolean
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(8.dp)
    ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() }) {

            Row {
                Image(
                    modifier = modifier.clip(RoundedCornerShape(16)),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Image"
                )
                Column(
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = model.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                    Text(
                        text = model.artist.name, fontSize = 14.sp, color = Color.Gray
                    )
                }
            }


            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxHeight()
            ) {
                Icon(painter = painterResource(
                    id = if (liked) R.drawable.favorite_filled_icon
                    else R.drawable.favorite_border_icon
                ),
                    tint = if (liked) Color.Red
                    else Color.White,
                    contentDescription = "like Icon",
                    modifier = modifier
                        .size(23.dp)
                        .clickable {
                            onLikeClick()
                        })

                Spacer(modifier = modifier.width(16.dp))

                Icon(
                    painter = painterResource(id = R.drawable.more_icon),
                    tint = Color.White,
                    contentDescription = "options",
                    modifier = modifier.size(24.dp)
                )
            }

        }

    }

}



@Preview
@Composable
fun SongPreview() {

    val m = Song(
        image = "",
        name = "Name",
        artist = Artist.parse("Artist")!!,
    )

    Column(
        modifier = Modifier
            .background(darkBackground)
            .fillMaxSize()
    ) {
        for (i in 0 until 10) SongItem(model = m, onLikeClick = {}, onClick = {}, liked = false)
    }
}
