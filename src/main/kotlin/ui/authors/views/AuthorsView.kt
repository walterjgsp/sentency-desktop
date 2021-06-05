package ui.authors

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.authors.viewmodels.AuthorViewModel
import ui.shared.views.LoadingView


@Composable
fun AuthorsView(viewModel: AuthorViewModel) {

    val currentAuthor by viewModel.currentAuthor.collectAsState()
    val loading by viewModel.loading.collectAsState()

    if (loading) {
        LoadingView()
    } else {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Authors here: ${currentAuthor?.name}")
            Spacer(Modifier.requiredHeight(15.dp))
            Button(onClick = {
                viewModel.toggleAuthor()
            }) {
                Text("Click to change Author")
            }
        }
    }
}


