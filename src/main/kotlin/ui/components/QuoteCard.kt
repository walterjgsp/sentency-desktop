package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ui.models.Quote

@Composable
fun QuoteCard(quote: Quote) {
    Card {
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Text(quote.message, maxLines = 2, overflow = TextOverflow.Ellipsis, modifier = Modifier.height(40.dp))
            Text(quote.author.name, modifier = Modifier.align(Alignment.End), fontWeight = FontWeight.Bold)
        }
    }
}
