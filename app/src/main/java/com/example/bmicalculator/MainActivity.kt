package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.BMICalculatorTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMICalculator()
                }
            }
        }
    }
}

@Composable
fun BMICalculator() {
    var height = remember {
        mutableStateOf("")
    }
    var weight = remember {
        mutableStateOf("")
    }

    var bmi = remember {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BMI", fontSize = 100.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            Text(text = "Calculator", fontSize = 50.sp)
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = height.value, onValueChange = { input ->
                    height.value = input
                },
                placeholder = { Text(text = "Enter Height (CM)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(value = weight.value, onValueChange = { input ->
                weight.value = input
            }, placeholder = { Text(text = "Enter Weight(KG)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {height = height.value.toFloatOrNull()?:0f}, shape = RoundedCornerShape(8.dp)) {
Text(text = "Calculate BMI")

            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = bmi.value)
        }
    }
}

@Composable
fun CalculateBMI (height:Float, weight:Float):String{
    if (height<=0||weight<0) {return "Invalid input"}
else bmi = weight / (height/100).pow(2)
}