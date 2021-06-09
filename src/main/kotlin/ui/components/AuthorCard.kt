package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ui.models.Author

@Composable
fun AuthorCard(author: Author) {

    val authorPic by author.pic.collectAsState()

    Card(modifier = Modifier.clickable { }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(authorPic, "Author image", modifier = Modifier.height(50.dp).width(50.dp).clip(CircleShape))
            Spacer(modifier = Modifier.width(5.dp))
            Text(author.name)
        }
    }
}
