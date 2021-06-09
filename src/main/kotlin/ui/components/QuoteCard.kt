package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Times
import ui.models.Quote

@Composable
fun QuoteCard(quote: Quote, onDeleteClicked: () -> Unit) {

    val authorPic by quote.author.pic.collectAsState()

    Card {
        Box(modifier = Modifier.fillMaxSize()){
            IconButton(onClick = {
                onDeleteClicked()
            }, modifier = Modifier.align(Alignment.TopEnd).padding(0.dp)) {
                Icon(
                    FontAwesomeIcons.Solid.Times,
                    "Delete quote",
                    modifier = Modifier.size(15.dp, 15.dp).padding(0.dp),
                    tint = Color.Gray
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(authorPic, "Author image", modifier = Modifier.height(36.dp).width(36.dp).clip(CircleShape))
                Spacer(Modifier.width(4.dp))
                Text(quote.author.name, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(4.dp))
            Row {
                Text(quote.message, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}
