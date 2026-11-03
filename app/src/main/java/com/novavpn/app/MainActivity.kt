
package com.novavpn.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaVPNApp()
        }
    }
}

@Composable
fun NovaVPNApp() {
    var connected by remember { mutableStateOf(false) }

    val background = Color(0xFF090914)
    val purple = Color(0xFF9255FF)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(45.dp))

        Text(
            text = "NOVA VPN",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "YOUR PRIVACY. OUR PRIORITY.",
            color = Color.Gray,
            fontSize = 11.sp
        )

        Spacer(modifier = Modifier.height(90.dp))

        Box(
            modifier = Modifier
                .size(210.dp)
                .background(
                    Brush.radialGradient(
                        listOf(
                            purple.copy(alpha = 0.5f),
                            background
                        )
                    ),
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✦",
                color = Color.White,
                fontSize = 90.sp
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = if (connected) "Connected" else "Not connected",
            color = if (connected) Color(0xFF65E6A1) else Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { connected = !connected },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = purple
            )
        ) {
            Text(
                text = if (connected) "DISCONNECT" else "CONNECT",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "SERVER LOCATION",
            color = Color.Gray,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "🌍  Auto select",
            color = Color.White,
            fontSize = 17.sp
        )
    }
}
