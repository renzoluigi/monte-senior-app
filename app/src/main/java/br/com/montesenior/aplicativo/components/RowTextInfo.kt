package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowTextInfo(info1: String, info2: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = info1, fontSize = 18.sp)
        Text(
            text = info2,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
            textAlign = TextAlign.End,
            color = Color.Gray,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}