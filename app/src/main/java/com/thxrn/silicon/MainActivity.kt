package com.thxrn.silicon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.withInfiniteAnimationFrameNanos
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorProperty
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
                Surface(modifier = Modifier.fillMaxSize()) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        CardRowStack(lp = 20, )
                    }
                }
            }
        }
    }
}

@Composable
fun PlayerCard(modifier: Modifier = Modifier, lp: Int = 20, rotation: Float = 90f){
    Surface(modifier = modifier.fillMaxSize()) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.rotate(rotation)
        ) {
            Text(
                    text = lp.toString(),
                    style = MaterialTheme.typography.titleLarge,
                )
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
fun CardRow(lp: Int = 20, modifier: Modifier = Modifier) {
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        PlayerCard(
            lp = lp,
            modifier = modifier,
            rotation = 90f
        )
        PlayerCard(
            lp = lp,
            modifier = modifier,
            rotation = -90f
        )
    }
}

@Preview
@Composable
fun CardRowPreview() {
    CardRow(lp = 20)
}

@Composable
fun CardRowStack(lp: Int = 20) {
    Column (modifier = Modifier.fillMaxSize()) {
        CardRow(lp = lp, modifier = Modifier.weight(.5f))
        CardRow(lp = lp, modifier = Modifier.weight(.5f))
    }
}

@Preview
@Composable
fun CardRowStackPreview() {
    SiliconTheme {
        CardRowStack(lp = 20)
    }
}
