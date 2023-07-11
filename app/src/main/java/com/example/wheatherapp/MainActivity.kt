package com.example.wheatherapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.wheatherapp.screens.MainCard
import com.example.wheatherapp.screens.TabLayout
import com.example.wheatherapp.ui.theme.WheatherAppTheme
import com.android.volley.Request

const val API_KEY = "99f09e8bb77b4d029a0105010231107"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WheatherAppTheme {
                getData("London",this)
                Image(
                    painter = painterResource(id = R.drawable.ic_weather),
                    contentDescription = "im1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.6f),
                    contentScale = ContentScale.FillBounds
                )
                Column{
                    MainCard()
                    TabLayout()
                }

            }
        }
    }
}

private fun getData (city: String, context: Context){
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$API_KEY"+
            "&q=$city"+
            "&days="+
            "3"+
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
                response ->
            Log.d("MyLog", "Response: $response")
        },
        {
            Log.d("MyLog", "VolleyError: $it")
        }
    )
    queue.add(sRequest)



}
