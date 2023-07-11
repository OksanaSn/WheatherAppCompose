package com.example.wheatherapp.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wheatherapp.ui.theme.PinkLight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherapp.data.WeatherModel


@Composable
fun ListItem(item: WeatherModel) {
    androidx.compose.material.Card(

        modifier = Modifier
            .fillMaxWidth().padding(all = 3.dp),
        backgroundColor = PinkLight,
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier.padding(
                    start = 8.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
            ) {
                Text(
                    text = item.time,
                    style = TextStyle(fontSize = 15.sp),
                    color = Color.White
                )
                Text(
                    text = item.condition,
                    style = TextStyle(fontSize = 15.sp),
                    color = Color.White
                )
            }
            Text(
                text = item.currentTemp.ifEmpty{"${item.maxTemp}/${item.minTemp}"},
                style = TextStyle(fontSize = 25.sp),
                color = Color.White
            )
            AsyncImage(
                model = "https:${item.icon}",
                contentDescription = "im5",
                modifier = Modifier
                    .size(35.dp)
                    .padding(
                        end = 8.dp)
            )
        }

    }
}