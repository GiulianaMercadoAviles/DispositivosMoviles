package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto.ui.theme.ProyectoTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().background(Color.Black),
                    color = Color.Transparent
                ) {
                    Greeting(
                        modifier = Modifier
                            .padding(8.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize().wrapContentSize()
        ,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Cuestionario",
            fontSize = 23.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(2.dp)
        )
        TextFieldComponente()
        Spacer(modifier = Modifier.height(6.dp))
        CheckboxComponente()
        Spacer(modifier = Modifier.height(6.dp))
        SliderComponente()
        Spacer(modifier = Modifier.height(6.dp))
        RadioButtonComponente()
        Spacer(modifier = Modifier.height(6.dp))
        SwitchComponente()
    }
}

@Composable
fun TextFieldComponente(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }


    Column(
        modifier = modifier
    ) {
        Text(
            text = "Ingresa tu Nombre:",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .padding(5.dp)
        )

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre")},

            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ingresa tu Fecha de Nacimiento",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .padding(5.dp)
        )

        OutlinedTextField(
            value = fechaNacimiento,
            onValueChange = { fechaNacimiento = it },
            label = { Text("DD/MM/YYYY") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)

        )
    }
}

@Composable
fun CheckboxComponente(modifier: Modifier = Modifier) {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }
    var checked3 by remember { mutableStateOf(false) }

    Column {

        Text(
            text = "¿Qué te interesaría aprender?",
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked1,
                onCheckedChange = { checked1 = it }
            )
            Text(
                text ="Desarrollo de Paginas Web",
                color = Color.White)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked2,
                onCheckedChange = { checked2 = it }
            )
            Text(
                text ="Ciencia de Datos",
                color = Color.White
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked3,
                onCheckedChange = { checked3 = it }
            )
            Text(
                text = "Desarrollo de Videojuegos",
                color = Color.White)
        }
    }
}

@Composable
fun SliderComponente() {
    val valores = listOf("Principiante", "Intermedio", "Avanzado")
    var sliderPosition by remember { mutableStateOf(0f)
    }
    Column {
        Text(
            text = "Nivel de Conocimiento",
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..(valores.size - 1).toFloat(),
            steps = valores.size - 2
        )

        Text(text = " ${valores[sliderPosition.toInt()]}", color = Color.White)
    }
}

@Composable
fun RadioButtonComponente(modifier: Modifier = Modifier) {
    val radioOptions = listOf("Estudiante de instituto", "Estudiante de universidad", "Otro")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(modifier.selectableGroup()) {
        Text(
            text = "Seleccionar la situción que te describa mejor",
            color = Color.White,
            fontSize = 18.sp,
        )
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
fun SwitchComponente(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Aceptar terminos y condiciones",
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}