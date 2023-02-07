package com.jonas.tiskus.kmm.demo.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jonas.tiskus.kmm.demo.android.ui.theme.KmmdemoandroidTheme
import com.jonas.tiskus.kmm.demo.shared.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KmmdemoandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    com.jonas.tiskus.kmm.demo.android.Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Text(text = Greeting().greet())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KmmdemoandroidTheme {
        com.jonas.tiskus.kmm.demo.android.Greeting()
    }
}