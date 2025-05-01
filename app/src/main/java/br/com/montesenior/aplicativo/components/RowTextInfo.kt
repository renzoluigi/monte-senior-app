package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun RowTextInfo(info1: String, info2: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = info1,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = info2,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
            textAlign = TextAlign.End,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}