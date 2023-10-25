package com.valorantproject.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.valorantproject.core.common.extension.parseHexColor
import com.valorantproject.core.network.model.Data

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AgentCardItem(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    elevation: CardElevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    data: Data,
    onCardClicked: () -> Unit,
) {
    Card(
        onClick = onCardClicked,
        modifier = modifier,
        shape = shape,
        elevation = elevation,
    ) {
        Box(
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(data.backgroundGradientColors[0]?.parseHexColor()!!),
                                Color(data.backgroundGradientColors[1]?.parseHexColor()!!),
                                Color(data.backgroundGradientColors[2]?.parseHexColor()!!),
                                Color(data.backgroundGradientColors[3]?.parseHexColor()!!),
                            ),
                        )
                    )
                }
                .fillMaxSize()
        ) {
            AsyncImage(
                model = data.background,
                contentDescription = "Agent Logo Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
            AsyncImage(
                model = data.fullPortrait,
                contentDescription = "Agent Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}