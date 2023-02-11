package com.jonas.tiskus.kmm.demo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jonas.tiskus.kmm.demo.android.ui.theme.KmmdemoandroidTheme
import com.jonas.tiskus.kmm.demo.shared.domain.model.Fact
import com.jonas.tiskus.kmm.demo.shared.presentation.FactsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KmmdemoandroidTheme {
                FactsScreen()
            }
        }
    }
}

@Composable
fun FactsScreen(viewModel: FactsViewModel = viewModel()) {
    val state by viewModel.state.collectAsState(initial = FactsViewModel.FactsUiState())

    Box {
        if (state.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                itemsIndexed(state.facts) { index, item ->
                    Fact(fact = item, index = index + 1)
                }
                item {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { viewModel.reload() },
                            modifier = Modifier.align(Alignment.Center),
                            enabled = !state.isLoading
                        ) {
                            Text(text = "Refresh")
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Fact(
    modifier: Modifier = Modifier,
    fact: Fact,
    index: Int
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(
            text = "Fact #$index:",
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = fact.fact,
            modifier = modifier.fillMaxWidth()
        )
    }
}