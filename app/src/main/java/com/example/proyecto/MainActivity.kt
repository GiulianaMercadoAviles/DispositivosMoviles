package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.ui.theme.ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().background(Color.Black),
                    color = Color.Transparent
                ) {
                    Greeting(
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Boton{
                    val intent= Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    @Composable
    fun Greeting(modifier: Modifier) {
        Column(
            modifier = modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GreetingText(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 90.dp, bottom = 16.dp))
        }
    }

    @Composable
    fun GreetingText(modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.descarga)

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Bienvenido",
                fontSize = 70.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                alpha = 1F,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Curso para aprender a Programar",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(36.dp)
            ) {
                Text(
                    text = "Rápido",
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(25.dp),
                    color = MaterialTheme.colorScheme.secondary
                )

                Text(
                    text = "Fácil",
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

            }
        }
    }


    @Composable
    fun Boton (onClick:()->Unit) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = onClick,
                modifier = Modifier.padding(32.dp)
            ) {
                Text("Iniciar")
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun PruebaPreview() {
        ProyectoTheme {

            GreetingText()
        }
    }
}

