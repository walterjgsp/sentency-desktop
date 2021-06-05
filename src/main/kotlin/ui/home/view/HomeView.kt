package ui.home.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.home.viewmodels.HomeViewModel
import ui.shared.views.LoadingView

@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    val currentQuote by homeViewModel.currentQuote.collectAsState()
    val loading by homeViewModel.loading.collectAsState()

    if (loading) {
        LoadingView()
    } else {

        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "\"${currentQuote?.message}\"",
                modifier = Modifier.padding(45.dp, 15.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic
            )
            Text("By ${currentQuote?.authorName}")
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {
                    homeViewModel.nextQuote()
                }, enabled = !loading
            ) {
                Text("Next One")
            }
        }
    }
}
