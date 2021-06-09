package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
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
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Trash
import ui.models.Quote
import ui.theming.Purple500

@Composable
fun QuoteCard(quote: Quote, onDeleteClicked: () -> Unit) {

    val authorPic by quote.author.pic.collectAsState()

    Card {
//        Box(modifier = Modifier.fillMaxSize()){

//        }
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Text(
                quote.message,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(Modifier.height(4.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(authorPic, "Author image", modifier = Modifier.height(24.dp).width(24.dp).clip(CircleShape))
                    Spacer(Modifier.width(4.dp))
                    Text(quote.author.name, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.Gray)
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = {
                        onDeleteClicked()
                    }, modifier = Modifier.padding(0.dp)) {
                        Icon(
                            FontAwesomeIcons.Solid.Trash,
                            "Delete quote",
                            modifier = Modifier.size(15.dp, 15.dp).padding(0.dp),
                            tint = Purple500
                        )
                    }
                }
            }
        }
    }
}
