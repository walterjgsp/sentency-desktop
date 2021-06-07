package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.unit.dp
import ui.models.Author

@Composable
fun AuthorCard(author: Author) {
    Card(modifier = Modifier.clickable {  }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(author.pic, "Author image", modifier = Modifier.height(50.dp).width(50.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Text(author.name)
        }
    }
}
