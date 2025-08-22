package com.thxrn.silicon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.withInfiniteAnimationFrameNanos
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.thxrn.silicon.ui.theme.SiliconTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SiliconTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CardRowStack(lp = 20, innerPadding)
                }
            }
        }
    }
}

@Composable
fun PlayerCard(modifier: Modifier = Modifier, lp: Int = 20){
    Surface(modifier = modifier) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = lp.toString(),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(2.dp).width(30.dp))
            Text(
                text = "❤",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Preview
@Composable
fun PlayerCardPreview() {
    SiliconTheme {
        PlayerCard(lp = 20)
    }
}

@Composable
fun CardRow(lp: Int = 20, padding: PaddingValues) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        PlayerCard(
            lp = lp,
            modifier = Modifier.padding(padding)
        )
        Spacer(Modifier.width(5.dp))
        PlayerCard(
            lp = lp,
            modifier = Modifier.padding(padding)
        )
    }
}

@Preview
@Composable
fun CardRowPreview() {
    CardRow(lp = 20, padding = PaddingValues(5.dp))
}

@Composable
fun CardRowStack(lp: Int = 20, padding: PaddingValues) {
    Column (Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly) {
        CardRow(lp = 20, padding = padding)
        CardRow(lp = 20, padding = padding)
    }
}

@Preview
@Composable
fun CardRowStackPreview() {
    SiliconTheme {
        CardRowStack(lp = 20, padding = PaddingValues(10.dp))
    }
}
